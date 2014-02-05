package rhinova.metapopulation.model.components.link.table.events;

import org.springframework.context.ApplicationEvent;

public class LinkClearEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LinkClearEvent(Object source) {
		super(source);
		
	}

}
