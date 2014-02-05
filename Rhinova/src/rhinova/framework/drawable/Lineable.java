package rhinova.framework.drawable;

/**
 * Interface to draw an object as a line
 *
 */
public interface Lineable {

	/** First x coordinate */
	double getX1();
	
	/** First y coordinate */
	double getY1();
	
	/** Second x coordinate */
	double getX2();
	
	/** Second x coordinate */
	double getY2();
	
	/** Number to represent color */
	double getColor();
	
	/** Number to represent thickness */
	double getThickness();
	
}
