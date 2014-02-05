package rhinova.framework.drawable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Circle Class to be drawn easy
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Circle extends Shape {

	private double x;
	private double y;


	private double growth;

	private double curR; 
	private final double initCur;

	private double maxR;
	private final double initMax;

	private double minR;
	private final double initMin;

	private String name;



	public Circle(Circleable circleable) {

		x 		= circleable.getX();
		y 		= circleable.getY();
		growth 	= circleable.getG();
		name 	= circleable.getCircleName();

		curR 	= circleable.getCurR();
		initCur = circleable.getCurR();

		maxR 		= circleable.getMaxR();
		initMax 	= circleable.getMaxR();

		minR 		= circleable.getMinR();
		initMin		= circleable.getMinR();
	}



	/**
	 * Method to scale the radius of the line
	 * @param maxRadius
	 * @param maxInitial
	 */
	public void scale(double maxRadius, double maxInitial) {
		this.maxR = Math.sqrt(this.initMax/maxInitial)*maxRadius;
		this.minR = Math.sqrt(this.initMin/maxInitial)*maxRadius;
		this.curR = Math.sqrt(this.initCur/maxInitial)*maxRadius;
	}



}
