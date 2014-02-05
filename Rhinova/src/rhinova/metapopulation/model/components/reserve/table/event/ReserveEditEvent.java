package rhinova.metapopulation.model.components.reserve.table.event;

import org.springframework.context.ApplicationEvent;

public class ReserveEditEvent extends ApplicationEvent {

	
	private static final long serialVersionUID = 1L;

	public ReserveEditEvent(Object source) {
		super(source);
	}

}
