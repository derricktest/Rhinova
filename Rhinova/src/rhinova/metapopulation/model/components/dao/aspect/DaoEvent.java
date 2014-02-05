package rhinova.metapopulation.model.components.dao.aspect;

import org.springframework.context.ApplicationEvent;

public class DaoEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String file;

	public DaoEvent(Object source, String file) {
		super(source);
		this.file = file;
	}
	
	public String getFile() {
		return file;
	}

}
