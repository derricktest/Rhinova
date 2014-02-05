/*
 * Created by JFormDesigner on Tue Jan 07 22:14:16 FET 2014
 */

package rhinova.gui.dataentry.reserve.edit;

import java.awt.*;

import javax.swing.*;

import rhinova.gui.dataentry.dataedit.PropertiesView;

/**
 * @author derrick futschik
 */
public class ReserveDataEditPanel extends PropertiesView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ReserveDataEditPanel() {
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
		label4 = new JLabel();
		txtXPosition = new JTextField();
		label5 = new JLabel();
		txtYPosition = new JTextField();
		label6 = new JLabel();
		txtMinimumPopulation = new JTextField();
		label7 = new JLabel();
		txtMaximumPopulation = new JTextField();
		label8 = new JLabel();
		txtCurrentPopulation = new JTextField();
		label9 = new JLabel();
		txtRegeneration = new JTextField();

		//======== this ========
		setLayout(new GridBagLayout());
		((GridBagLayout)getLayout()).columnWidths = new int[] {55, 0, 0};
		((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
		((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

		//---- label1 ----
		label1.setText("Reserve Edit Panel");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(label1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label2 ----
		label2.setText("id");
		add(label2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 15, 15), 0, 0));

		//---- lblId ----
		lblId.setText("text");
		add(lblId, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label3 ----
		label3.setText("name");
		add(label3, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 15, 15), 0, 0));
		add(txtName, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label4 ----
		label4.setText("x - position");
		add(label4, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 15, 15), 0, 0));
		add(txtXPosition, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label5 ----
		label5.setText("y - position");
		add(label5, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 15, 15), 0, 0));
		add(txtYPosition, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label6 ----
		label6.setText("minimum population");
		add(label6, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 15, 15), 0, 0));
		add(txtMinimumPopulation, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label7 ----
		label7.setText("maximum population");
		add(label7, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 15, 15), 0, 0));
		add(txtMaximumPopulation, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label8 ----
		label8.setText("current population");
		add(label8, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 15, 15), 0, 0));
		add(txtCurrentPopulation, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 15, 0), 0, 0));

		//---- label9 ----
		label9.setText("regeneration rate");
		add(label9, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 0, 15), 0, 0));
		add(txtRegeneration, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0,
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
	private JLabel label4;
	private JTextField txtXPosition;
	private JLabel label5;
	private JTextField txtYPosition;
	private JLabel label6;
	private JTextField txtMinimumPopulation;
	private JLabel label7;
	private JTextField txtMaximumPopulation;
	private JLabel label8;
	private JTextField txtCurrentPopulation;
	private JLabel label9;
	private JTextField txtRegeneration;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	@Override
	public String[] getPropeties() {
		return new String[]{
				lblId.getText(),
				txtName.getText(),
				txtXPosition.getText(),
				txtYPosition.getText(),
				txtMinimumPopulation.getText(),
				txtMaximumPopulation.getText(),
				txtCurrentPopulation.getText(),
				txtRegeneration.getText()};
	}

	@Override
	public void setProperties(String[] properties) {
		lblId.setText(properties[0]);
		txtName.setText(properties[1]);
		txtXPosition.setText(properties[2]);
		txtYPosition.setText(properties[3]);
		txtMinimumPopulation.setText(properties[4]);
		txtMaximumPopulation.setText(properties[5]);
		txtCurrentPopulation.setText(properties[6]);
		txtRegeneration.setText(properties[7]);
	}

	@Override
	public void clearView() {
		lblId.setText("");
		txtName.setText("");
		txtXPosition.setText("");
		txtYPosition.setText("");
		txtMinimumPopulation.setText("");
		txtMaximumPopulation.setText("");
		txtCurrentPopulation.setText("");
		txtRegeneration.setText("");
	}
}
