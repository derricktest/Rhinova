package rhinova.metapopulation.model.graphicx.picture;


import java.awt.Dimension;
import java.awt.Graphics;

import rhinova.framework.drawable.CircleList;
import rhinova.framework.drawable.ImageShape;
import rhinova.framework.drawable.LineList;

/**
 * @author Derrick
 * Picture which has a List of Lines and a List of Circles which are shared between the entire class.
 */
public abstract class ShapePicture extends SimulatedPicture {
	
	protected LineList 	lines = null;
	protected CircleList 	circles = null;
	
	private static boolean displayingCircleNames = true;
	private static boolean displayingLinkNames = true;
	
	public void setLines(LineList l) 		{		lines = l;	}
	public void setCircles(CircleList c) 	{		circles = c;	}
	public LineList getLines() 			{	return lines;	}
	public CircleList getCircles() 		{	return circles;	}
	
	public static boolean isDisplayingCircleNames() {		return displayingCircleNames;	}
	public static boolean isDisplayingLinkNames()   {		return displayingLinkNames;	}
	public static void setDisplayingCircleNames(boolean displayingCircleNames) 	{		ShapePicture.displayingCircleNames = displayingCircleNames;	}
	public static void setDisplayingLinkNames(boolean displayingLinkNames) 		{		ShapePicture.displayingLinkNames = displayingLinkNames;	}


	
	String backGroundImgPath = null;
	

	
	public ShapePicture(
			LineList lines,
			CircleList circles,
			int pause,
			String backGroundImgPath,
			int year,
			String stage,
			double population,
			int populationIndex) {
		super(pause, year, stage, population, populationIndex);
		this.backGroundImgPath = backGroundImgPath;
		this.lines = lines;
		this.circles = circles;
	}
	

	
	@Override
	public void draw(Graphics g, Dimension d) {
		ImageShape.drawBackGround(g, d, this.backGroundImgPath);
	}
	

}
