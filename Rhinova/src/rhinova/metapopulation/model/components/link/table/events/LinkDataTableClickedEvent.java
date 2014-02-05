package rhinova.metapopulation.model.components.link.table.events;

import org.springframework.context.ApplicationEvent;

public class LinkDataTableClickedEvent extends ApplicationEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Object[] data;

	public LinkDataTableClickedEvent(Object source, Object[] data) {
		super(source);
		this.data = data;
	}
	
	public Object[] getData() {
		return data;
	}

}
