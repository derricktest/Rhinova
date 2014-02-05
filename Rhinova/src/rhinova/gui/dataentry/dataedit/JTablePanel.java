package rhinova.gui.dataentry.dataedit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTablePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	final JTable table;
	
	public JTablePanel (String[] headings) {
		
		int headingSize = headings.length;
		Object[][] data = new Object[1][headingSize];
		for (int i=0; i<headingSize; i++) {
			data[0][i] = "0";
		}
		this.table = new JTable(data, headings);
		this.add(new JScrollPane(table));
	}
	
	
	
	public static void main(String[] args) {
		
		JFrame frm = new JFrame();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(400,400);
		
		frm.add(new JTablePanel(new String[]{"hello", "goodbye"}));
		frm.setVisible(true);
	}

}
