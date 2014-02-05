package rhinova.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import rhinova.gui.dataentry.link.LinkDataEntryPanel;
import rhinova.gui.dataentry.reserve.ReserveDataEntryPanel;
import rhinova.gui.main.view.gis.HomeGISPanel;
import rhinova.gui.main.view.toolbar.MainToolBar;


public class HomeView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	ReserveDataEntryPanel reserveDataEntry;
	LinkDataEntryPanel linkDataEntryPanel;
	HomeGISPanel homeGISPanel;
	MainToolBar menueBar;
	
	public HomeView(
			ReserveDataEntryPanel reserveDataEntry,
			LinkDataEntryPanel linkDataEntryPanel,
			HomeGISPanel homeGISPanel,
			MainToolBar menueBar)
	{
		this.reserveDataEntry = reserveDataEntry;
		this.linkDataEntryPanel = linkDataEntryPanel;
		this.homeGISPanel = homeGISPanel;
		this.menueBar = menueBar;
		
		initComponents();
		
	}
	
	
	private void initComponents(){
		this.setSize(500,500);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane reserveScrollPane = new JScrollPane(reserveDataEntry);
		reserveScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollPane linkScrollPane = new JScrollPane(linkDataEntryPanel);
		linkScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		JSplitPane splitPane = new JSplitPane(
				JSplitPane.VERTICAL_SPLIT,
				reserveScrollPane,
				linkScrollPane);
		this.add(splitPane, BorderLayout.EAST);
		this.add(homeGISPanel, BorderLayout.CENTER);
		if (menueBar!=null) {
			this.setJMenuBar(menueBar);
		}
	}
	

}
