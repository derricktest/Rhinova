package rhinova.gui.main.view.toolbar;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public abstract class MainToolBarMenu extends JMenu implements Comparable<MainToolBarMenu>{

	private static final long serialVersionUID = 1L;

	public MainToolBarMenu(String name) {
		super(name);
	}
	
	
	protected void addNewAl(ActionListener al, String name) {
		JMenuItem ji = new JMenuItem(name);
		ji.addActionListener(al);
		this.add(ji);
	}
	
	public int getPlace() {
		return 100;
	}


	@Override
	public int compareTo(MainToolBarMenu arg0) {
		return this.getPlace() - arg0.getPlace();
	}
}
