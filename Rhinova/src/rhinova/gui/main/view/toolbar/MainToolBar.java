package rhinova.gui.main.view.toolbar;

import java.util.Collections;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import org.springframework.beans.factory.annotation.Autowired;

public class MainToolBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	public MainToolBar(List<MainToolBarMenu> menuBar) {
		super();
		Collections.sort(menuBar);
		for (JMenu bar : menuBar) {
			this.add(bar);
		}
	}
	
	

}
