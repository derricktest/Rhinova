package util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageUtil {

	/**
	 * Get a buffered image from a path
	 * @param path - path to image
	 * @return
	 */
	public static BufferedImage loadImage(String path) {
		BufferedImage img = null;
		try {
			img =  ImageIO.read(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return img;
	}
	
	/**
	 * Finds the width, and height of an image
	 * @param img
	 * @return
	 */
	public static int[] getWidthAndHeight(BufferedImage img) {
		return new int[] {img.getWidth(), img.getHeight()};
	}

}
