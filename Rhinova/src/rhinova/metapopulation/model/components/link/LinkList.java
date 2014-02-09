package rhinova.metapopulation.model.components.link;




import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import rhinova.framework.drawable.Line;
import rhinova.framework.drawable.LineList;
import rhinova.framework.entity.RootModelEntityList;
import rhinova.framework.entity.exceptions.EntityExceptionDialogs;
import rhinova.framework.entity.tableable.ObjectGetter;
import rhinova.framework.entity.tableable.Tableable;
import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;
import rhinova.framework.entity.tableable.exceptions.NullInputException;
import rhinova.metapopulation.model.components.link.aspect.LinkUpdate;
import rhinova.metapopulation.model.components.link.exceptions.LinkCannotFindReserveException;
import rhinova.metapopulation.model.components.link.exceptions.LinkCapacityExceededException;
import rhinova.metapopulation.model.components.link.table.events.LinkAddEvent;
import rhinova.metapopulation.model.components.link.table.events.LinkDeleteEvent;
import rhinova.metapopulation.model.components.link.table.events.LinkEditEvent;
import rhinova.metapopulation.model.components.reserve.Reserve;
import rhinova.metapopulation.model.components.reserve.ReserveList;
import rhinova.metapopulation.model.components.reserve.exceptions.ReserveCapacityExceededException;
import rhinova.metapopulation.model.components.reserve.exceptions.ReserveInsufficientPopulationException;
import rhinova.metapopulation.model.optimise.results.OptimisedResultLink;
import rhinova.metapopulation.model.optimise.results.OptimisedResultSet;
import rhinova.metapopulation.model.simulate.Simulatable;
import rhinova.metapopulation.model.simulate.SimulationException;
import rhinova.metapopulation.model.simulate.results.SimulatedResult;


public class LinkList extends RootModelEntityList<Link> implements ObjectGetter, Simulatable, ApplicationListener<ApplicationEvent> {
	
	
	private static final long serialVersionUID = 1L;
	
	ReserveList reservesList;
	
	
	public void setReservesList(ReserveList reservesList) {
		this.reservesList = reservesList;
	}
	
	public ReserveList getReserveList() {
		return this.reservesList;
	}


	public LinkList(List<Link> lst) {
		super(lst);
	}


	/**
	 * Parameterless Constructor
	 */
	public LinkList() {
	}
	
	/**
	 * Method to Link all Reserve references to their Links
	 */
	public void linkReservesToAllLinks() {
		for(int i=0; i<this.size(); i++) {
			this.linkReserveAtLink(i);
		}
	}
	
	
	
	/**
	 * Link Reserve at Link i
	 * @param i
	 */
	@LinkUpdate
	public void linkReserveAtLink(int i) {
		Link link = this.get(i);
		int resNo1 = link.getReserve1No();
		int resNo2 = link.getReserve2No();
		link.setReserve1(this.reservesList.getById(resNo1));
		link.setReserve2(this.reservesList.getById(resNo2));
	}


	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void createAndAddNewLink(String stringName,
			String stringCapacity,
			String stringSurvivalRate,
			String stringReserveNo1,
			String stringReserveNo2
			) throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		this.add(new Link(
				stringName,
				stringCapacity,
				stringSurvivalRate,
				stringReserveNo1,
				stringReserveNo2,
				(List)reservesList));
	}


//	@Override
//	public Tableable[] getAllObjects() {
//		return (Tableable[]) this.toArray();
//	}


	@Override
	public void save(Tableable obj) {
		System.out.println("not yet implemented");
	}


	@Override
	@LinkUpdate
	public void createAndAddNewInstance(String[] values) throws NullInputException, IncorrectDataType, ConstraintViolatedException {
		@SuppressWarnings("unused")
		String stringId = values[0]; // not updating the id
		String stringName = values[1];
		String stringCapacity = values[2];
		String stringSurvivalRate = values[3];
		String stringReserveNo1 = values[4];
		String stringReserveNo2 = values[5];
		
		this.createAndAddNewLink(stringName, stringCapacity, stringSurvivalRate, stringReserveNo1, stringReserveNo2);
	}

	
	@Override
	@LinkUpdate
	public void update(String[] values) throws NullInputException, IncorrectDataType, ConstraintViolatedException, NumberFormatException {
		
		int id = Integer.parseInt(values[0]);
		
		String stringName = values[1];
		String stringCapacity = values[2];
		String stringSurvivalRate = values[3];
		String stringReserveNo1 = values[4];
		String stringReserveNo2 = values[5];
		

			
			// check to see if the values are valid by creating a link with the same values
			@SuppressWarnings("unused")
			Link link = new Link(stringName, stringCapacity, stringSurvivalRate, stringReserveNo1, stringReserveNo2, reservesList.getList());
			// perform update
			this.getById(id).editUpdat(values);
			// link the reserve
			this.linkReserveAtLink(id);
	}

	@Override
	@LinkUpdate
	public void delete(String[] values) {
		this.removeById(Integer.parseInt(values[0]));
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void createTableable(String[] values) throws IncorrectDataType,
			ConstraintViolatedException, NullInputException {
		String stringName = values[1];
		String stringCapacity = values[2];
		String stringSurvivalRate = values[3];
		String stringReserveNo1 = values[4];
		String stringReserveNo2 = values[5];
		
		this.add(new Link(
				stringName,
				stringCapacity,
				stringSurvivalRate,
				stringReserveNo1,
				stringReserveNo2,
				(List)reservesList));
	}
	
	public void removeLinksWhichHaveReserveNo(int id) {
		for (int i=0; i<this.size(); i++) {
			Link link = this.get(i);
			if (link.getReserve1No() == id || link.getReserve2No() == id) {
				this.remove(link);
			}
		}
	}


	@Override
	public String[] getHeading() {
		return Link.getHeadingStatic();
	}


	
	
	
	
	/**
	 * Find all the links on a given reserve
	 * @param res
	 * @return all links which link the given reserve
	 */
	public List<Link> getLinksOnReserve(Reserve res) {
		
		List<Link> links = new ArrayList<Link>();
		for (int i=0; i<this.size(); i++) {
			Link link = this.get(i);
			if (link.getReserve1()==res || link.getReserve2()==res) {
				links.add(link);
			}
		}
		return links;
	}
	
	
	/** Array functions to be used when constructing the objective functions */
	
	/**
	 * @return array of capacities.
	 */
	public double[][] getLinkCapacityArray(){
		double[][] cap = new double[this.reservesList.size()][this.reservesList.size()];
		for (int i=0; i<this.size(); i++) {
			Link link = this.get(i);
			int pos1 = reservesList.findPlace(link.getReserve1());
			int pos2 = reservesList.findPlace(link.getReserve2());
			cap[pos1][pos2]=link.getCapacity();
			cap[pos2][pos1]=link.getCapacity();
		}
		return cap;
	}
	
	
	/**
	 * @return array of capacities.
	 */
	public double[][] getLinkSurvivalArray(){
		double[][] sur = new double[this.reservesList.size()][this.reservesList.size()];
		for (int i=0; i<this.size(); i++) {
			Link link = this.get(i);
			int pos1 = reservesList.findPlace(link.getReserve1());
			int pos2 = reservesList.findPlace(link.getReserve2());
			sur[pos1][pos2]=link.getSurvivalRate();
			sur[pos2][pos1]=link.getSurvivalRate();
		}
		return sur;
	}
	
	/**
	 * @return the variable array
	 */
	public double[][] getVariableArray(){
		double[][] var = new double[this.reservesList.size()][this.reservesList.size()];
		for (int i=0; i<this.size(); i++) {
			Link link = this.get(i);
			int pos1 = reservesList.findPlace(link.getReserve1());
			int pos2 = reservesList.findPlace(link.getReserve2());
			var[pos1][pos2]=1.0;
			var[pos2][pos1]=1.0;
		}
		return var;
	}

	
	/**
	 * Find the link with these Reserves Exception
	 * @param res1Id
	 * @param res2Id
	 * @return
	 * @throws LinkCannotFindReserveException
	 */
	Link findLinkWithReserves(int res1Id, int res2Id) throws LinkCannotFindReserveException {
		Link linkFound = null;
		int count = 0;
		for (int i=0; i<this.size(); i++) {
			Link link = this.get(i);
			if ((link.getReserve1No() == res1Id && link.getReserve2No() == res2Id)||
			    (link.getReserve2No() == res1Id && link.getReserve1No() == res2Id)) {
				linkFound = link;
				count ++;
			}
		}
		
		if (linkFound == null ||
			count != 1)
		{
			throw new LinkCannotFindReserveException();
		}
		return linkFound;
	}

	public void transferPopulationFromReserve1ToReserve2(int res1Id, int res2Id, double no_population)
			throws 
			LinkCannotFindReserveException,
			ReserveCapacityExceededException,
			ReserveInsufficientPopulationException,
			LinkCapacityExceededException
			{
		Link link = this.findLinkWithReserves(res1Id, res2Id);
		link.transferPopulationFromReserveToReserve(res1Id, res2Id, no_population);
	}
	
	
	@Override
	public List<SimulatedResult> getSimulateResultSet(OptimisedResultSet resultSet) throws SimulationException {
		
		List<SimulatedResult> simulatedResults = new ArrayList<>();
		List<List<OptimisedResultLink>> results = resultSet.getResults();
		
		for (int y=0; y<results.size(); y++) {
			List<OptimisedResultLink> r = results.get(y);
			try {
				simulatedResults.add(this.simulate1Cycle(r,y));
			} catch (LinkCannotFindReserveException
					| ReserveInsufficientPopulationException
					| ReserveCapacityExceededException e) {
				e.printStackTrace();
				throw new SimulationException();
			}
		}
		return simulatedResults;
	}
	
	public SimulatedResult simulate1Cycle(List<OptimisedResultLink> oneYearHarvest, int year) throws LinkCannotFindReserveException, ReserveInsufficientPopulationException, ReserveCapacityExceededException {
		
		SimulatedResult simulatedResult = new SimulatedResult("aaa", year);
		
		// start population
		simulatedResult.newStart(reservesList);														// record start
		
		// leaving population
		// TODO use link constraints
		for (int i=0; i<oneYearHarvest.size(); i++) {
			OptimisedResultLink result = oneYearHarvest.get(i);
			Reserve reserve = result.getResFrom();
			reserve.givePopulation(result.getValue());
		}
		simulatedResult.newLeaving(reservesList, oneYearHarvest);									// record leaving
		
		// arriving population
		// TODO use link constraints
		for (int i=0; i<oneYearHarvest.size(); i++) {
			OptimisedResultLink result = oneYearHarvest.get(i);
			Reserve reserve = result.getResTo();
			reserve.acceptPopulation(result.getValue()*result.getLinkData().getSurvivalRate());
		}
		simulatedResult.newArriving(reservesList, oneYearHarvest);									// record arriving
		
		// regeneration population
		this.reservesList.regenerateAll();
		simulatedResult.newRegeneration(reservesList);												// record regeneration
		
		
		return simulatedResult;
	}


	public LineList getLines() {
		LineList lines = new LineList();
		for (int i=0; i<this.size(); i++) {
			lines.add(new Line(this.get(i)));
		}
		return lines;
	}


	@Override
	public void reset() {
		for (int i=0; i<this.reservesList.size(); i++) {
			this.reservesList.get(i).reset();
		}
	}

	@Override
	public Object[][] getAllObjects() {
		final int noRows = this.size();
		final int noColumns = this.get(0).getRow().length;
		Object[][] allObjects = new Object[noRows][noColumns];
		for (int r=0; r<noRows; r++) {
			Tableable tableable = this.get(r);
			Object[] row = tableable.getRow();
			for (int c=0; c<noColumns; c++) {
				allObjects[r][c] = row[c];
			}
		}
		return allObjects;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent ev) {

		if (ev instanceof LinkAddEvent) {
			
			LinkAddEvent event = (LinkAddEvent) ev;
			try {
				this.createAndAddNewInstance(event.getData());
			} catch (IncorrectDataType e) {
				EntityExceptionDialogs.onIncorrectDataType(e.getMessage());
			} catch (ConstraintViolatedException e) {
				EntityExceptionDialogs.onConstraintViolateException(e.getMessage());
			} catch (NullInputException e) {
				EntityExceptionDialogs.onNullInputException(e.getMessage());
			}
			
		} else if (ev instanceof LinkDeleteEvent) {
		
			LinkDeleteEvent event = (LinkDeleteEvent) ev;
			this.delete(event.getData());
			
		} else if (ev instanceof LinkEditEvent) {
			
			LinkEditEvent event = (LinkEditEvent) ev;
			try {
				this.update(event.getData());
			} catch (NumberFormatException e) {
				System.out.println("unsure why this appears");
			} catch (IncorrectDataType e) {
				EntityExceptionDialogs.onIncorrectDataType(e.getMessage());
			} catch (ConstraintViolatedException e) {
				EntityExceptionDialogs.onConstraintViolateException(e.getMessage());
			} catch (NullInputException e) {
				EntityExceptionDialogs.onNullInputException(e.getMessage());
			}
			
		}
	}
	
//	public void take(List<OptimisedResultLink> moves) throws
//	LinkCannotFindReserveException,
//	ReserveInsufficientPopulationException {
//		for (OptimisedResultLink move : moves) {
//			Link link = this.getById(move.getLinkId());
//			link.takeTravelers(move.getValue(), move.getReserveFrom(), move.getReserveTo());
//		}
//	}

	
}
