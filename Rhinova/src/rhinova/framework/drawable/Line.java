package rhinova.framework.drawable;


/**
 * Class to be drawn as a line, particularly onto the
 * GIS Panel.
 *
 */
public class Line extends Shape {
	

	public double getX1() {
		return x1;
	}


	public void setX1(double x1) {
		this.x1 = x1;
	}


	public double getY1() {
		return y1;
	}


	public void setY1(double y1) {
		this.y1 = y1;
	}


	public double getX2() {
		return x2;
	}


	public void setX2(double x2) {
		this.x2 = x2;
	}


	public double getY2() {
		return y2;
	}


	public void setY2(double y2) {
		this.y2 = y2;
	}


	public double getColor() {
		return color;
	}


	public void setColor(double color) {
		this.color = color;
	}


	public double getThickness() {
		return thickness;
	}


	public void setThickness(double thickness) {
		this.thickness = thickness;
	}


	public double getInitalThickness() {
		return initalThickness;
	}

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
