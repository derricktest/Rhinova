package rhinova.framework.drawable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class to be drawn as a line, particularly onto the
 * GIS Panel.
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Line extends Shape {
	

	double 					x1;
	double 					y1;
	double 					x2;
	double 					y2;
	double 					color;
	double 					thickness;
	final double			initalThickness;
	
	
	/**
	 * Basic Constructor
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param color
	 * @param thickness
	 */
	public Line(double 		x1,
				double 		y1,
				double 		x2,
				double 		y2,
				double 		color,
				double 		thickness) {
		super();
		this.x1 = 			x1;
		this.y1 = 			y1;
		this.x2 = 			x2;
		this.y2 = 			y2;
		this.color = 		color;
		this.thickness = 	thickness;
		this.initalThickness = thickness;
	}
	
	
	/**
	 * Constructor which takes an object implementing the
	 * lineable interface.
	 * @param lineable
	 */
	public Line(Lineable lineable) {
		super();
		this.x1 = 			lineable.getX1();
		this.y1 = 			lineable.getY1();
		this.x2 = 			lineable.getX2();
		this.y2 = 			lineable.getY2();
		this.color = 		lineable.getColor();
		this.thickness = 	lineable.getThickness();
		this.initalThickness = thickness;
	}
	
	/**
	 * Method to scale the thickness of lines
	 * @param maxThickness
	 * @param maxInitial
	 */
	public void scale(double maxThickness, double maxInitial) {
		double scale = (double )this.initalThickness/maxInitial;
		this.thickness = maxThickness * (this.initalThickness*scale);
	}
	
}
