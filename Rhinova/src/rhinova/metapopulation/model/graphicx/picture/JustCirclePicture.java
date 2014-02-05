package rhinova.metapopulation.model.graphicx.picture;

import java.awt.Dimension;
import java.awt.Graphics;

import rhinova.framework.drawable.CircleList;
import rhinova.framework.drawable.LineList;
import rhinova.metapopulation.model.graphicx.DrawingFunctions;



public class JustCirclePicture extends ShapePicture {

	public JustCirclePicture(
			LineList lines,
			CircleList circles,
			int pause,
			String backGroundPath,
			int year,
			String stage,
			double population,
			int populationIndex) {
		super(lines, circles, pause, backGroundPath, year, stage, population, populationIndex);
	}

	@Override
	public void draw(Graphics g, Dimension d) {
		// super to draw the background
		super.draw(g, d);
		
		if (circles == null) {
			return;
		}
		
		// draw the circles
		DrawingFunctions.drawCircles(g, d, circles);
		// draw the circle names
		if (isDisplayingCircleNames()) {
			DrawingFunctions.drawCircleNames(g, d, circles);
		}
	}


}
