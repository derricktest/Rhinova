package rhinova.metapopulation.model.components.reserve.table.event;

import org.springframework.context.ApplicationEvent;

public class ReserveDeleteEvent extends ApplicationEvent {

	
	private static final long serialVersionUID = 1L;

	public ReserveDeleteEvent(Object source) {
		super(source);
	}

}
