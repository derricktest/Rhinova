package rhinova.gui.dataentry.dataedit;

import javax.swing.JPanel;

/**
 * @author Derrick
 *
 * Functionality which must be present in the view of
 * a <code>Tableable</code> object
 */
public abstract class PropertiesView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	
	public abstract String[] getPropeties();
	public abstract void setProperties(String[] properties);
	public abstract void clearView();

}
