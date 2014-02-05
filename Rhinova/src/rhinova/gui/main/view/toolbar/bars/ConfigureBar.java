package rhinova.gui.main.view.toolbar.bars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rhinova.gui.main.view.GUITabbedPannelFrame;
import rhinova.gui.main.view.toolbar.MainToolBarMenu;


public class ConfigureBar extends MainToolBarMenu {

	private static final long serialVersionUID = 1L;
	
	GUITabbedPannelFrame guiPanelFrame;
	
	
	public void setGuiPanelFrame(GUITabbedPannelFrame guiPanelFrame) {
		this.guiPanelFrame = guiPanelFrame;
	}


	public ConfigureBar() {
		
		super("Configure");
		addNewAl(new ConfigureAction(), 	"Configure model");
	}
	
	
	class ConfigureAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			guiPanelFrame.setVisible(true);
		}
		
	}

}
