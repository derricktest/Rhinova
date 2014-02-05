package rhinova.metapopulation.model.components.link.table;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;

import rhinova.gui.dataentry.dataedit.EditDataButtonsPanel;
import rhinova.gui.dataentry.link.LinkDataEditPannel;
import rhinova.metapopulation.model.components.link.event.LinkEditDataEvent;
import rhinova.metapopulation.model.components.link.table.events.LinkAddEvent;
import rhinova.metapopulation.model.components.link.table.events.LinkClearEvent;
import rhinova.metapopulation.model.components.link.table.events.LinkDeleteEvent;
import rhinova.metapopulation.model.components.link.table.events.LinkEditEvent;
import rhinova.metapopulation.model.components.link.table.events.LinkRefreshEvent;

public class LinkDataTableFrame extends JFrame implements ApplicationListener<LinkEditDataEvent> {


	@Autowired
	ApplicationEventPublisher publisher;
	
	
	private static final long serialVersionUID = 1L;

	final EditDataButtonsPanel btnPanel;
	final LinkTablePanel 	tablePanel;
	final LinkDataEditPannel editPanel;

	public LinkDataTableFrame(
			LinkTablePanel tablePanel,
			LinkDataEditPannel editPanel) {
		btnPanel = new EditDataButtonsPanel();
		this.tablePanel = tablePanel;
		this.editPanel = editPanel;

		this.initComponents();
	}

	private void initComponents() {
		// layout
		this.setLayout(new BorderLayout());
		this.setSize(500,500);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 

		// left panel
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(2, 1));
		leftPanel.add(btnPanel);
		leftPanel.add(editPanel);


		// add components to the frame
		this.add(leftPanel, BorderLayout.LINE_START);
		this.add(tablePanel, BorderLayout.CENTER);
		
		
		// adding the listeners to the btnPanel
		
		btnPanel.addBtnAddActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				publisher.publishEvent(new LinkAddEvent(this, editPanel.getInput()));
			}
		});
		
		btnPanel.addBtnClearActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				publisher.publishEvent(new LinkClearEvent(this));
			}
		});
		
		btnPanel.addBtnDeleteActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				publisher.publishEvent(new LinkDeleteEvent(this, editPanel.getInput()));
			}
		});
		
		btnPanel.addBtnEditActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				publisher.publishEvent(new LinkEditEvent(this, editPanel.getInput()));
			}
		});
		
		btnPanel.addBtnRefreshActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				publisher.publishEvent(new LinkRefreshEvent(this));
			}
		});

	}

	@Override
	public void onApplicationEvent(LinkEditDataEvent arg0) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});
	}

}
