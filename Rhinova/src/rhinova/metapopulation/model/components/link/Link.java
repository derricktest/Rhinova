package rhinova.metapopulation.model.components.link;


import java.util.List;

import rhinova.framework.drawable.Lineable;
import rhinova.framework.entity.RootModelEntity;
import rhinova.framework.entity.tableable.Tableable;
import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;
import rhinova.framework.entity.tableable.exceptions.NullInputException;
import rhinova.metapopulation.model.components.link.exceptions.LinkCannotFindReserveException;
import rhinova.metapopulation.model.components.link.exceptions.LinkCapacityExceededException;
import rhinova.metapopulation.model.components.reserve.Reserve;
import rhinova.metapopulation.model.components.reserve.exceptions.*;



/**
 * The Class Link is responsible for linking reserves to one another.
 */
public class Link extends RootModelEntity implements Tableable, Lineable {

	public enum Place{FIRST, SECOND}
	
	public enum Direction{FORWARD, BACKWARD}

	/** The name of the Link. */
	private String name;

	/** The maximum amount of population which can cross this Link. */
	private double capacity;

	/** The percentage of the population which survives the journey. */
	private double survivalRate;

	/** The first reserve the Link connects to. */
	private Reserve reserve1 = null;

	/** The second reserve the Link connects to. */
	private Reserve reserve2 = null;

	/** The id of this.reserve_1. */
	private int reserve1No;

	/** The id of this.reserve_2 */
	private int reserve2No;

	/** The amount of population traveling along the link **/
	@SuppressWarnings("unused") // TODO
	private double travellers = 0.0;


	public Link(){}


	public void setReserve1(Reserve resserve) {		this.reserve1 = resserve;	}
	public void setReserve2(Reserve resserve) {		this.reserve2 = resserve;	}





	/** Same as setTravellers(0)*/
	public void resetTravellers()
	{
		this.travellers = 0;
	}

	/**
	 * Transfer population from reserve2 to reserve1
	 * @param no_population
	 * @throws ReserveCapacityExceededException
	 * @throws ReserveInsufficientPopulationException
	 * @throws LinkCapacityExceededException 
	 */
	public void transferPopulationFromReserve1ToReserve2(double no_population)
			throws ReserveCapacityExceededException,
			ReserveInsufficientPopulationException, LinkCapacityExceededException
			{
		if (this.getCapacity()<no_population) {
			throw new LinkCapacityExceededException();
		}

		// transfer the population
		this.getReserve2().acceptPopulation(this.getReserve1().givePopulation(no_population)*this.getSurvivalRate());
			}

	/**
	 * Transfer population from reserve1 to reserve2
	 * @param no_population
	 * @throws ReserveCapacityExceededException
	 * @throws ReserveInsufficientPopulationException
	 * @throws LinkCapacityExceededException 
	 */
	public void transferPopulationFromReserve2ToReserve1(double no_population) throws LinkCapacityExceededException,
	ReserveCapacityExceededException, ReserveInsufficientPopulationException {
		if (this.getCapacity()<no_population) {
			throw new LinkCapacityExceededException();
		}

		// transfer the population
		this.getReserve1().acceptPopulation(this.getReserve2().givePopulation(no_population)*this.getSurvivalRate());		
	}
	

	public boolean isRightOrder(int res1Id, int res2Id) throws LinkCannotFindReserveException {
		if (
				res1Id == this.getReserve1No() &&
				res2Id == this.getReserve2No()) {
			return true;
		}
		
		if (
				res2Id == this.getReserve1No() &&
				res1Id == this.getReserve2No()) {
			return false;
		}

		throw new LinkCannotFindReserveException();
	}
	
	
	public void takeTravelers(double no_population_to_take, int res1Id, int res2Id) throws LinkCannotFindReserveException, ReserveInsufficientPopulationException {
		if (this.isRightOrder(res1Id, res2Id))
		{
			this.getReserve1().givePopulation(no_population_to_take);
		} else {
			this.getReserve2().givePopulation(no_population_to_take);
		}
	}
	
	
	
	
	public void transferPopulationFromReserveToReserve(int resId1, int resId2, double no_population)
			throws 
			ReserveCapacityExceededException,
			ReserveInsufficientPopulationException,
			LinkCapacityExceededException,
			LinkCannotFindReserveException {
		
		if (isRightOrder(resId1, resId2)) {
			this.transferPopulationFromReserve1ToReserve2(no_population);
			return;
		} else {
			this.transferPopulationFromReserve2ToReserve1(no_population);
			return;
		}
	}



	/**
	 * Initiates the members from string input
	 *
	 * @param stringName the name of the Link
	 * @param stringCapacity the maximum population which can cross the Link
	 * @param stringSurvivalRate the survival rate
	 * @param stringReserveNo1 the first Reserve's number
	 * @param stringReserveNo2 the second Reserve's number
	 * @param reserveList the list of the Reserves which the links will link to
	 * @throws NullInputException thrown if there are empty inputs for values
	 * @throws IncorrectDataTypesInputException thrown if the function cannot convert from the inputs which are strings, to the other data types
	 * @throws LinkIncorrectValuesException thrown if a Link is created that invalidates its own constraints
	 * @throws EmptyReserveListException thrown if there is no Reserves passed to the constructor
	 * @throws LinkCannotFindReserveException if reserve_no_1 or reserve_no_2 cannot be found in the list parsed to the constructor
	 * @throws IncorrectDataType 
	 * @throws ConstraintViolatedException 
	 */
	private void initString(
			String stringName,
			String stringCapacity,
			String stringSurvivalRate,
			String stringReserveNo1,
			String stringReserveNo2,
			List<Reserve> reserveList
			)
					throws NullInputException, IncorrectDataType, ConstraintViolatedException
					{

		// check that the reserve list is not equal to null

		if (reserveList == null)
		{
			throw new NullInputException("There are no Reserves in your metapopulation. Create Reserves first"
					+ " before trying to create Links");
		}

		// check that the reserve list is not equal to 0 

		if (reserveList.size() == 0)
		{
			throw new NullInputException("There are no Reserves in your metapopulation. Create Reserves first"
					+ " before trying to create Links");
		}

		// check that there is a value for all the inputs 

		if (stringName.length() == 0 ||
				stringCapacity.length() == 0 ||
				stringSurvivalRate.length() == 0 ||
				stringReserveNo1.length() == 0 ||
				stringReserveNo2.length() == 0 )
		{
			throw new NullInputException("Something is null");
		}

		String name = null;
		double capacity = 0;
		double survivalRate = 0;
		int reserveNo1 = 0;
		int reserveNo2 = 0;

		// test that input is of the correct type

		try
		{
			name = stringName;
			capacity = Double.parseDouble(stringCapacity);
			survivalRate = Double.parseDouble(stringSurvivalRate);
			reserveNo1 = Integer.parseInt(stringReserveNo1);
			reserveNo2 = Integer.parseInt(stringReserveNo2);
		}
		catch (Exception e)
		{
			throw new IncorrectDataType("Please make sure you enter the correct data type in each field");
		}

		init(name, capacity, survivalRate, reserveNo1, reserveNo2, reserveList);

					}

	/*
	 * Initialize the members from variable inputs
	 */
	private void init(
			String name,
			double capacity,
			double survivalRate,
			int reserveNo1,
			int reserveNo2,
			List<Reserve> reserveList) throws ConstraintViolatedException
			{

		// check that all the link constraints are satisfied
		// check that reserve_no_1 does not equal reserve_no_2, i.e. Links cannot
		// link a Reserve to itself

		if (reserveNo1 == reserveNo2)
		{
			throw new ConstraintViolatedException("A Link must link together 2 different Reserves");
		}

		// a Link's capacity cannot be less than or equal to 0

		if (capacity <= 0)
		{
			throw new ConstraintViolatedException("Capacity cannot be less than or equal to 0");
		}

		// a Link's survival rate cannot be less than or equal to 0

		if (survivalRate <= 0)
		{
			throw new ConstraintViolatedException("Survival rate cannot be less than or equal to 0");
		}

		// a Link's survival rate cannot be greater than 1

		if (survivalRate > 1)
		{
			throw new ConstraintViolatedException("Survival rate cannot be greater than 1");
		}

		// find the reserve1

		for (Reserve reserve1 : reserveList)
		{
			if (reserve1.getId() == reserveNo1)
			{
				this.reserve1 = reserve1;
				break;
			}
		}

		// if reserve1 does not exist throw an exception!
		if (this.reserve1 == null)
		{
			throw new ConstraintViolatedException("Cannot find Reserve 1");
		}

		// find reserve 2

		for (Reserve reserve2 : reserveList)
		{
			if (reserve2.getId() == reserveNo2)
			{
				this.reserve2 = reserve2;
				break;
			}
		}

		// if reserve 2 does not exist throw an exception

		if (this.reserve2 == null)
		{
			throw new ConstraintViolatedException("Cannot find Reserve 2");
		}

		// assign the properties to the new reserve
		this.name = name;
		this.capacity = capacity;
		this.survivalRate = survivalRate;
		this.reserve1No = reserve1.getId();
		this.reserve2No = reserve2.getId();
			}




	/**
	 * Instantiates a new Link which is responsible for linking <code> Reserve </code>s together.
	 * 
	 * @param stringName the name of the Link
	 * @param stringCapacity the maximum number of population which can cross the link in 1 year
	 * @param stringSurvivalRate the percent of population which survives the journey
	 * @param stringReserveNo1 the number of the first reserve
	 * @param stringReserveNo2 the number of the second reserve
	 * @param reservesList the list of Reserves which the <code>Link</code> can link to 
	 * @throws NullInputException	thrown if an input is null
	 * @throws IncorrectDataTypesInputException thrown if the wrong data type is parsed
	 * @throws LinkIncorrectValuesException thrown if the members constraints are broken
	 * @throws EmptyReserveListException thrown if there are no reserves parsed
	 * @throws LinkCannotFindReserveException thrown if the desired reserve cannot be found
	 * @throws IncorrectDataType 
	 * @throws ConstraintViolatedException 
	 */
	public Link(String stringName,
			String stringCapacity,
			String stringSurvivalRate,
			String stringReserveNo1,
			String stringReserveNo2,
			List<Reserve> reservesList
			)
					throws
					NullInputException,
					IncorrectDataType, ConstraintViolatedException
					{
		initString(stringName, stringCapacity, stringSurvivalRate, stringReserveNo1, stringReserveNo2, reservesList);
		this.setId();
					}





	/**
	 * Instantiates a new link.
	 *
	 * @param stringId the unique id of the Link
	 * @param stringName the name of the Link
	 * @param stringCapacity the maximum population which can cross the Link
	 * @param stringSurvivalRate the survival rate
	 * @param stringReserveNo1 the first Reserve's number
	 * @param s_reserve_no_2 the second Reserve's number
	 * @param reserves_list the list of the Reserves which the links will link to
	 * @throws NullInputException thrown if there are empty inputs for values
	 * @throws IncorrectDataType 
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataTypesInputException thrown if the function cannot convert from the inputs which are strings, to the other data types
	 * @throws LinkIncorrectValuesException thrown if a Link is created that invalidates its own constraints
	 * @throws EmptyReserveListException thrown if there is no Reserves passed to the constructor
	 * @throws LinkCannotFindReserveException if reserve_no_1 or reserve_no_2 cannot be found in the list parsed to the constructor
	 */
	public Link( String stringId,
			String stringName,
			String stringCapacity,
			String stringSurvivalRate,
			String stringReserveNo1,
			String stringReserveNo2,
			List<Reserve> reserves_list) throws NullInputException, IncorrectDataType, ConstraintViolatedException

			{

		int id;

		// check that the id is not null or empty
		if (stringId.length() == 0 || stringId == null)
		{
			throw new NullInputException("The String id is null");
		}

		// check that the id is of the correct type
		try
		{
			id = Integer.parseInt(stringId);
		}
		catch(Exception e)
		{
			throw new IncorrectDataType("Id must be of type int");
		}

		// initialize the other members
		initString(stringName, stringCapacity, stringSurvivalRate, stringReserveNo1, stringReserveNo2, reserves_list);

		// set the id
		this.setId(id);
			}

	/**
	 * Checks that a <code>Link<code/> is valid by attempting to create the Link with the same members.
	 * If that <code>Link<code/> can be instantiated then the <code> Link <code/> is valid.
	 * 
	 * @param reserve_list List of <code> Reserve <code/>s the Link's connect to  
	 * @return
	 */
	public boolean checkValid(List<Reserve> reserve_list)
	{
		try
		{
			@SuppressWarnings("unused")
			Link link = new Link(
					this.name,
					this.capacity+"",
					this.survivalRate+"",
					this.reserve1No+"",
					this.reserve2No+"",
					reserve_list);

			return true; // the Link was created the
		}
		catch (Exception e)
		{
			return false;
		}
	}


	@Override
	public String toString()
	{
		String details =  "Id: "+ this.id +" Name: "+ this.name + "\n" +
				"Capacity: " + this.capacity + "\n" +
				"Survival Rate: " + this.survivalRate + "\n" +
				"Link 1: "+ this.reserve1.getName() + "\n" +
				"Link 2: "+ this.reserve2.getName() + "\n";
		return details;
	}


	/** get the name */
	public String getName()			{	return name;	}

	/** get the capacity */
	public double getCapacity() 	{	return capacity;	}

	/** get the survival rate */
	public double getSurvivalRate(){	return survivalRate;	}

	/** get Reserve1 */
	public Reserve getReserve1() 	{	return reserve1;	}

	/** get Reserve2 */
	public Reserve getReserve2() 	{	return reserve2;	}

	/** get Reserve1 no */
	public int getReserve1No()	{	return reserve1No;	}

	/** get Reserve2 no */
	public int getReserve2No() 	{	return reserve2No;	}



	/** heading as per what will show when this class is put into a table */
	private static String[] headingStatic = {"id","name", "capacity", "survival rate", "reserve no 1", "reserve no 2", "reserve 1 name", "reserve 2 name"};

	/**	Method to return the heading for when this class is put into a table */
	public static String[] getHeadingStatic() {
		return headingStatic;
	}

	@Override
	public Object[] getRow() {
		return new Object[]{this.id, this.name, this.capacity, this.survivalRate, this.reserve1No, this.reserve2No};
	}


	/* (non-Javadoc)
	 * @see dezza.components.table.interfaces.Tableable#editUpdat(java.lang.String[])
	 * Keep in mind that there is no checking in this method whether or not these values are allowed, as Reserves
	 * do not have a reference to Links, which I would like to keep that way.
	 */
	@Override
	public void editUpdat(String[] object) {
		this.name = object[1];
		this.capacity = Double.parseDouble(object[2]);
		this.survivalRate = Double.parseDouble(object[3]);
		this.reserve1No = Integer.parseInt(object[4]);
		this.reserve2No = Integer.parseInt(object[5]);
	}

	@SuppressWarnings("static-access") // static interfaces not allowed
	@Override
	public String[] getHeading() {
		return this.getHeadingStatic();
	}

	public void setReserveNo1(int i) {		this.reserve1No = i;	}

	public void setReserveNo2(int i) {		this.reserve2No = i;	}



	/** Methods to draw object as a line */

	@Override
	public double getX1() 			{		return this.getReserve1().getXPos();	}
	@Override
	public double getY1() 			{		return this.getReserve1().getYPos();	}
	@Override
	public double getX2() 			{		return this.getReserve2().getXPos();	}
	@Override
	public double getY2() 			{		return this.getReserve2().getYPos();	}
	@Override
	public double getColor() 		{		return this.getSurvivalRate();			}
	@Override
	public double getThickness() 	{		return this.getCapacity();				}


	public Place findReservePlace(Reserve reserve) throws LinkCannotFindReserveException {
		if (this.reserve1 == reserve) {
			return Place.FIRST;
		} else if (this.reserve2 == reserve) {
			return Place.SECOND;
		}
		throw new LinkCannotFindReserveException();
	}
	
	
	
}					// END of Link











