package rhinova.metapopulation.model.components.reserve.table;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ReserveTablePanel extends JPanel {


	private static final long serialVersionUID = 1L;

	final ReserveTableModel model;

	public ReserveTablePanel(ReserveTableModel model) {
		this.model = model;

		this.initComponents();

	}

	private void initComponents()  {
		// table
		JTable jTable1 = new javax.swing.JTable();
		jTable1.setModel(model);

		// scroll pane
		JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setViewportView(jTable1);

		// adding the scrollpane
		this.add(jScrollPane1);
	}


}


