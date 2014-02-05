package rhinova.gui.main.view.toolbar.bars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import rhinova.gui.main.view.gis.HomeGISPanel;
import rhinova.gui.main.view.toolbar.MainToolBarMenu;


public class ViewBar extends MainToolBarMenu {

	private static final long serialVersionUID = 1L;

	HomeGISPanel gisPanel;

	
	public void setGisPanel(HomeGISPanel gisPanel) {
		this.gisPanel = gisPanel;
	}


	public ViewBar() {
		
		super("View");
		
		addNewAl(new ViewSaveAction(), 	"Save Image");
	}
	
	
	public class ViewSaveAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			JFileChooser fc = new JFileChooser();

			int response = fc.showSaveDialog(null);
			if (response == 0)
			{
				
				BufferedImage img = new BufferedImage(gisPanel.getWidth(), gisPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
				gisPanel.paint(img.getGraphics());
				try {
					ImageIO.write(img, "PNG", new File(fc.getSelectedFile().getPath()+".png"));
				} catch (IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Cannot Save Image.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}		
	}

}
