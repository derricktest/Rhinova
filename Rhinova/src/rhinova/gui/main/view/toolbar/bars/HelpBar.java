package rhinova.gui.main.view.toolbar.bars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rhinova.gui.WelcomeScreen;
import rhinova.gui.main.view.toolbar.MainToolBarMenu;

public class HelpBar extends MainToolBarMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelpBar(String name) {
		super(name);
		
		addNewAl(new ShowAbout(), "About");
	}
	
	public HelpBar() {
		this("Help");
	}
	
	
	public class ShowAbout implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			final WelcomeScreen welcome = new WelcomeScreen();
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					welcome.setVisible(true);
				}
			});
		}
		
	}

}
