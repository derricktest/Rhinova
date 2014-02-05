/*
 * Created by JFormDesigner on Fri Dec 13 15:57:17 FET 2013
 */

package rhinova.gui.main.view.simulator.properties;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;

import javax.annotation.PostConstruct;
import javax.swing.*;

import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import rhinova.metapopulation.model.optimise.Optimiser;
import rhinova.metapopulation.model.simulate.*;

/**
 * @author derrick futschik
 */
public class SimulatorPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public SimulatorPanel(Simulator simulator1, Optimiser optimiser1) {
		this.simulator1 = simulator1;
		this.optimiser1 = optimiser1;
		initComponents();
		

		
	}
	
	@PostConstruct
	public void defaultOpenState() {
		// set the form to the default state
		this.chkEnforceSolvingOptions.doClick();
	}

	private void txtSolutionPathMouseClicked(MouseEvent e) {
		// TODO add file chooser here
	}

	private void createUIComponents() {
	}
	
	
	private void addjustSettings() {
		if (this.chkEnforceSolvingOptions.isSelected()) {
			
			this.spinnerYears.setValue(this.optimiser1.getNumberOfYears());
			this.spinnerYears.setEnabled(false);

			this.chkAllowDeaths.setSelected(this.optimiser1.isAllowOverpopulationDeaths());
			this.chkAllowDeaths.setEnabled(false);
			
			this.chkInforceLinkCapacity.setSelected(this.optimiser1.isInforceLinkCapacity());
			this.chkInforceLinkCapacity.setEnabled(false);
			
			this.chkInforcePopulation.setSelected(this.optimiser1.isInforceMaxPopulation());
			this.chkInforcePopulation.setEnabled(false);
			
			this.chkInforceMinimumPopulation.setSelected(this.optimiser1.isInforceMinPopulationConstraint());
			this.chkInforceMinimumPopulation.setEnabled(false);
			
			this.chkInforceSurvivalRate.setSelected(this.optimiser1.isInforceLinkSurvivalRates());
			this.chkInforceSurvivalRate.setEnabled(false);
			
		} else {
			this.spinnerYears.setEnabled(true);
			this.chkAllowDeaths.setEnabled(true);
			this.chkInforceLinkCapacity.setEnabled(true);
			this.chkInforcePopulation.setEnabled(true);
			this.chkInforceMinimumPopulation.setEnabled(true);
			this.chkInforceSurvivalRate.setEnabled(true);
		}
	}

	private void chkEnforceSolvingOptionsActionPerformed(ActionEvent e) {
		this.addjustSettings();
	}

	
	/**
	 * Adjust the settings of the form whenever the setting on the optimiser form changes
	 * @param e
	 */
	private void optimiser1PropertyChange(PropertyChangeEvent e) {
		this.addjustSettings();
	}
	
	
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		createUIComponents();

		label8 = new JLabel();
		chkEnforceSolvingOptions = new JCheckBox();
		label1 = new JLabel();
		spinnerYears = new JSpinner();
		label2 = new JLabel();
		txtSolutionPath = new JTextField();
		label3 = new JLabel();
		chkAllowDeaths = new JCheckBox();
		label4 = new JLabel();
		chkInforceLinkCapacity = new JCheckBox();
		label5 = new JLabel();
		chkInforcePopulation = new JCheckBox();
		label6 = new JLabel();
		chkInforceMinimumPopulation = new JCheckBox();
		label7 = new JLabel();
		chkInforceSurvivalRate = new JCheckBox();

		//======== this ========
		setLayout(new GridBagLayout());
		((GridBagLayout)getLayout()).columnWidths = new int[] {228, 0, 0};
		((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
		((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
		((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

		//---- label8 ----
		label8.setText("Enforce Optimisation Values");
		add(label8, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));

		//---- chkEnforceSolvingOptions ----
		chkEnforceSolvingOptions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chkEnforceSolvingOptionsActionPerformed(e);
			}
		});
		add(chkEnforceSolvingOptions, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label1 ----
		label1.setText("Number of years to simulate");
		add(label1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(spinnerYears, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label2 ----
		label2.setText("Output path");
		add(label2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));

		//---- txtSolutionPath ----
		txtSolutionPath.setEnabled(false);
		txtSolutionPath.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSolutionPathMouseClicked(e);
			}
		});
		add(txtSolutionPath, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label3 ----
		label3.setText("Allow Overpopulation Deaths");
		add(label3, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(chkAllowDeaths, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label4 ----
		label4.setText("Inforce Link Capacities");
		add(label4, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));

		//---- chkInforceLinkCapacity ----
		chkInforceLinkCapacity.setSelected(true);
		add(chkInforceLinkCapacity, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label5 ----
		label5.setText("Inforce Maximum Population");
		add(label5, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));

		//---- chkInforcePopulation ----
		chkInforcePopulation.setSelected(true);
		add(chkInforcePopulation, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label6 ----
		label6.setText("Inforce Minimum Population");
		add(label6, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));

		//---- chkInforceMinimumPopulation ----
		chkInforceMinimumPopulation.setSelected(true);
		add(chkInforceMinimumPopulation, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label7 ----
		label7.setText("Inforce Link Survivalrate");
		add(label7, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 25), 0, 0));

		//---- chkInforceSurvivalRate ----
		chkInforceSurvivalRate.setSelected(true);
		add(chkInforceSurvivalRate, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));

		//---- optimiser1 ----
		optimiser1.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				optimiser1PropertyChange(e);
			}
		});

		//---- bindings ----
		bindingGroup = new BindingGroup();
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			simulator1, BeanProperty.create("numberOfYears"),
			spinnerYears, BeanProperty.create("value")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			simulator1, BeanProperty.create("solutionPath"),
			txtSolutionPath, BeanProperty.create("text")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			simulator1, BeanProperty.create("allowOverpopulationDeaths"),
			chkAllowDeaths, BeanProperty.create("selected")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			simulator1, BeanProperty.create("inforceLinkCapacity"),
			chkInforceLinkCapacity, BeanProperty.create("selected")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			simulator1, BeanProperty.create("inforceMaxPopulation"),
			chkInforcePopulation, BeanProperty.create("selected")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			simulator1, BeanProperty.create("inforceMinPopulationConstraint"),
			chkInforceMinimumPopulation, BeanProperty.create("selected")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			simulator1, BeanProperty.create("inforceLinkSurvivalRates"),
			chkInforceSurvivalRate, BeanProperty.create("selected")));
		bindingGroup.bind();
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JLabel label8;
	private JCheckBox chkEnforceSolvingOptions;
	private JLabel label1;
	private JSpinner spinnerYears;
	private JLabel label2;
	private JTextField txtSolutionPath;
	private JLabel label3;
	private JCheckBox chkAllowDeaths;
	private JLabel label4;
	private JCheckBox chkInforceLinkCapacity;
	private JLabel label5;
	private JCheckBox chkInforcePopulation;
	private JLabel label6;
	private JCheckBox chkInforceMinimumPopulation;
	private JLabel label7;
	private JCheckBox chkInforceSurvivalRate;
	private Simulator simulator1;
	private Optimiser optimiser1;
	private BindingGroup bindingGroup;
	// JFormDesigner - End of variables declaration  //GEN-END:variables


}
