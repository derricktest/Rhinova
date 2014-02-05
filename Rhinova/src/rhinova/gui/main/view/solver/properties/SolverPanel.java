/*
 * Created by JFormDesigner on Sat Dec 21 00:05:32 FET 2013
 */

package rhinova.gui.main.view.solver.properties;

import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import java.awt.*;

import javax.swing.*;

import rhinova.metapopulation.model.optimise.*;

/**
 * @author derrick futschik
 */
public class SolverPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SolverPanel(Optimiser optimiser1) {
		this.optimiser1 = optimiser1;
		initComponents();
	}

	private void createUIComponents() {
		// TODO: add custom component creation code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		createUIComponents();

		label8 = new JLabel();
		spinnerNumberOfYears = new JSpinner();
		label2 = new JLabel();
		txtOutputPath = new JTextField();
		label3 = new JLabel();
		chkOverPopulation = new JCheckBox();
		label4 = new JLabel();
		chkLinkCapacity = new JCheckBox();
		label5 = new JLabel();
		chkMaximumPopulation = new JCheckBox();
		label6 = new JLabel();
		chkMinimum = new JCheckBox();
		label7 = new JLabel();
		chkSurvivalRate = new JCheckBox();
		label9 = new JLabel();
		txtTolerance = new JTextField();

		//======== this ========
		setLayout(new GridBagLayout());
		((GridBagLayout)getLayout()).columnWidths = new int[] {0, 132, 0};
		((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 0.0, 1.0E-4};
		((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

		//---- label8 ----
		label8.setText("Number of Years");
		add(label8, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(spinnerNumberOfYears, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label2 ----
		label2.setText("Output Path");
		add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));

		//---- txtOutputPath ----
		txtOutputPath.setEnabled(false);
		add(txtOutputPath, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label3 ----
		label3.setText("Allow Overpopulation Deaths");
		add(label3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(chkOverPopulation, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label4 ----
		label4.setText("Inforce Link Capacities");
		add(label4, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(chkLinkCapacity, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label5 ----
		label5.setText("Inforce Maximum Population");
		add(label5, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(chkMaximumPopulation, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label6 ----
		label6.setText("Inforce Minimum Population");
		add(label6, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(chkMinimum, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label7 ----
		label7.setText("Inforce Link Survivalrate");
		add(label7, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(chkSurvivalRate, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label9 ----
		label9.setText("Tolerance");
		add(label9, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(txtTolerance, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- bindings ----
		bindingGroup = new BindingGroup();
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			optimiser1, BeanProperty.create("numberOfYears"),
			spinnerNumberOfYears, BeanProperty.create("value")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			optimiser1, BeanProperty.create("solutionPath"),
			txtOutputPath, BeanProperty.create("text")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			optimiser1, BeanProperty.create("allowOverpopulationDeaths"),
			chkOverPopulation, BeanProperty.create("selected")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			optimiser1, BeanProperty.create("inforceLinkCapacity"),
			chkLinkCapacity, BeanProperty.create("selected")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			optimiser1, BeanProperty.create("inforceMaxPopulation"),
			chkMaximumPopulation, BeanProperty.create("selected")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			optimiser1, BeanProperty.create("inforceMinPopulationConstraint"),
			chkMinimum, BeanProperty.create("selected")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			optimiser1, BeanProperty.create("inforceLinkSurvivalRates"),
			chkSurvivalRate, BeanProperty.create("selected")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			optimiser1, BeanProperty.create("tolerance"),
			txtTolerance, BeanProperty.create("text")));
		bindingGroup.bind();
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JLabel label8;
	private JSpinner spinnerNumberOfYears;
	private JLabel label2;
	private JTextField txtOutputPath;
	private JLabel label3;
	private JCheckBox chkOverPopulation;
	private JLabel label4;
	private JCheckBox chkLinkCapacity;
	private JLabel label5;
	private JCheckBox chkMaximumPopulation;
	private JLabel label6;
	private JCheckBox chkMinimum;
	private JLabel label7;
	private JCheckBox chkSurvivalRate;
	private JLabel label9;
	private JTextField txtTolerance;
	private Optimiser optimiser1;
	private BindingGroup bindingGroup;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
