package rhinova.metapopulation.model.graphicx.picture;

import java.awt.Dimension;
import java.awt.Graphics;

import rhinova.framework.drawable.CircleList;
import rhinova.framework.drawable.LineList;
import rhinova.metapopulation.model.graphicx.DrawingFunctions;

public class ArrowCirclePicture extends JustCirclePicture {

	double t=0.0;
	
	public ArrowCirclePicture(
			LineList lines,
			CircleList circles,
			int pause,
			String backGroundImgPath,
			double t,
			int year,
			String stage,
			double population,
			int populationIndex) {
		super(lines, circles, pause, backGroundImgPath, year, stage, population, populationIndex);
		this.t = t;
	}
	
	@Override
	public void draw(Graphics g, Dimension d) {
		// draw background and circles
		super.draw(g, d);
		// draw the arrows
		if (lines == null) {
			return;
		}
		DrawingFunctions.drawBezerLineSections(g, d, lines, t);	
	}
}
