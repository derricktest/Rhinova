package rhinova.metapopulation.model.components.reserve;

import java.util.ArrayList;

import rhinova.framework.drawable.Circleable;
import rhinova.framework.entity.RootModelEntity;
import rhinova.framework.entity.tableable.Tableable;
import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;
import rhinova.framework.entity.tableable.exceptions.NullInputException;
import rhinova.metapopulation.model.components.reserve.exceptions.FatalPopulationConstraintExceededException;
import rhinova.metapopulation.model.components.reserve.exceptions.ReserveCapacityExceededException;
import rhinova.metapopulation.model.components.reserve.exceptions.ReserveInsufficientPopulationException;



/**
 * The Class Reserve. Represents a single colony of a group of Reserves joined by Links which make up the Meta-population class. The Reserve
 * class has many functions and I rekon it's really kool. It's also indestructable and very realistic, as well as tough to make any bugs for.
 */
public class Reserve extends RootModelEntity implements Tableable, Circleable
{
	
	Reserve(){} // default constructor for serialization purposes // REVIST not needed anymore

	/** List of all the reserve id's that have been initiated **/


	/** The name of the Reserve. */
	private String name;

	/** The x location of the Reserve. */
	private double xPos;

	/**	The y location of the Reserve. **/
	private double yPos;

	/** The maximum population which the Reserve can support. */
	private double maxPopulation;

	/** The current population of the Reserve at this point in time **/
	private double currentPopulation;

	/** The percentage the population grows by each year **/
	private double regenerationRate;

	/** The minimum population which the Reserve always needs to have or exceed **/
	private double minPopulation;
	
	/** The initial population of the Reserve	**/
	// TODO use later
	private double initialPopulation;
	
	public double getInitialPopulation() {
		return initialPopulation;
	}
	
	public void setCurrentPopulation(double population) {
		this.currentPopulation = population;
	}


	public void setInitialPopulation(double initialPopulation) {
		this.initialPopulation = initialPopulation;
	}

	/**	A record of the population of the Reserve, note that I do not wish to save this,
	 * I will however create the ability to save a scenario file which will contain the 
	 * setting for running the application **/
	private ArrayList<Double> populationHistory = new ArrayList<Double>();



	/**
	 * Instantiates a new reserve. This creates a new Reserve. This constructor is designed to be bullet proof so that it
	 * checks that the user has inputed correct values. In addition it is designed for the purpose of taking string data and
	 * converting it into the correct type
	 *
	 * @param name the name of the new Reserve
	 * @param yPos the y location of the new Reserve
	 * @param xPos the x location of the new Reserve
	 * @param currentPopulation the current population of the new Reserve (or starting population)
	 * @param minPopulation the minimum population the Reserve is allowed to have.
	 * @param maxPopulation the maximum population the Reserve can sustain.
	 * @param regenerationRate the percentage the Reserve's population grows each year.
	 * @throws ConstraintViolatedException 
	 * @throws ReservePopulationInputError the reserve population input error
	 */
	private void init(
			String name,
			double xPos,
			double yPos,
			double currentPopulation,
			double minPopulation,
			double maxPopulation,
			double regenerationRate
			) throws ConstraintViolatedException
					 {
		// Check that the populations set are correct
		if (currentPopulation > maxPopulation)
		{
			throw new ConstraintViolatedException("The current population cannot be greater than the max population");
		}
		if (currentPopulation < minPopulation)
		{
			throw new ConstraintViolatedException("The current population cannot be less than the minimum population");
		}
		if (maxPopulation < minPopulation)
		{
			throw new ConstraintViolatedException("The maxiumum population cannot be less that the minimum population");
		}
		if (maxPopulation < 0 || minPopulation < 0 || currentPopulation < 0 )
		{
			throw new ConstraintViolatedException(
					"Current populations cannot be negative");
		}
		if (maxPopulation == minPopulation)
		{
			throw new ConstraintViolatedException(
					"The maxiumum population cannot equal the minimum population");
		}
		if (maxPopulation == 0)
		{
			throw new ConstraintViolatedException("The maxiumum population cannot be 0");
		}
		
		// check the positions are ok
		
		if (!(0<=xPos)&&(xPos<=1))
		{
			throw new ConstraintViolatedException("The x position must be between 0 and 1");
		}
		if (!(0<=yPos)&&(yPos<=1))
		{
			throw new ConstraintViolatedException("The y position must be between 0 and 1");
		}

		this.name = name;
		this.yPos = yPos;
		this.xPos = xPos;
		this.currentPopulation = currentPopulation;
		this.initialPopulation = currentPopulation;
		this.minPopulation = minPopulation;
		this.maxPopulation = maxPopulation;
		this.regenerationRate = regenerationRate;
		this.populationHistory.add(currentPopulation);

					}


	/**
	 * Instantiates a new reserve.
	 *
	 * @param stringName the name of the Reserve.
	 * @param stringXPos the x location of the Reserve.
	 * @param stringYPos the y location of the Reserve.
	 * @param stringPopulation the current population of the Reserve.
	 * @param stringMinPopulation the minimum population the Reserve is allowed to have.
	 * @param stringMaxpopulation the maximum population the Reserve is allowed to have.
	 * @param stringRegeneration the percentage of the population increases each year.
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataType 
	 * @throws NullInputException the null input exception which is thrown when values are missing in the constructor
	 */
	public Reserve (
			String stringName,
			String stringXPos,
			String stringYPos,
			String stringPopulation,
			String stringMinPopulation,
			String stringMaxpopulation,
			String stringRegeneration
			) throws IncorrectDataType, NullInputException, ConstraintViolatedException
					{
		super();
		init_strings(stringName, stringXPos, stringYPos, stringPopulation, stringMinPopulation, stringMaxpopulation, stringRegeneration);
		this.setId();
					}


	/**
	 * Init_strings.
	 *
	 * @param stringName the s_name
	 * @param stringXPos the s_x
	 * @param stringYPos the s_y
	 * @param stringCurrentPopulation the s_population
	 * @param stringMinPopulation the s_min_population
	 * @param stringMaxPopulation the s_max_population
	 * @param stringRegenerationRate the s_regeneration
	 * @throws NullInputException 
	 * @throws ConstraintViolatedException 
	 */
	private void init_strings (
			String stringName,
			String stringXPos,
			String stringYPos,
			String stringCurrentPopulation,
			String stringMinPopulation,
			String stringMaxPopulation,
			String stringRegenerationRate) throws IncorrectDataType, NullInputException, ConstraintViolatedException
					{

		// Check that none of the inputs are null
		if (stringName.length() == 0 ||
				stringName.length() == 0 ||
				stringXPos.length() == 0 ||
				stringYPos.length() == 0 ||
				stringCurrentPopulation.length() == 0 ||
				stringMinPopulation.length() == 0 ||
				stringMinPopulation.length() == 0 ||
				stringMaxPopulation.length() == 0 ||
				stringRegenerationRate.length() == 0)
		{
			throw new NullInputException("A field is null");
		}

		String name = null;
		double x = 0;
		double y = 0;
		double currentPopulation = 0;
		double minPopulation = 0;
		double maxPopulation = 0;
		double regenerationRate = 0;
		// Check to see if the user has entered the correct data types
		try
		{
			name = stringName;
			x = Double.parseDouble(stringXPos);
			y = Double.parseDouble(stringYPos);
			currentPopulation = Double.parseDouble(stringCurrentPopulation);
			minPopulation = Double.parseDouble(stringMinPopulation);
			maxPopulation = Double.parseDouble(stringMaxPopulation);
			regenerationRate = Double.parseDouble(stringRegenerationRate);
		}
		catch(Exception e)
		{
			throw new IncorrectDataType("Please check your data types are of the correct type");
		}

		init(name, x, y, currentPopulation, minPopulation, maxPopulation, regenerationRate);

					}


	/**
	 * Instantiates a new reserve. This constructor also allows for the id of the Reserve to be set which typically happens
	 * when a file is being read back into the application.
	 *
	 * @param stringId the id of the Reserve
	 * @param stringName the name of the Reserve.
	 * @param stringXPos the x location of the Reserve.
	 * @param stringYPos the y location of the Reserve.
	 * @param stringCurrentPopulation the current population of the Reserve.
	 * @param stringMinPopulation the minimum population the Reserve is allowed to have.
	 * @param stringMaxPopulation the maximum population the Reserve is allowed to have.
	 * @param stringRegenerationRate the percentage of the population increases each year.
	 * @throws NullInputException the null input exception which is thrown when values are missing in the constructor
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataType 
	 * @throws IncorrectDataTypesInputException the incorrect data types input exception when date i.e. the x has letters in it
	 * @throws ReservePopulationInputError the exception thrown whenever incorrect population data is entered.
	 */
	public Reserve (
			String stringId,
			String stringName,
			String stringXPos,
			String stringYPos,
			String stringCurrentPopulation,
			String stringMinPopulation,
			String stringMaxPopulation,
			String stringRegenerationRate
			)
					throws NullInputException, IncorrectDataType, ConstraintViolatedException
					{
		super();

		// if there is no input for the id throw a NullInputException
		if (stringId == null || stringId.length() == 0)
		{
			throw new NullInputException("The id was null");
		}

		int id;

		// check to see if the id is of the right type
		try
		{
			id = Integer.parseInt(stringId);
		}
		catch (Exception e)
		{
			throw new IncorrectDataType("Id must be of data type int");
		}
		// call the initializer which takes strings as values
		init_strings(stringName, stringXPos, stringYPos, stringCurrentPopulation, stringMinPopulation, stringMaxPopulation, stringRegenerationRate);

		// set the id of the reserve
		this.setId(id);
					}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		String details =  "Id: "+ this.id +" Name: "+ this.name + "\n" +
				"Initial Population: " + this.initialPopulation + "\n" +
				"Current Population: " + this.currentPopulation + "\n" +
				"Regeneration Rate: " + this.regenerationRate + "\n" +
				"Max Population: "+ this.maxPopulation + "\n" +
				"Min Population: "+ this.minPopulation + "\n" +
				"X Position: "+ this.xPos + "\n" +
				"Y Position: "+ this.yPos + "\n";
				
		return details;
	}


	//------------------------ Giving and taking functions to allow the travel from one Reserve to another -------------------// 

	/**
	 * Take population.
	 *
	 * @param no_population_to_take the desired amount of population to be taken
	 * @return the no_population_to_take
	 * @throws ReserveInsufficientPopulationException thrown if too much population is taken
	 */
	public double givePopulation(double no_population_to_take) throws ReserveInsufficientPopulationException 
	{
		// check if the population to be taken from the Reserve is more than what the reserve can give.
		if (no_population_to_take > this.availablePopulation())
		{
			// if this is the case then thrown and exception
			throw new ReserveInsufficientPopulationException(this.availablePopulation(), no_population_to_take);
		}
		// take the population away from the reserve
		this.currentPopulation -= no_population_to_take;
		// return the population taken from the reserve
		return no_population_to_take;
	}

	/**
	 * Accept population. Accepts an amount of population and adds it to the reserve if possible
	 *
	 * @param no_population_to_accept the no_population_to_take
	 * @throws ReserveCapacityExceededException thrown if too many population is taken
	 */
	public void acceptPopulation(double no_population_to_accept) throws ReserveCapacityExceededException
	{
		if (no_population_to_accept > this.availableCapacity())
		{
			// if the population exceeds the available capacity then raise an exception 
			throw new ReserveCapacityExceededException();
		}
		// adding the received to the Reserve
		this.currentPopulation += no_population_to_accept;
	}

	// some more advanced getter methods

	/**
	 * Takes as much population from the reserve as possible.
	 *
	 * @return availablePopulation();
	 */
	double takeMaxPopulation()
	{
		// set the Reserve's population to the minimum population
		this.currentPopulation = this.minPopulation;
		// return the population which can be taken from the Reserve
		return this.availablePopulation();
	}

	/**
	 * Available population. Returns the amount of population which can be taken from this reserve.
	 *
	 * @return (current population) - (minimum population)
	 */
	public double availablePopulation()	{		return this.currentPopulation - this.minPopulation;	}

	/**
	 * Available capacity. Returns the available space at the Reserve (which also accounts for regeneration)
	 *
	 * @return  The maximum population this reserve can accept 
	 */
	double availableCapacity()
	{		
		return this.maxPopulation/(1+this.regenerationRate) - this.currentPopulation;
	}

	/**
	 * Regenerate. The Reserve grows its population by its regeneration rate. 
	 * @throws ReserveCapacityExceededException 
	 */
	public void regenerate() throws FatalPopulationConstraintExceededException
	{			
		double new_population = this.currentPopulation*(1+this.regenerationRate);
		if (new_population > this.maxPopulation)
		{
			throw new FatalPopulationConstraintExceededException();
		}
		else 
		{
			this.currentPopulation = new_population;
			this.populationHistory.add(new_population);
		}
	}	





	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() 				{	return name;	}

	/**
	 * Gets the y coordinate
	 *
	 * @return the y coordinate
	 */
	public double getXPos() 				{	return yPos;	}

	/**
	 * Gets the y coordinate.
	 *
	 * @return the y coordinate.
	 */
	public double getYPos() 				{	return xPos;	}

	/**
	 * Gets the regeneration_rate.
	 *
	 * @return the regeneration_rate
	 */
	public double getRegenerationRate() 	{	return regenerationRate;	}

	/**
	 * Gets the current population.
	 *
	 * @return the current_population
	 */
	public double getCurrentPopulation() 	{	return currentPopulation;	}

	/**
	 * Gets the minimum population.
	 *
	 * @return the min_population
	 */
	public double getMinPopulation() 		{	return minPopulation;	}

	/**
	 * Gets the maximum population.
	 *
	 * @return the max_population
	 */
	public double getMaxPopulation() 		{	return maxPopulation;	}
	
	/**
	 * Find the population at time interval i
	 * @param i
	 * @return the population at that position
	 */
	public double getPopulation(int i)
	{
		return this.populationHistory.get(i);
	}
	

	/*
	 * This checks that a <code> Reserve <code/> is valid by attempting to instantiated a 
	 * <code> Reserve <code/> with the same members. If this is not possible then the
	 * <code> Reserve <code/>is not valid
	 * @return
	 */
	public boolean checkValid()
	{
		try
		{
			
			@SuppressWarnings("unused")
			Reserve res = new Reserve(
					this.name,
					this.xPos+"",
					this.yPos+"",
					this.currentPopulation+"",
					this.minPopulation+"",
					this.maxPopulation+"",
					this.regenerationRate+"");
			
			return true;	// the reserve could be created without any exception being thrown
		}
		catch(Exception e)
		{
			return false;  // an exception was thrown during the attempted creation of the Reserve,
						   // therefore it is not valid
		}
	}


	// testing the creation of reserves

	public static void main(String args[])
	{
		try
		{
			Reserve reserve;
			reserve = new Reserve("hello", "2", "3", "100", "90", "1000", "0.3");

			try
			{
				System.out.println(reserve.givePopulation(10000));
			}
			catch (ReserveInsufficientPopulationException e)
			{
				reserve.takeMaxPopulation();
			}
			System.out.println(reserve);
			Reserve reserve2 = new Reserve("hello", "2","3", "100", "90", "1000", "0.3");
			System.out.println(reserve2);
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}


	@Override
	public Object[] getRow() {
		return new Object[]{this.id, this.name, this.xPos, this.yPos, this.minPopulation, this.maxPopulation, this.currentPopulation, this.regenerationRate};
	}


	@Override
	public void editUpdat(String[] object) {
		// this.id = Integer.parseInt(object[0]); // don't wish to update the id
		this.name = object[1];
		this.xPos = Integer.parseInt(object[2]);
		this.yPos = Integer.parseInt(object[3]);
		this.minPopulation = Double.parseDouble(object[4]);
		this.maxPopulation = Double.parseDouble(object[5]);
		this.currentPopulation = Double.parseDouble(object[6]);
		this.regenerationRate = Double.parseDouble(object[7]);
		
	}

	private static String[] heading = {"id","name", "x position", "y position", "min population", "max population", "current population", "regeneration rate"};
	
	@SuppressWarnings("static-access") // static methods not allowed in interfaces
	@Override
	public String[] getHeading() {
		return this.heading;
	}
	
	public static int findHeadingPosition(String headingToFind) {
		for (int i=0; i<heading.length; i++) {
			String h = heading[i];
			if (h==headingToFind) {
				return i;
			}
		}
		throw new RuntimeException();
	}
	
	public static String getXHeading() {
		return heading[2];
	}
	
	public static String getYHeading() {
		return heading[3];
	}
	
	public static int getXHeadingPosition() {
		return findHeadingPosition(getXHeading());
	}
	
	public static int getYHeadingPosition() {
		return findHeadingPosition(getYHeading());
	}
	
	public static String[] getHeadingStatic() {
		return heading;
	}

	/** Methods for drawing object as a circle */

	@Override
	public double getX()    {		return this.getXPos();	}
	@Override
	public double getY()    {		return this.getYPos();	}
	@Override
	public double getMinR() {		return Math.sqrt(this.getMinPopulation() /Math.PI);	}
	@Override
	public double getCurR() {		return Math.sqrt(this.getCurrentPopulation()/Math.PI);	}
	@Override
	public double getMaxR() {		return Math.sqrt(this.getMaxPopulation()/Math.PI);	}
	@Override
	public double getG()    {		return Math.sqrt(this.getRegenerationRate());	}
	@Override
	public String getCircleName() {		return this.getId()+" - "+this.name;}

	public void reset() {
		this.currentPopulation = this.initialPopulation;
	}



}
