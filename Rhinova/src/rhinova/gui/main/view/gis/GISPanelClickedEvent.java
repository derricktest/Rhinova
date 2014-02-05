package rhinova.gui.main.view.gis;

import org.springframework.context.ApplicationEvent;

/**
 * Event for sending the coordinates of the mouse when it clicks on the GISPanel
 */
public class GISPanelClickedEvent extends ApplicationEvent {


	private static final long serialVersionUID = 1L;

	final double x;
	final double y;
	
	public GISPanelClickedEvent(
			Object source,
			double x,
			double y) {
		super(source);
		this.x = x;
		this.y = y;
	}
	
	public double getX() { return this.x;	}
	public double getY() { return this.y;	}

}
