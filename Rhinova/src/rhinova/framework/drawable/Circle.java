package rhinova.framework.drawable;

/**
 * Circle Class to be drawn easy
 *
 */
public class Circle extends Shape {

	public double getX() {
		return x;
	}



	public void setX(double x) {
		this.x = x;
	}



	public double getY() {
		return y;
	}



	public void setY(double y) {
		this.y = y;
	}



	public double getGrowth() {
		return growth;
	}



	public void setGrowth(double growth) {
		this.growth = growth;
	}



	public double getCurR() {
		return curR;
	}



	public void setCurR(double curR) {
		this.curR = curR;
	}



	public double getMaxR() {
		return maxR;
	}



	public void setMaxR(double maxR) {
		this.maxR = maxR;
	}



	public double getMinR() {
		return minR;
	}



	public void setMinR(double minR) {
		this.minR = minR;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getInitCur() {
		return initCur;
	}



	public double getInitMax() {
		return initMax;
	}



	public double getInitMin() {
		return initMin;
	}



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
