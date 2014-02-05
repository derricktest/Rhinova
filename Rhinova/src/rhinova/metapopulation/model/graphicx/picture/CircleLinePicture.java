package rhinova.metapopulation.model.graphicx.picture;

import java.awt.Dimension;
import java.awt.Graphics;

import rhinova.framework.drawable.CircleList;
import rhinova.framework.drawable.LineList;
import rhinova.metapopulation.model.graphicx.DrawingFunctions;

public class CircleLinePicture extends JustCirclePicture {

	public CircleLinePicture(
			LineList lines,
			CircleList circles,
			int pause,
			String backGroundPath,
			int year,
			String stage,
			double population,
			int populationIndex)
			{
		super(lines, circles, pause, backGroundPath, year, stage, population, populationIndex);
	}
	
	@Override
	public void draw(Graphics g, Dimension d) {
		// draw background picture and circles
		super.draw(g, d);
		// draw lines
		
		if (lines == null) {
			return;
		}
		DrawingFunctions.drawLines(g, lines, d);
		// draw line names
		if (isDisplayingLinkNames()) {
			DrawingFunctions.drawLineNames(g, d, lines);
		}
	}
	
}
