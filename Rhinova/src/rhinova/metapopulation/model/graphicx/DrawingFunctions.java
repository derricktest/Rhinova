package rhinova.metapopulation.model.graphicx;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import rhinova.framework.drawable.Circle;
import rhinova.framework.drawable.CircleList;
import rhinova.framework.drawable.Line;

public class DrawingFunctions {

	private DrawingFunctions(){}

	/**
	 * Function to draw a list of circles
	 * @param g
	 * @param circles
	 * @param dim
	 */
	public static void drawCircles(Graphics g, Dimension d, List<Circle> circles) {

		for(Circle c: circles) {
			// outer circle
			g.setColor(Color.blue); // color of outer radius
			double rMax = c.getMaxR();
			g.fillOval(
					(int)((c.getX()-rMax/2)*d.width),
					(int)((c.getY()-rMax/2)*d.height),
					(int)(rMax*d.width),
					(int)(rMax*d.height));
			
			// middle circle
			g.setColor(Color.orange);
			double rCur = c.getCurR(); 
			g.fillOval(
					(int)((c.getX()-rCur/2)*d.width),
					(int)((c.getY()-rCur/2)*d.height),
					(int)(rCur*d.width),
					(int)(rCur*d.height));
			
			// inner circle
			g.setColor(Color.green);
			double rMin = c.getMinR();
			g.fillOval(
					(int)((c.getX()-rMin/2)*d.width),
					(int)((c.getY()-rMin/2)*d.height),
					(int)(rMin*d.width),
					(int)(rMin*d.height));
		}
	}

	public static void drawLineNames(Graphics g, Dimension d, List<Line> lines) {
		System.err.println("Implement me");
	}


	private static DrawingFunctions drawingFunctions = new DrawingFunctions();
	
	/**
	 * Function to draw a background image
	 * @param g
	 * @param size
	 * @param backgroundImagePath
	 */
	public static void drawBackgroundImage(Graphics g, Dimension d, String backgroundImagePath){
		BufferedImage img = null;
		
		URL imgUri = drawingFunctions.getClass().getResource("/resoursource/img/Map.png");
		try {
			img = ImageIO.read(imgUri);
			g.drawImage(img,
					0, 0, d.width, d.height,
					0, 0, img.getWidth(null), img.getHeight(null),
					null);
		} catch (Exception e) {
			System.out.println("Couldn't draw image");
		}

	}


	/**
	 * Function to draw the names of the circles
	 * @param g
	 * @param circles
	 * @param dim
	 */
	public static void drawCircleNames(Graphics g, Dimension d, CircleList circles) {

		for(Circle c: circles) {
			
			// text :
			g.setColor(Color.cyan);
			Font font = new Font("Serif", Font.PLAIN, (int) (0.02*Math.sqrt(d.height*d.height + d.width*d.width)));
			
			g.setFont(font);
			g.drawString(
					c.getName(),
					(int)(c.getX()*d.getWidth()),
					(int)(c.getY()*d.height));
		}
	}

	/**
	 * Function to draw a list of lines
	 * @param g
	 * @param lines
	 * @param dim
	 */
	public static void drawLines(Graphics g, List<Line> lines, Dimension d) {
		for (Line line : lines) {
			g.setColor(colorGreenRed(line.getColor()));
			drawThickLine(
					g,
					(int)(line.getX1()*d.width),
					(int)(line.getY1()*d.height),
					(int)(line.getX2()*d.width),
					(int)(line.getY2()*d.height),
					(int)(line.getThickness()*Math.sqrt(d.height*d.height + d.width*d.width)));
			
		}
	}

	/**
	 * Method to draw a thick line (http://www.rgagnon.com/javadetails/java-0260.html)
	 * @param g
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param thickness
	 */
	public static void drawThickLine(
			Graphics g, int x1, int y1, int x2, int y2, int thickness) {
		// The thick line is in fact a filled polygon
		int dX = x2 - x1;
		int dY = y2 - y1;
		// line length
		double lineLength = Math.sqrt(dX * dX + dY * dY);

		double scale = (double)(thickness) / (2 * lineLength);

		// The x,y increments from an endpoint needed to create a rectangle...
		double ddx = -scale * (double)dY;
		double ddy = scale * (double)dX;
		ddx += (ddx > 0) ? 0.5 : -0.5;
		ddy += (ddy > 0) ? 0.5 : -0.5;
		int dx = (int)ddx;
		int dy = (int)ddy;

		// Now we can compute the corner points...
		int xPoints[] = new int[4];
		int yPoints[] = new int[4];

		xPoints[0] = x1 + dx; yPoints[0] = y1 + dy;
		xPoints[1] = x1 - dx; yPoints[1] = y1 - dy;
		xPoints[2] = x2 - dx; yPoints[2] = y2 - dy;
		xPoints[3] = x2 + dx; yPoints[3] = y2 + dy;

		g.fillPolygon(xPoints, yPoints, 4);
	}





	/**
	 * Method to draw a section of a Bezear curve
	 * @param xA - starting Point x value
	 * @param yA - starting Point y value
	 * @param xZ - ending Point x value 
	 * @param yZ - ending Point y value
	 * @param t - percent of the Bezer curve to be drawn from the starting point
	 * @param g - the Gaphics object to be parsed
	 */
	public static void drawBezerSection(
			Dimension d,
			double xA, double yA,
			double xZ, double yZ,
			double  t, Graphics g,
			double thickness) {

		// Global Beazer curve
		Point startPoint = new Point(xA, yA);
		Point midPoint = getMidBezerPoint(xA, yA, xZ, yZ);
		Point endPoint = new Point(xZ, yZ);

		// Local section Beazer curve
		Point p0 = startPoint;
		Point p1 = beazerFunc(startPoint, midPoint, endPoint, t/2.0);
		Point p2 = beazerFunc(startPoint, midPoint, endPoint, t);

		// drawing the curve
		Graphics2D g2 = (Graphics2D) g;
		
		// set the thickness
	    Stroke stroke = new BasicStroke(
	    		(int)(thickness*Math.sqrt(d.height*d.height + d.width*d.width)),
	    		BasicStroke.CAP_BUTT,
	    		BasicStroke.JOIN_BEVEL,
	    		0,
	    		new float[] { 1, 0 },
	    		0);
		g2.setStroke(stroke);
		g2.setColor(Color.cyan);
		
		
		try{
			QuadCurve2D q = new QuadCurve2D.Float();
			q.setCurve(p0.getX(), p0.getY(), p1.getX(), p1.getY(), p2.getX(), p2.getY());
			g2.draw(q);
		} catch(Exception e){e.printStackTrace();}

	}



	/**
	 * Method to draw Bezer Sections
	 * @param g
	 * @param lines
	 * @param t
	 */
	public static void drawBezerLineSections(Graphics g, Dimension d, List<Line> lines, double t) {
		for (Line line : lines) {
			drawBezerSection(
					d, line.getX1()*d.width, line.getY1()*d.height,
					line.getX2()*d.width, line.getY2()*d.height,
					t, g,
					line.getThickness());
		}
	}




	/**
	 * Function to find another point to construct a Beazer curve between two points.
	 * @param x0
	 * @param y0
	 * @param x2
	 * @param y2
	 * @return
	 */
	public static Point getMidBezerPoint(double x0, double y0, double x2, double y2) {

		double dx = x2-x0;
		double dy = y2-y0;

		double d = Math.sqrt(dx*dx + dy*dy);
		double theta = Math.atan2(dy, dx);

		double newX = d/3*Math.cos(theta+90)+(x0+x2)/2.0;
		double newY = d/3*Math.sin(theta+90)+(y0+y2)/2.0;

		return new Point(newX,newY);
	}




	/**
	 * Function to find the point at t on a Beazer curve. 
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param t
	 * @return
	 */
	public static Point beazerFunc(Point p0, Point p1, Point p2, double t) {
		return new Point(beaz(p0.x,p1.x,p2.x,t), beaz(p0.y,p1.y,p2.y,t));
	}





	/** Quadratic Beazer relationship 
	 * @param x0
	 * @param x1
	 * @param x2
	 * @param t
	 * @return
	 */
	private static double beaz(double x0, double x1, double x2, double t) {
		double result = (1-t)*(1-t)*x0 + 2*(1-t)*t*x1 + t*t*x2;
		return result;
	}





	/**
	 * @author Derrick
	 * Class to encapsulate a point
	 *
	 */
	public static class Point {
		double x;
		double y;

		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public double getX() {return x;}
		public double getY() {return y;}

		public String toString() {
			return this.x +", " + this.y;
		}
	}
	
	static Color colorGreenRed(double ratio) {
		int red  = (int) (255 - 255*ratio);
		int blue = (int) (255 * ratio);
		return new Color(red, 0, blue);
	}


}