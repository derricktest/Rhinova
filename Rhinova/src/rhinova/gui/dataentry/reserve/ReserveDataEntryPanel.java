/*
 * Created by JFormDesigner on Sat Dec 14 13:04:56 FET 2013
 */

package rhinova.gui.dataentry.reserve;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import org.springframework.context.ApplicationListener;

import rhinova.framework.entity.exceptions.EntityExceptionDialogs;
import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;
import rhinova.framework.entity.tableable.exceptions.NullInputException;
import rhinova.gui.main.view.gis.GISPanelClickedEvent;
import rhinova.metapopulation.model.components.reserve.ReserveList;

/**
 * @author derrick futschik
 */
public class ReserveDataEntryPanel extends JPanel implements ApplicationListener<GISPanelClickedEvent> {
	
	private static final long serialVersionUID = 1L;
	
	
	ReserveList reserveList;
	
	
	public void setReserveList(ReserveList reserveList) {
		this.reserveList = reserveList;
	}
	
	@Override
	public void onApplicationEvent(GISPanelClickedEvent arg0) {
		this.setXPos(arg0.getX());
		this.setYPos(arg0.getY());
	}
	
	private void setXPos(double x) {
		this.txtXPos.setText(x+"");
	}
	
	private void setYPos(double y) {
		this.txtYPos.setText(y+"");
	}
	
	
	public ReserveDataEntryPanel() {
		initComponents();
	}

	private void btnCreateReserveActionPerformed(ActionEvent ev) {
		try {
			// test if the Tableable object can be created
			reserveList.createTableable(getUserInputArray());
			
			// ask for confirmation
			int response = JOptionPane.showConfirmDialog(null, "Do you wish to create this Componenet?", "Confirm?", JOptionPane.YES_NO_CANCEL_OPTION);
			if (response == 0)
			{
				// create the object
				reserveList.createAndAddNewInstance(getUserInputArray());
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
		String stringName 				= txtName.getText();
		String stringXPos 				= txtXPos.getText();
		String stringYPos 				= txtYPos.getText();
		String stringMinPopulation 		= txtMin.getText();
		String stringMaxPopulation 		= txtMax.getText();
		String stringCurrentPopulation 	= txtCur.getText();
		String stringRegenerationRate 	= txtReg.getText();
		
		return new String[]{
				"",
				stringName,
				stringXPos,
				stringYPos,
				stringMinPopulation,
				stringMaxPopulation,
				stringCurrentPopulation,
				stringRegenerationRate};
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		vSpacer6 = new JPanel(null);
		label1 = new JLabel();
		hSpacer1 = new JPanel(null);
		label2 = new JLabel();
		txtName = new JTextField();
		vSpacer1 = new JPanel(null);
		label3 = new JLabel();
		txtXPos = new JTextField();
		vSpacer2 = new JPanel(null);
		label4 = new JLabel();
		txtYPos = new JTextField();
		hSpacer2 = new JPanel(null);
		vSpacer3 = new JPanel(null);
		label8 = new JLabel();
		txtMin = new JTextField();
		vSpacer4 = new JPanel(null);
		label5 = new JLabel();
		txtMax = new JTextField();
		vSpacer5 = new JPanel(null);
		label6 = new JLabel();
		txtCur = new JTextField();
		vSpacer9 = new JPanel(null);
		label7 = new JLabel();
		txtReg = new JTextField();
		vSpacer7 = new JPanel(null);
		btnCreateReserve = new JButton();
		vSpacer8 = new JPanel(null);

		//======== this ========
		setBorder(new TitledBorder("Reserve"));
		setLayout(new GridBagLayout());
		((GridBagLayout)getLayout()).columnWidths = new int[] {0, 65, 145, 0, 0};
		((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
		((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
		add(vSpacer6, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label1 ----
		label1.setText("Reserve Entry Panel");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(label1, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(hSpacer1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label2 ----
		label2.setText("name");
		add(label2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(txtName, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(vSpacer1, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label3 ----
		label3.setText("x - position");
		add(label3, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(txtXPos, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(vSpacer2, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label4 ----
		label4.setText("y - position");
		add(label4, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(txtYPos, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(hSpacer2, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 0), 0, 0));
		add(vSpacer3, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label8 ----
		label8.setText("minimum population");
		add(label8, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(txtMin, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(vSpacer4, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label5 ----
		label5.setText("maximum population");
		add(label5, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(txtMax, new GridBagConstraints(2, 10, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(vSpacer5, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label6 ----
		label6.setText("current population");
		add(label6, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(txtCur, new GridBagConstraints(2, 12, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(vSpacer9, new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- label7 ----
		label7.setText("regeneration rate");
		add(label7, new GridBagConstraints(1, 14, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(txtReg, new GridBagConstraints(2, 14, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(vSpacer7, new GridBagConstraints(1, 15, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- btnCreateReserve ----
		btnCreateReserve.setText("Create Reserve");
		btnCreateReserve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCreateReserveActionPerformed(e);
			}
		});
		add(btnCreateReserve, new GridBagConstraints(2, 16, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		add(vSpacer8, new GridBagConstraints(2, 17, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 5), 0, 0));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JPanel vSpacer6;
	private JLabel label1;
	private JPanel hSpacer1;
	private JLabel label2;
	private JTextField txtName;
	private JPanel vSpacer1;
	private JLabel label3;
	private JTextField txtXPos;
	private JPanel vSpacer2;
	private JLabel label4;
	private JTextField txtYPos;
	private JPanel hSpacer2;
	private JPanel vSpacer3;
	private JLabel label8;
	private JTextField txtMin;
	private JPanel vSpacer4;
	private JLabel label5;
	private JTextField txtMax;
	private JPanel vSpacer5;
	private JLabel label6;
	private JTextField txtCur;
	private JPanel vSpacer9;
	private JLabel label7;
	private JTextField txtReg;
	private JPanel vSpacer7;
	private JButton btnCreateReserve;
	private JPanel vSpacer8;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	
	

}
