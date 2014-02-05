package rhinova.gui.main.view.controller;

import org.springframework.context.ApplicationEvent;

public class ControllerEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	final ControllerAction action;

	public ControllerEvent(Object source, ControllerAction action) {
		super(source);
		this.action = action;
	}
	
	public ControllerAction getAction() {
		return action;
	}

}
