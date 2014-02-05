package rhinova.framework.drawable;

import java.awt.Dimension;
import java.awt.Graphics;

import rhinova.metapopulation.model.graphicx.DrawingFunctions;

public class ImageShape extends Shape {

	public static void drawBackGround(Graphics g, Dimension d, String path) {
		DrawingFunctions.drawBackgroundImage(g, d, path);
	}
	
}
