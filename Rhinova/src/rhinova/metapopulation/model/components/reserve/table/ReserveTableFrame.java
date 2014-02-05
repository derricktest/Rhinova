package rhinova.metapopulation.model.components.reserve.table;

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
import rhinova.gui.dataentry.reserve.edit.ReserveDataEditPanel;
import rhinova.metapopulation.model.components.reserve.ReserveEditDataEvent;
import rhinova.metapopulation.model.components.reserve.table.event.ReserveAddEvent;
import rhinova.metapopulation.model.components.reserve.table.event.ReserveClearEvent;
import rhinova.metapopulation.model.components.reserve.table.event.ReserveDeleteEvent;
import rhinova.metapopulation.model.components.reserve.table.event.ReserveEditEvent;
import rhinova.metapopulation.model.components.reserve.table.event.ReserveRefreshEvent;

public class ReserveTableFrame extends JFrame implements ApplicationListener<ReserveEditDataEvent> {


	private static final long serialVersionUID = 1L;

	final EditDataButtonsPanel btnPanel;
	final ReserveTablePanel 	tablePanel;
	final ReserveDataEditPanel editPanel;
	
	@Autowired
	ApplicationEventPublisher publisher;

	public ReserveTableFrame(
			ReserveTablePanel tablePanel,
			ReserveDataEditPanel editPanel) {
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
						publisher.publishEvent(new ReserveAddEvent(this));
					}
				});
				
				btnPanel.addBtnClearActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						publisher.publishEvent(new ReserveClearEvent(this));
					}
				});
				
				btnPanel.addBtnDeleteActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						publisher.publishEvent(new ReserveDeleteEvent(this));
					}
				});
				
				btnPanel.addBtnEditActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						publisher.publishEvent(new ReserveEditEvent(this));
					}
				});
				
				btnPanel.addBtnRefreshActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						publisher.publishEvent(new ReserveRefreshEvent(this));
					}
				});
		
	}



	@Override
	public void onApplicationEvent(ReserveEditDataEvent arg0) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});
	}

}
