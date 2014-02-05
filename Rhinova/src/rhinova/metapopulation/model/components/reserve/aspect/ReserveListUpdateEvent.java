package rhinova.metapopulation.model.components.reserve.aspect;

import java.util.List;

import org.springframework.context.ApplicationEvent;

public class ReserveListUpdateEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	final List<Integer> reserveIDs;

	public ReserveListUpdateEvent(Object source, List<Integer> reserveIDs) {
		super(source);
		this.reserveIDs = reserveIDs;
	}
	
	public List<Integer> getReserveIDs() {
		return this.reserveIDs;
	}

}
