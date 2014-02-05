package rhinova.metapopulation.model.optimise;

import org.springframework.context.ApplicationEvent;

/**
 * @author Derrick
 * Event to cause the <code>Optimiser</code> to produce an <code>OptimisedResultSet</code>
 *
 */
public class OptimiseEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OptimiseEvent(Object source) {
		super(source);
	}

}
