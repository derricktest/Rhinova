package rhinova.metapopulation.model.optimise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;

import rhinova.framework.binding.ModelBindingClass;
import rhinova.metapopulation.model.components.link.Link;
import rhinova.metapopulation.model.components.link.LinkList;
import rhinova.metapopulation.model.components.reserve.Reserve;
import rhinova.metapopulation.model.components.reserve.ReserveList;
import rhinova.metapopulation.model.optimise.results.OptimisedResultLink;
import rhinova.metapopulation.model.optimise.results.OptimisedResultSet;
import scpsolver.constraints.LinearBiggerThanEqualsConstraint;
import scpsolver.constraints.LinearSmallerThanEqualsConstraint;
import scpsolver.lpsolver.LinearProgramSolver;
import scpsolver.lpsolver.SolverFactory;
import scpsolver.problems.LinearProgram;
import util.SerializeTools;
import util.SymbolicVariable;

public class Optimiser extends ModelBindingClass implements ApplicationListener<OptimiseEvent> {

	LinkList 						linkList;
	ReserveList 					reserveList;
	private double 					tolerance = 0.001;		// TODO implement the tollearance

	@Autowired
	ApplicationEventPublisher 		publisher;
	OptimisedResultSet 				optimisedResultSet;
		
	public double getTolerance() {		return tolerance;	}

	public void setTolerance(double tolerance) {
		firePropertyChange(
				"tolerance",
				this.tolerance,
				this.tolerance = tolerance);
	}


	private static String symbolicVariableName(int year, int res1, int res2, int link ) {
		return "Y"+year+"R"+res1+"R"+res2+"L"+link;
	}
	
	public void solve(int years) {
		this.numberOfYears = years;
		this.solve();
	}

	
	public void solve() {
		
		SymbolicVariable.reset();
		
		int years = this.numberOfYears;
		int noReserves = reserveList.size();
		
		
		// Map to reference LP Values which uses the name of the corresponding symbolic variable
		Map<String, OptimisedResultLink> variablesMap = new HashMap<String, OptimisedResultLink>();
		/** Create all symbolic variable names : this step is needed as all the variables must exist
		 * before creating the linear problem*/
		for (int y=1; y<=years; y++){
			for (int i=0; i<this.linkList.size(); i++) {
				Link link = this.linkList.get(i);
				// create the variable names
				String name = "";

				// first name (reserve1 to reserve2)
				name = symbolicVariableName(y,link.getReserve1No(),link.getReserve2No(),link.getId());
				SymbolicVariable.addVariableName(name);
				variablesMap.put(name, new OptimisedResultLink(link, 0.0, y, link.getReserve1(), link.getReserve2()));

				// second name (reserve2 to reserve1)
				name = symbolicVariableName(y,link.getReserve2No(),link.getReserve1No(),link.getId());
				SymbolicVariable.addVariableName(name);
				variablesMap.put(name,new OptimisedResultLink(link, 0.0, y, link.getReserve2(), link.getReserve1()));
			}
		}
		


		// Reserve Populations
		SymbolicVariable[] reservePopulations = new SymbolicVariable[this.reserveList.size()];

		// Initial Populations
		for (int i=0; i<this.reserveList.size(); i++) {
			reservePopulations[i] = new SymbolicVariable(this.reserveList.get(i).getInitialPopulation());
		}






		/** Linear Problem **/
		/** Objective Function */
		LinearProgram lp = constructObjectiveFunction(years);

		// Constraints
		for (int y=1; y<=years; y++) {
			for (int r=0; r<noReserves; r++) {
				Reserve reserve = this.reserveList.get(r);

				// links on reserve
				List<Link> links = this.linkList.getLinksOnReserve(reserve);

				// reserve LP population
				SymbolicVariable leaving = new SymbolicVariable();
				SymbolicVariable arriving = new SymbolicVariable();

				for (Link link : links) {

					int awayReserveNo=-1; 
					if (reserve.getId()==link.getReserve1No()) {
						awayReserveNo=link.getReserve2No();
					} else {
						awayReserveNo=link.getReserve1No();
					}

					// leaving
					String leavingName = symbolicVariableName(y,reserve.getId(),awayReserveNo,link.getId());
					SymbolicVariable leavingVariable = new SymbolicVariable(leavingName,1.0);
					leaving = leaving.add(leavingVariable);
					
					// Positive constraint
					lp.addConstraint(new LinearBiggerThanEqualsConstraint(
							leavingVariable.getAsArray(),
							0.0,
							leavingName+"MIN"));
					// Link capacity constraint

					if (inforceLinkCapacity) {
						lp.addConstraint(new LinearSmallerThanEqualsConstraint(
								leavingVariable.getAsArray(),
								link.getCapacity(),
								leavingName+"MIN"));
					}
					
					// arriving
					String arrivingName = symbolicVariableName(y,awayReserveNo,reserve.getId(),link.getId());
					
					double survivalRate;
					if (this.inforceLinkSurvivalRates) {
						survivalRate = link.getSurvivalRate();
					} else {
						survivalRate = 1.0;
					}
					SymbolicVariable arrivingVariable = new SymbolicVariable(arrivingName, survivalRate);
					arriving = arriving.add(arrivingVariable);
					// no need to re-do link constraints

				}

				/** Adjust the populations */

				// leaving
				reservePopulations[r] = reservePopulations[r].subtract(leaving);

				// minimum population constraint
				double minPopulation;
				if (this.inforceMinPopulationConstraint) {
					minPopulation = reserve.getMinPopulation();
				} else {
					minPopulation = 0.0;
				}


				lp.addConstraint(new LinearBiggerThanEqualsConstraint(
						reservePopulations[r].getAsArray(),
						minPopulation-reservePopulations[r].getNumber(),
						"Y"+y+"R"+reserve.getId()+"MIN"));

				// arriving
				reservePopulations[r] = reservePopulations[r].add(arriving).multiply(reserve.getRegenerationRate());

				// maximum population constraint
				if (this.inforceMaxPopulation){

					lp.addConstraint(new LinearSmallerThanEqualsConstraint(
							reservePopulations[r].getAsArray(),
							reserve.getMaxPopulation()-reservePopulations[r].getNumber(),
							"Y"+y+"R"+reserve.getId()+"MAX"));
				}
			}
		}


		/** Solve the linear program */
		LinearProgramSolver solver  = SolverFactory.newDefault();
		lp.setMinProblem(false);
		double[] sol = solver.solve(lp);


		/** Convert the sol[] array back to symbolic variables*/
		setVariableValues(sol, variablesMap);

		/** creating the result set **/
		OptimisedResultSet resultSet = getResultSet(years, variablesMap, this.tolerance);
		
		resultSet.printAllYears();
		
		this.optimisedResultSet = resultSet;
		
		this.publisher.publishEvent(new OptimisedAction(this, resultSet));
	}
	

	/**
	 * @param years - number of years to solve for
	 * @param filePath - path to save solution
	 */
	public void solveSave(int years, String filePath) {
		
		this.numberOfYears = years;
		this.solve();

		/** Saving to file if the path is not null**/
		if (filePath == null) {
			return;
		} else if (filePath.length() == 0) {
			return;
		}
		SerializeTools.save(filePath, this.optimisedResultSet);
	}

	
	private void setVariableValues(double[] sol, Map<String, OptimisedResultLink> variablesMap) {
		for (int i=0; i<sol.length; i++) {
			// Symbolic representation
			String name = SymbolicVariable.getKeysList().get(i);
			double value = sol[i];
			// SymbolicVariable symbolicVariable = new SymbolicVariable(name, value);
			
			OptimisedResultLink entry = variablesMap.get(name);
			System.out.println(name + "\t" + value);
			entry.setValue(value);
		}
	}
	
	
	
	private OptimisedResultSet getResultSet(int years,  Map<String, OptimisedResultLink> variablesMap, double tolerance){
		OptimisedResultSet resultSet = new OptimisedResultSet(years);
		
		for (Entry<String, OptimisedResultLink> entry : variablesMap.entrySet()) {
			if (Math.abs(entry.getValue().getValue())<=tolerance) {
				entry.getValue().setValue(0.0);
			}
			resultSet.addSimulatedResultLink(entry.getValue());
		}
		return resultSet;
	}
	
	

	/**
	 * Method to construct the Linear Program
	 * @param years
	 * @return
	 */
	private LinearProgram constructObjectiveFunction(int years) {
		
		int noReserves = reserveList.size();

		// Reserve Populations
		SymbolicVariable[] reservePopulations = new SymbolicVariable[this.reserveList.size()];

		// Initial Populations
		for (int i=0; i<this.reserveList.size(); i++) {
			reservePopulations[i] = new SymbolicVariable(this.reserveList.get(i).getInitialPopulation());
		}

		for (int y=1; y<=years; y++) {
			for (int r=0; r<noReserves; r++) {
				Reserve reserve = this.reserveList.get(r);

				// links on reserve
				List<Link> links = this.linkList.getLinksOnReserve(reserve);

				// reserve LP population
				SymbolicVariable leaving = new SymbolicVariable();
				SymbolicVariable arriving = new SymbolicVariable();

				for (Link link : links) {

					int awayReserveNo=-1; 
					if (reserve.getId()==link.getReserve1No()) {
						awayReserveNo=link.getReserve2No();
					} else {
						awayReserveNo=link.getReserve1No();
					}

					// leaving
					String leavingName = symbolicVariableName(y,reserve.getId(),awayReserveNo,link.getId());
					SymbolicVariable leavingVariable = new SymbolicVariable(leavingName,1.0);
					leaving = leaving.add(leavingVariable);

					// arriving
					String arrivingName = symbolicVariableName(y,awayReserveNo,reserve.getId(),link.getId());
					SymbolicVariable arrivingVariable = new SymbolicVariable(arrivingName, link.getSurvivalRate());
					arriving = arriving.add(arrivingVariable);

				}

				/** Adjust the populations */
				// leaving
				reservePopulations[r] = reservePopulations[r].subtract(leaving);

				// arriving and regenerate
				reservePopulations[r] = reservePopulations[r].add(arriving).multiply(reserve.getRegenerationRate());
			}
		}

		// Add all populations together which is the objective function
		SymbolicVariable totalPopulation = new SymbolicVariable();
		for (SymbolicVariable population : reservePopulations){
			totalPopulation = totalPopulation.add(population);
		}
		
		LinearProgram lp = new LinearProgram(totalPopulation.getAsArray());
		
		return lp;
	}

	@Override
	public void onApplicationEvent(OptimiseEvent arg0) {
		
		// checking for logical errors
		if (reserveList.size()==0) {
			JOptionPane.showMessageDialog(null, "You cannot optimise with 0 reserves!"	, "Cannot Optimise!",  JOptionPane.ERROR_MESSAGE);
			return;
		} else if (linkList.size()==0) {
			JOptionPane.showMessageDialog(null, "You cannot optimise with 0 links!"	, "Cannot Optimise!",  JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		this.solve();
	}
	
	public void setReserveList(ReserveList reserveList) {
		this.reserveList = reserveList;
	}
	
	public void setLinkList(LinkList linkList) {
		this.linkList = linkList;
	}

	
}
