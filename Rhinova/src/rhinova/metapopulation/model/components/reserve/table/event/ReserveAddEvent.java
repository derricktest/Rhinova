package rhinova.metapopulation.model.components.reserve.table.event;

import org.springframework.context.ApplicationEvent;

public class ReserveAddEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReserveAddEvent(Object source) {
		super(source);
	}

}
