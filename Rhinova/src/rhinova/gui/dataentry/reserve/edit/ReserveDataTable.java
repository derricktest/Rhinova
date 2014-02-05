package rhinova.gui.dataentry.reserve.edit;

import rhinova.gui.dataentry.dataedit.JTablePanel;
import rhinova.metapopulation.model.components.reserve.Reserve;

public class ReserveDataTable extends JTablePanel {

	private static final long serialVersionUID = 1L;

	public ReserveDataTable() {
		super(Reserve.getHeadingStatic());
	}

}
