package rhinova.framework.entity.tableable;

import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;
import rhinova.framework.entity.tableable.exceptions.NullInputException;




/**
 * @author Derrick
 *	Class which is responsible for getting an array of all th objects which will be represented in the table.
 */
public interface ObjectGetter {
	
	/** This method will be used to create all the rows in the table.
	 * @return all the rows which will be displayed in the table
	 */
	Object[][] getAllObjects();
	
	
	/**
	 * Saving the object to a database
	 * @param obj - object you wish to save
	 */
	void save(Tableable obj);
	
	
	/** This must define how to create a new class 
	 * @param values values to create new instance
	 */
	public void createAndAddNewInstance(String[] values) throws IncorrectDataType, ConstraintViolatedException, NullInputException;
	
	
	/*
	 * Creates a new Tableable Object
	 */
	/**
	 * @param values values to create new instance
	 * @return
	 * @throws IncorrectDataType
	 * @throws ConstraintViolatedException
	 * @throws NullInputException
	 */
	public void createTableable(String[] values)  throws IncorrectDataType, ConstraintViolatedException, NullInputException;
	
	/** Method to update the values of an instance
	 * @param values
	 * @throws NullInputException 
	 */
	public void update(String[] values) throws IncorrectDataType, ConstraintViolatedException, NullInputException;
	
	
	/** Method to delete a value.
	 * @param args
	 */
	public void delete(String[] values);
	
	/**
	 * Method to get the heading of the Tableable class.
	 **/
	public String[] getHeading();
}
