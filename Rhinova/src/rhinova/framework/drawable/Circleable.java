package rhinova.framework.drawable;

/**
 * @author Derrick
 * Interface to draw an object as a circle
 */
public interface Circleable {
	
	/** get x position */
	public double getX();
	
	/** get x position*/
	public double getY();
	
	/** get minimum radius*/
	public double getMinR();
	
	/** get current radius*/
	public double getCurR();
	
	/** get maximum radius*/
	public double getMaxR();
	
	/** get growth*/
	public double getG();
	
	/** get name */
	public String getCircleName();
	
}
