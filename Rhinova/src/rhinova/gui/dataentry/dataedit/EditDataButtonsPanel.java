package rhinova.gui.dataentry.dataedit;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import resoursource.ResourceLoader;
import rhinova.framework.buttons.TableButton;

public class EditDataButtonsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JButton btnAdd = 		new TableButton("Add");
	JButton btnClear = 		new TableButton("Clear");
	JButton btnDelete = 	new TableButton("Delete");
	JButton btnEdit = 		new TableButton("Edit");
	JButton btnRefresh = 	new TableButton("Refresh");
	
	
	
	public EditDataButtonsPanel() {
		
		this.setLayout(new GridLayout(5, 1));
		
		
		btnAdd.setIcon(		new ImageIcon(ResourceLoader.getIconPath("add.gif")));
		btnClear.setIcon(	new ImageIcon(ResourceLoader.getIconPath("clear.gif")));
		btnDelete.setIcon(	new ImageIcon(ResourceLoader.getIconPath("delete.gif")));
		btnEdit.setIcon(	new ImageIcon(ResourceLoader.getIconPath("edit.gif")));
		btnRefresh.setIcon(	new ImageIcon(ResourceLoader.getIconPath("refresh.gif")));

		this.add(btnAdd);
		this.add(btnClear);
		this.add(btnDelete);
		this.add(btnEdit);
		this.add(btnRefresh);
		
	}
	
	public void addBtnAddActionListener(ActionListener al) {
		this.btnAdd.addActionListener(al);
	}
	
	public void addBtnClearActionListener(ActionListener al) {
		this.btnClear.addActionListener(al);
	}
	
	public void addBtnDeleteActionListener(ActionListener al) {
		this.btnDelete.addActionListener(al);
	}
	
	public void addBtnEditActionListener(ActionListener al) {
		this.btnEdit.addActionListener(al);
	}
	
	public void addBtnRefreshActionListener(ActionListener al) {
		this.btnRefresh.addActionListener(al);
	}
	
	public static void main(String[] args) {
		JFrame frm = new JFrame();
		frm.add(new EditDataButtonsPanel());
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(200,200);
		frm.setVisible(true);
	}

}
