package rhinova.metapopulation.model.components.reserve.table.event;

import org.springframework.context.ApplicationEvent;

public class ReserveClearEvent extends ApplicationEvent {

	
	private static final long serialVersionUID = 1L;

	public ReserveClearEvent(Object source) {
		super(source);
	}

}
