package rhinova.metapopulation.model.components.link.table.events;

import org.springframework.context.ApplicationEvent;

public class LinkDataEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	String[] data;
	
	public LinkDataEvent(Object source, String[] data) {
		super(source);
		this.data = data;
	}
	
	public String[] getData() {
		return data;
	}

}
