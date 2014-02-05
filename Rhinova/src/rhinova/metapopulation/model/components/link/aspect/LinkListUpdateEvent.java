package rhinova.metapopulation.model.components.link.aspect;


import org.springframework.context.ApplicationEvent;

public class LinkListUpdateEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	public LinkListUpdateEvent(Object source) {
		super(source);
	}

}
