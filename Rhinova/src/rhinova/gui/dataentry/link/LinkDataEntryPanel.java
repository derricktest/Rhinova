/*
 * Created by JFormDesigner on Sat Dec 14 13:15:44 FET 2013
 */

package rhinova.gui.dataentry.link;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.springframework.context.ApplicationListener;

import rhinova.framework.entity.exceptions.EntityExceptionDialogs;
import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;
import rhinova.framework.entity.tableable.exceptions.NullInputException;
import rhinova.metapopulation.model.components.link.LinkList;
import rhinova.metapopulation.model.components.reserve.aspect.ReserveListUpdateEvent;

/**
 * @author derrick futschik
 */
@SuppressWarnings("rawtypes")
public class LinkDataEntryPanel extends JPanel implements ApplicationListener<ReserveListUpdateEvent>{

	private static final long serialVersionUID = 1L;

	LinkList linkList;
	
	
	public void setLinkList(LinkList linkList) {
		this.linkList = linkList;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public void onApplicationEvent(ReserveListUpdateEvent arg0) {
		this.res1.setModel(new DefaultComboBoxModel(arg0.getReserveIDs().toArray()));
		this.res2.setModel(new DefaultComboBoxModel(arg0.getReserveIDs().toArray()));

	}



	public LinkDataEntryPanel() {
		initComponents();
	}

	private void btnCreateActionPerformed(ActionEvent ev) {
		try {
			// test if the Tableable object can be created
			linkList.createTableable(getUserInputArray());

			// ask for confirmation
			int response = JOptionPane.showConfirmDialog(null, "Do you wish to create this Componenet?", "Confirm?", JOptionPane.YES_NO_CANCEL_OPTION);
			if (response == 0)
			{
				// create the object
				linkList.createAndAddNewInstance(getUserInputArray());
				JOptionPane.showMessageDialog(null, "Model Component Created", "Success", JOptionPane.INFORMATION_MESSAGE);
			}
			// report exceptions to the user
		} catch (IncorrectDataType e) {
			EntityExceptionDialogs.onIncorrectDataType(e.getMessage());
		} catch (ConstraintViolatedException e) {
			EntityExceptionDialogs.onConstraintViolateException(e.getMessage());
		} catch (NullInputException e) {
			EntityExceptionDialogs.onNullInputException(e.getMessage());
		}
	}

	private String[] getUserInputArray() {
		String stringId = ""; // not updating the id
		String stringName = txtName.getText();
		String stringCapacity = txtCap.getText();
		String stringSurvivalRate = txtSur.getText();
		String stringReserveNo1 = res1.getModel().getSelectedItem()+"";
		String stringReserveNo2 = res2.getModel().getSelectedItem()+"";

		return new String[]{stringId, stringName, stringCapacity, stringSurvivalRate, stringReserveNo1, stringReserveNo2};
	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		vSpacer5 = new JPanel(null);
		label2 = new JLabel();
		hSpacer1 = new JPanel(null);
		label1 = new JLabel();
		txtName = new JTextField();
		vSpacer4 = new JPanel(null);
		label6 = new JLabel();
		txtCap = new JTextField();
		vSpacer3 = new JPanel(null);
		label7 = new JLabel();
		txtSur = new JTextField();
		hSpacer2 = new JPanel(null);
		vSpacer2 = new JPanel(null);
		label8 = new JLabel();
		res1 = new JComboBox();
		vSpacer1 = new JPanel(null);
		label9 = new JLabel();
		res2 = new JComboBox();
		vSpacer6 = new JPanel(null);
		btnCreate = new JButton();
		hSpacer3 = new JPanel(null);

		//======== this ========
		setLayout(new GridBagLayout());
		((GridBagLayout)getLayout()).columnWidths = new int[] {0, 65, 145, 0, 0};
		((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
		((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
		add(vSpacer5, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label2 ----
		label2.setText("Link Entry Panel");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(label2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(hSpacer1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label1 ----
		label1.setText("name");
		add(label1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(txtName, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(vSpacer4, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label6 ----
		label6.setText("capacity");
		add(label6, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(txtCap, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(vSpacer3, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label7 ----
		label7.setText("survival rate");
		add(label7, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(txtSur, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(hSpacer2, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 0), 0, 0));
		add(vSpacer2, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label8 ----
		label8.setText("reserve1");
		add(label8, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(res1, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(vSpacer1, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label9 ----
		label9.setText("reserve2");
		add(label9, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(res2, new GridBagConstraints(2, 10, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(vSpacer6, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- btnCreate ----
		btnCreate.setText("Create Link");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCreateActionPerformed(e);
			}
		});
		add(btnCreate, new GridBagConstraints(2, 12, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(hSpacer3, new GridBagConstraints(2, 13, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 5), 0, 0));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JPanel vSpacer5;
	private JLabel label2;
	private JPanel hSpacer1;
	private JLabel label1;
	private JTextField txtName;
	private JPanel vSpacer4;
	private JLabel label6;
	private JTextField txtCap;
	private JPanel vSpacer3;
	private JLabel label7;
	private JTextField txtSur;
	private JPanel hSpacer2;
	private JPanel vSpacer2;
	private JLabel label8;
	private JComboBox res1;
	private JPanel vSpacer1;
	private JLabel label9;
	private JComboBox res2;
	private JPanel vSpacer6;
	private JButton btnCreate;
	private JPanel hSpacer3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables



}
