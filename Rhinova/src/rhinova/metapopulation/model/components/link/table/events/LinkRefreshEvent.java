package rhinova.metapopulation.model.components.link.table.events;

import org.springframework.context.ApplicationEvent;

public class LinkRefreshEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LinkRefreshEvent(Object source) {
		super(source);
	}

}
