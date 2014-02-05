/*
 * Created by JFormDesigner on Fri Dec 13 16:07:04 FET 2013
 */

package rhinova.gui.main.view.movie.properties;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;

import javax.annotation.PostConstruct;
import javax.swing.*;

import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import rhinova.metapopulation.model.graphicx.*;
import rhinova.metapopulation.model.simulate.*;


/**
 * @author derrick futschik
 */
public class MoviePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public MoviePanel(Composer composer1, Simulator simulator1) {
		this.composer1 = composer1;
		this.simulator1 = simulator1;
		initComponents();
		
		
	}
	
	@PostConstruct
	public void defaultOpenState() {
		this.chkDefaultSettings.doClick();
	}

	private void createUIComponents() {
		// Revisit nothing to do
	}

	private void adjustSettings() {
		if (chkDefaultSettings.isSelected()) {
			
			// disable the settings to be set
			this.chkEnforceSimultorSettings.setEnabled(false);
			this.spinnerYears.setEnabled(false);
			this.spinnerWaitStart.setEnabled(false);
			this.spinnerWaitMigrating.setEnabled(false);
			this.spinnerNoMigratingPics.setEnabled(false);
			this.spinnerWaitMigratingSteps.setEnabled(false);
			this.spinnerWaitArriving.setEnabled(false);
			this.spinnerWaitRegenerating.setEnabled(false);
			
			// set the year to be the same as the simulator
			this.spinnerYears.setValue(this.simulator1.getNumberOfYears());
			
			// set the composer default properties
			this.composer1.setDefault();
			
			// set the value of the enforce simulator settings where applicable to true
			this.chkEnforceSimultorSettings.setSelected(true);
			
		} else {
			this.chkEnforceSimultorSettings.setEnabled(true);
			this.spinnerYears.setEnabled(true);
			this.spinnerWaitStart.setEnabled(true);
			this.spinnerWaitMigrating.setEnabled(true);
			this.spinnerNoMigratingPics.setEnabled(true);
			this.spinnerWaitMigratingSteps.setEnabled(true);
			this.spinnerWaitArriving.setEnabled(true);
			this.spinnerWaitRegenerating.setEnabled(true);
		}
		
		if (this.chkEnforceSimultorSettings.isSelected()) {
			this.spinnerYears.setEnabled(false);
			this.spinnerYears.setValue(this.simulator1.getNumberOfYears());
		} else {
			this.spinnerYears.setEnabled(true);
		}
	}
	
	
	private void simulator1PropertyChange(PropertyChangeEvent e) {
		adjustSettings();
	}

	private void chkDefaultSettingsActionPerformed(ActionEvent e) {
		adjustSettings();
	}

	private void chkEnforceSimultorSettingsActionPerformed(ActionEvent e) {
		adjustSettings();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		createUIComponents();

		label9 = new JLabel();
		chkDefaultSettings = new JCheckBox();
		label8 = new JLabel();
		chkEnforceSimultorSettings = new JCheckBox();
		label1 = new JLabel();
		spinnerYears = new JSpinner();
		label2 = new JLabel();
		spinnerWaitStart = new JSpinner();
		label3 = new JLabel();
		spinnerWaitMigrating = new JSpinner();
		label4 = new JLabel();
		spinnerNoMigratingPics = new JSpinner();
		label5 = new JLabel();
		spinnerWaitMigratingSteps = new JSpinner();
		label6 = new JLabel();
		spinnerWaitArriving = new JSpinner();
		label7 = new JLabel();
		spinnerWaitRegenerating = new JSpinner();

		//======== this ========
		setLayout(new GridBagLayout());
		((GridBagLayout)getLayout()).columnWidths = new int[] {312, 121, 0};
		((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 0.0, 1.0E-4};
		((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

		//---- label9 ----
		label9.setText("Use default settings");
		add(label9, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));

		//---- chkDefaultSettings ----
		chkDefaultSettings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chkDefaultSettingsActionPerformed(e);
			}
		});
		add(chkDefaultSettings, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label8 ----
		label8.setText("Enforce Simultor Settings where applicable");
		add(label8, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));

		//---- chkEnforceSimultorSettings ----
		chkEnforceSimultorSettings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chkEnforceSimultorSettingsActionPerformed(e);
			}
		});
		add(chkEnforceSimultorSettings, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label1 ----
		label1.setText("No of Years");
		add(label1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(spinnerYears, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label2 ----
		label2.setText("Wait Start - Leaving");
		add(label2, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(spinnerWaitStart, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label3 ----
		label3.setText("Wait Leaving - Migrating");
		add(label3, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(spinnerWaitMigrating, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label4 ----
		label4.setText("Number of Migrating Pictures");
		add(label4, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(spinnerNoMigratingPics, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label5 ----
		label5.setText("Wait Migrating Steps");
		add(label5, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(spinnerWaitMigratingSteps, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label6 ----
		label6.setText("Wait Migrating - Arriving");
		add(label6, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 25), 0, 0));
		add(spinnerWaitArriving, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 25, 0), 0, 0));

		//---- label7 ----
		label7.setText("Wait Arriving - Regenerating");
		add(label7, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 25), 0, 0));
		add(spinnerWaitRegenerating, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));

		//---- simulator1 ----
		simulator1.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				simulator1PropertyChange(e);
				simulator1PropertyChange(e);
			}
		});

		//---- bindings ----
		bindingGroup = new BindingGroup();
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			composer1, BeanProperty.create("waitStart"),
			spinnerWaitStart, BeanProperty.create("value")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			composer1, BeanProperty.create("waitLeaving"),
			spinnerWaitMigrating, BeanProperty.create("value")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			composer1, BeanProperty.create("numberOfYears"),
			spinnerYears, BeanProperty.create("value")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			composer1, BeanProperty.create("noMigratingPictures"),
			spinnerNoMigratingPics, BeanProperty.create("value")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			composer1, BeanProperty.create("waitMigrating"),
			spinnerWaitMigratingSteps, BeanProperty.create("value")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			composer1, BeanProperty.create("waitArriving"),
			spinnerWaitArriving, BeanProperty.create("value")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
			composer1, BeanProperty.create("waitRegeneration"),
			spinnerWaitRegenerating, BeanProperty.create("value")));
		bindingGroup.bind();
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JLabel label9;
	private JCheckBox chkDefaultSettings;
	private JLabel label8;
	private JCheckBox chkEnforceSimultorSettings;
	private JLabel label1;
	private JSpinner spinnerYears;
	private JLabel label2;
	private JSpinner spinnerWaitStart;
	private JLabel label3;
	private JSpinner spinnerWaitMigrating;
	private JLabel label4;
	private JSpinner spinnerNoMigratingPics;
	private JLabel label5;
	private JSpinner spinnerWaitMigratingSteps;
	private JLabel label6;
	private JSpinner spinnerWaitArriving;
	private JLabel label7;
	private JSpinner spinnerWaitRegenerating;
	private Composer composer1;
	private Simulator simulator1;
	private BindingGroup bindingGroup;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
