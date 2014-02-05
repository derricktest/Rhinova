package rhinova.metapopulation.model.components.reserve.table.event;

import org.springframework.context.ApplicationEvent;

public class ReserveRefreshEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReserveRefreshEvent(Object source) {
		super(source);
	}

}
