package rhinova.metapopulation.model.simulate;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;

import rhinova.framework.binding.ModelBindingClass;
import rhinova.metapopulation.model.graphicx.PictureFactory;
import rhinova.metapopulation.model.optimise.OptimisedAction;
import rhinova.metapopulation.model.optimise.results.OptimisedResultSet;
import rhinova.metapopulation.model.simulate.results.SimulatedResult;
import rhinova.metapopulation.model.simulate.results.SimulatedResultSet;
import util.SerializeTools;

public class Simulator extends ModelBindingClass implements ApplicationListener<OptimisedAction> {

	OptimisedResultSet resultSet=null;
	SimulatedResultSet simulatedResultSet=null;
	PictureFactory pictureFactory;
	
	
	@Autowired
	ApplicationEventPublisher publisher;
	
	Simulatable simulatable;
	
	
	public void setSimulatable(Simulatable simulatable) {
		this.simulatable = simulatable;
	}

	/**
	 * Perform the simulation and saving.
	 * @param optimisedResultFilePath
	 * @param simulationFilePath
	 */
	public void simulate(String optimisedResultFilePath, String simulationFilePath) {
		OptimisedResultSet optimisedResultSet = SerializeTools.open(optimisedResultFilePath, OptimisedResultSet.class);
		this.simulate(optimisedResultSet);
		SerializeTools.save(simulationFilePath, simulatedResultSet);
	}
	
	/**
	 * Perform the simulation given the optimized results
	 * @param resultSet
	 * @return
	 */
	public void simulate(OptimisedResultSet resultSet)
	{	
		List<SimulatedResult> simultatedResults = null;

		try {
			this.simulatable.reset();
			simultatedResults = this.simulatable.getSimulateResultSet(resultSet);
		} catch (SimulationException e) {
			e.printStackTrace();
		}

		System.out.println("Printing the simulated results: \n\n");
		for (SimulatedResult result : simultatedResults) {
			System.out.println(result);
		}
		
		SimulatedResultSet simultedResultSet = new SimulatedResultSet(
				simultatedResults, "null");
		
		this.simulatedResultSet = simultedResultSet;
		publisher.publishEvent(new SimulationEvent(this, this.simulatedResultSet));
	}

	@Override
	public void onApplicationEvent(OptimisedAction arg0) {
		this.simulate(arg0.getResultSet());
	}
}
