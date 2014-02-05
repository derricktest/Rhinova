/*
 * Created by JFormDesigner on Tue Jan 07 11:23:52 FET 2014
 */

package rhinova.gui.dataentry.link;

import java.awt.*;

import javax.swing.*;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import rhinova.metapopulation.model.components.link.table.events.LinkClearEvent;
import rhinova.metapopulation.model.components.link.table.events.LinkDataTableClickedEvent;
import rhinova.metapopulation.model.components.reserve.aspect.ReserveListUpdateEvent;

/**
 * @author derrick futschik
 */
public class LinkDataEditPannel extends JPanel implements ApplicationListener<ApplicationEvent>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String[] getInput() {
		return new String[]{
				this.lblId.getText(),
				this.txtName.getText(),
				this.txtCapacity.getText(),
				this.txtSurvivalRate.getText(),
				this.comboReserve1.getSelectedItem()+"",
				this.comboReserve2.getSelectedItem()+""};
	}

	public LinkDataEditPannel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		label1 = new JLabel();
		label2 = new JLabel();
		lblId = new JLabel();
		label3 = new JLabel();
		txtName = new JTextField();
		label8 = new JLabel();
		txtCapacity = new JTextField();
		label4 = new JLabel();
		txtSurvivalRate = new JTextField();
		label5 = new JLabel();
		comboReserve1 = new JComboBox<>();
		label6 = new JLabel();
		comboReserve2 = new JComboBox<>();

		//======== this ========
		setLayout(new GridBagLayout());
		((GridBagLayout)getLayout()).columnWidths = new int[] {54, 0, 0};
		((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
		((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

		//---- label1 ----
		label1.setText("Link Properties");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(label1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label2 ----
		label2.setText("id");
		add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 15, 15), 0, 0));
		add(lblId, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label3 ----
		label3.setText("name");
		add(label3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 15, 15), 0, 0));
		add(txtName, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label8 ----
		label8.setText("capacity");
		add(label8, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 15, 15), 0, 0));
		add(txtCapacity, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label4 ----
		label4.setText("survival rate");
		add(label4, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 15, 15), 0, 0));
		add(txtSurvivalRate, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label5 ----
		label5.setText("reserve 1");
		add(label5, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 15, 15), 0, 0));
		add(comboReserve1, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label6 ----
		label6.setText("reserve 2");
		add(label6, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 0, 15), 0, 0));
		add(comboReserve2, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JLabel label1;
	private JLabel label2;
	private JLabel lblId;
	private JLabel label3;
	private JTextField txtName;
	private JLabel label8;
	private JTextField txtCapacity;
	private JLabel label4;
	private JTextField txtSurvivalRate;
	private JLabel label5;
	private JComboBox<Integer> comboReserve1;
	private JLabel label6;
	private JComboBox<Integer> comboReserve2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables






	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void onApplicationEvent(ApplicationEvent ev) {

		if (ev instanceof ReserveListUpdateEvent) {
			ReserveListUpdateEvent event  = (ReserveListUpdateEvent) ev;
			this.comboReserve1.setModel(new DefaultComboBoxModel(event.getReserveIDs().toArray()));
			this.comboReserve2.setModel(new DefaultComboBoxModel(event.getReserveIDs().toArray()));
		} else if (ev instanceof LinkClearEvent) {
			@SuppressWarnings("unused")
			LinkClearEvent event = (LinkClearEvent) ev;
			clearEntries();
		} else if (ev instanceof LinkDataTableClickedEvent) {
			LinkDataTableClickedEvent event = (LinkDataTableClickedEvent) ev;
			this.setEntries(event.getData());
		}

	}
	
	private void setEntries(Object[] data) {
		this.lblId.setText(data[0]+"");
		this.txtName.setText(data[1]+"");
		this.txtCapacity.setText(data[2]+"");
		this.txtSurvivalRate.setText(data[3]+"");
		this.comboReserve1.setSelectedItem(data[4]);
		this.comboReserve2.setSelectedItem(data[5]);
	}
	
	private void clearEntries() {
		this.lblId.setText("");
		this.txtCapacity.setText("");
		this.txtName.setText("");
		this.txtSurvivalRate.setText("");
	}

	
	

}
