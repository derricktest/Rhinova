package rhinova.framework.entity.tableable;

import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;



/**
 * Objects must implement this interface to be able to return a row representing this object to be
 * used in the Table.
 */
public interface Tableable {
	
	/**
	 * Method to get a row of the object which will be displayed in the table.
	 * @return a single row which will be displayed in the table
	 */
	public Object[] getRow();
	
	/**
	 * Method to update an object given a row.
	 * @param object this should effectively be an update in SQL
	 */
	public void editUpdat(String[] object) throws IncorrectDataType, ConstraintViolatedException;
	
	/**
	 * Method to get the column heading of the object.
	 * @return An array containing the column heading in the same order as in getRow()
	 */
	public String[] getHeading();
	

}
