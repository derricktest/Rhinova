package rhinova.metapopulation.model.components.reserve;

import org.springframework.context.ApplicationEvent;

public class ReserveEditDataEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReserveEditDataEvent(Object source) {
		super(source);
	}

}
