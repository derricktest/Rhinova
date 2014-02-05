package rhinova.metapopulation.model.components.link.table;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;

import rhinova.metapopulation.model.components.link.table.events.LinkDataTableClickedEvent;


/*
 * Note to self, using Java's JTable Model is just a nightmare. There is problem after problem it is too unituitive to use.
 * I am considering creating my own however I think swing is a bunch of bullcrap and I hate it
 * 
 */


public class LinkTablePanel extends JPanel implements ApplicationListener<ApplicationEvent> {

	private static final long serialVersionUID = 1L;

	final LinkTableModel model;
	final JTable jTable1;

	@Autowired
	ApplicationEventPublisher publisher;

	public LinkTablePanel(LinkTableModel model) {
		this.model = model;
		jTable1 = new javax.swing.JTable();
		this.initComponents();

	}

	private void initComponents()  {
		// table

		jTable1.setModel(model);

		jTable1.getSelectionModel().addListSelectionListener(new RowListener());


		// scroll pane
		JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setViewportView(jTable1);

		// adding the scrollpane
		this.add(jScrollPane1);
	}




	private class RowListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {
			if (event.getValueIsAdjusting()) {
				return;
			}
			int rowIndex = jTable1.getSelectedRow();
			int columnCount = jTable1.getModel().getColumnCount();
			Object[] data = new Object[columnCount];
			for (int columnIndex=0; columnIndex<columnCount; columnIndex++ ) {
				data[columnIndex] = jTable1.getModel().getValueAt(rowIndex, columnIndex); 
			}
			publisher.publishEvent(new LinkDataTableClickedEvent(this, data));
		}
	}




	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					repaint();
				} catch (Exception e) {

				}
			}
		});
	}
}
