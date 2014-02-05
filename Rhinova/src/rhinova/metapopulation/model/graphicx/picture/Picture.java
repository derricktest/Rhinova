package rhinova.metapopulation.model.graphicx.picture;

import java.awt.Dimension;
import java.awt.Graphics;

/**
 * @author Derrick
 * 
 * Class which is to be a simple picture in a picture animation
 *
 */
public abstract class Picture {
	
	int pause;
	

	
	Picture(int pause) {
		this.pause = pause;
	}
	
	/**
	 * Factor to scale the time pause for all pictures
	 * @param factor
	 */
	public static void setScaleFactor(double factor) {
		pauseScaleFactor = factor;
	}
	
	/**
	 * @return pause
	 */
	public int getPause() {
		return this.pause;
	}
	
	public int getScaledPause() { 
		return (int) (this.getPause()*pauseScaleFactor);
	}
	
	
	private static double pauseScaleFactor;
	
	public abstract void draw(Graphics g, Dimension d);
	
	
	
}
