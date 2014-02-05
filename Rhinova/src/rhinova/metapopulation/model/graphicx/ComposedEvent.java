package rhinova.metapopulation.model.graphicx;

import org.springframework.context.ApplicationEvent;

/**
 * @author Derrick
 *
 * Event which is fired when the movie has been composed
 */
public class ComposedEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ComposedEvent(Object source) {
		super(source);
	}

}
