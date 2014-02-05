package rhinova.gui.main.view.controller;

import javax.swing.JPanel;

public abstract class Controllable extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	
	public abstract void skipStart();
	public abstract void stepBack();
	public abstract void play();
	public abstract void pause();
	public abstract void stop();
	public abstract void stepForward();
	public abstract void skipEnd();
	
}
