/*
 * Created by JFormDesigner on Mon Dec 02 14:57:24 FET 2013
 */

package rhinova.gui.main.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import rhinova.gui.main.view.controller.Controllable;
import rhinova.metapopulation.model.graphicx.movie.*;

/**
 * @author derrick futschik
 */
public class GISViewController extends JPanel {

	
	@Autowired
	ApplicationEventPublisher publisher;
	
	private static final long serialVersionUID = 1L;
	
	Controllable controllable = null;
	
	public GISViewController(Movie movie) {
		this.abstractMovie1 = movie;
		initComponents();
	}

	private void btnSkipBackActionPerformed(ActionEvent e) {
		publisher.publishEvent(new ControllerEvent(this, ControllerAction.SKIPSTART));
	}

	private void btnBackActionPerformed(ActionEvent e) {
		publisher.publishEvent(new ControllerEvent(this, ControllerAction.STEPBACK));
	}

	private void btnPlayActionPerformed(ActionEvent e) {
		publisher.publishEvent(new ControllerEvent(this, ControllerAction.PLAY));
	}

	private void btnPauseActionPerformed(ActionEvent e) {
		publisher.publishEvent(new ControllerEvent(this, ControllerAction.PAUSE));
	}

	private void btnStopActionPerformed(ActionEvent e) {
		publisher.publishEvent(new ControllerEvent(this, ControllerAction.STOP));
	}

	private void btnForwardActionPerformed(ActionEvent e) {
		publisher.publishEvent(new ControllerEvent(this, ControllerAction.STEPFORWARD));
	}

	private void btnSkipForwardActionPerformed(ActionEvent e) {
		publisher.publishEvent(new ControllerEvent(this, ControllerAction.SKIPEND));
	}

	private void createUIComponents() {
		// TODO: add custom component creation code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		createUIComponents();

		panel2 = new JPanel();
		btnSkipBack = new JButton();
		btnBack = new JButton();
		btnPlay = new JButton();
		btnPause = new JButton();
		btnStop = new JButton();
		btnForward = new JButton();
		btnSkipForward = new JButton();
		panel1 = new JPanel();
		label3 = new JLabel();
		lblTime = new JLabel();
		label11 = new JLabel();
		lblFinalTime = new JLabel();
		label4 = new JLabel();
		lblStage = new JLabel();
		label13 = new JLabel();
		lblInitialPopulation = new JLabel();
		label5 = new JLabel();
		lblPopulation = new JLabel();
		label12 = new JLabel();
		lblFinalPopulation = new JLabel();
		label1 = new JLabel();
		lblSlide = new JLabel();
		label18 = new JLabel();
		lblCapacity = new JLabel();
		label2 = new JLabel();
		lblFinalSlide = new JLabel();

		//======== this ========
		setLayout(null);

		//======== panel2 ========
		{
			panel2.setLayout(null);

			//---- btnSkipBack ----
			btnSkipBack.setIcon(new ImageIcon(getClass().getResource("/resoursource/icon/skip_backward.png")));
			btnSkipBack.setBackground(Color.white);
			btnSkipBack.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnSkipBackActionPerformed(e);
				}
			});
			panel2.add(btnSkipBack);
			btnSkipBack.setBounds(5, 5, 58, btnSkipBack.getPreferredSize().height);

			//---- btnBack ----
			btnBack.setIcon(new ImageIcon(getClass().getResource("/resoursource/icon/back.png")));
			btnBack.setBackground(Color.white);
			btnBack.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnBackActionPerformed(e);
				}
			});
			panel2.add(btnBack);
			btnBack.setBounds(65, 5, 58, btnBack.getPreferredSize().height);

			//---- btnPlay ----
			btnPlay.setIcon(new ImageIcon(getClass().getResource("/resoursource/icon/play.png")));
			btnPlay.setBackground(Color.white);
			btnPlay.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnPlayActionPerformed(e);
				}
			});
			panel2.add(btnPlay);
			btnPlay.setBounds(125, 5, 58, btnPlay.getPreferredSize().height);

			//---- btnPause ----
			btnPause.setIcon(new ImageIcon(getClass().getResource("/resoursource/icon/pause.png")));
			btnPause.setBackground(Color.white);
			btnPause.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnPauseActionPerformed(e);
				}
			});
			panel2.add(btnPause);
			btnPause.setBounds(185, 5, 58, btnPause.getPreferredSize().height);

			//---- btnStop ----
			btnStop.setIcon(new ImageIcon(getClass().getResource("/resoursource/icon/stop.png")));
			btnStop.setBackground(Color.white);
			btnStop.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnStopActionPerformed(e);
				}
			});
			panel2.add(btnStop);
			btnStop.setBounds(245, 5, 58, btnStop.getPreferredSize().height);

			//---- btnForward ----
			btnForward.setIcon(new ImageIcon(getClass().getResource("/resoursource/icon/forward.png")));
			btnForward.setBackground(Color.white);
			btnForward.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnForwardActionPerformed(e);
				}
			});
			panel2.add(btnForward);
			btnForward.setBounds(305, 5, 58, btnForward.getPreferredSize().height);

			//---- btnSkipForward ----
			btnSkipForward.setIcon(new ImageIcon(getClass().getResource("/resoursource/icon/skip_forward.png")));
			btnSkipForward.setBackground(Color.white);
			btnSkipForward.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnSkipForwardActionPerformed(e);
				}
			});
			panel2.add(btnSkipForward);
			btnSkipForward.setBounds(365, 5, 58, btnSkipForward.getPreferredSize().height);
		}
		add(panel2);
		panel2.setBounds(5, 0, 470, 75);

		//======== panel1 ========
		{
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {82, 113, 92, 130, 0};
			((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
			((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
			((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

			//---- label3 ----
			label3.setText("Year:");
			panel1.add(label3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- lblTime ----
			lblTime.setText("0000000000");
			panel1.add(lblTime, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- label11 ----
			label11.setText("Final Time:");
			panel1.add(label11, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- lblFinalTime ----
			lblFinalTime.setText("0000000000");
			panel1.add(lblFinalTime, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label4 ----
			label4.setText("Stage:");
			panel1.add(label4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- lblStage ----
			lblStage.setText("0000000000");
			panel1.add(lblStage, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- label13 ----
			label13.setText("Initial Population:");
			panel1.add(label13, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- lblInitialPopulation ----
			lblInitialPopulation.setText("0000000000");
			panel1.add(lblInitialPopulation, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label5 ----
			label5.setText("Population:");
			panel1.add(label5, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- lblPopulation ----
			lblPopulation.setText("0000000000");
			panel1.add(lblPopulation, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- label12 ----
			label12.setText("Final Population:");
			panel1.add(label12, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- lblFinalPopulation ----
			lblFinalPopulation.setText("0000000000");
			panel1.add(lblFinalPopulation, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label1 ----
			label1.setText("Slide");
			panel1.add(label1, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- lblSlide ----
			lblSlide.setText("0.0");
			panel1.add(lblSlide, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- label18 ----
			label18.setText("Capacity:");
			panel1.add(label18, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- lblCapacity ----
			lblCapacity.setText("0000000000");
			panel1.add(lblCapacity, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label2 ----
			label2.setText("No Pictures");
			panel1.add(label2, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));

			//---- lblFinalSlide ----
			lblFinalSlide.setText("0.0");
			panel1.add(lblFinalSlide, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 0, 5), 0, 0));
		}
		add(panel1);
		panel1.setBounds(10, 75, 420, 105);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < getComponentCount(); i++) {
				Rectangle bounds = getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			setMinimumSize(preferredSize);
			setPreferredSize(preferredSize);
		}

		//---- bindings ----
		bindingGroup = new BindingGroup();
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ,
			abstractMovie1, BeanProperty.create("year"),
			lblTime, BeanProperty.create("text")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ,
			abstractMovie1, BeanProperty.create("stage"),
			lblStage, BeanProperty.create("text")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ,
			abstractMovie1, BeanProperty.create("population"),
			lblPopulation, BeanProperty.create("text")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ,
			abstractMovie1, BeanProperty.create("finalPopulation"),
			lblFinalTime, BeanProperty.create("text")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ,
			abstractMovie1, BeanProperty.create("initialPopulation"),
			lblInitialPopulation, BeanProperty.create("text")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ,
			abstractMovie1, BeanProperty.create("finalPopulation"),
			lblFinalPopulation, BeanProperty.create("text")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ,
			abstractMovie1, BeanProperty.create("capacity"),
			lblCapacity, BeanProperty.create("text")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ,
			abstractMovie1, BeanProperty.create("noPictures"),
			lblFinalSlide, BeanProperty.create("text")));
		bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ,
			abstractMovie1, BeanProperty.create("currentPictureIndex"),
			lblSlide, BeanProperty.create("text")));
		bindingGroup.bind();
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JPanel panel2;
	private JButton btnSkipBack;
	private JButton btnBack;
	private JButton btnPlay;
	private JButton btnPause;
	private JButton btnStop;
	private JButton btnForward;
	private JButton btnSkipForward;
	private JPanel panel1;
	private JLabel label3;
	private JLabel lblTime;
	private JLabel label11;
	private JLabel lblFinalTime;
	private JLabel label4;
	private JLabel lblStage;
	private JLabel label13;
	private JLabel lblInitialPopulation;
	private JLabel label5;
	private JLabel lblPopulation;
	private JLabel label12;
	private JLabel lblFinalPopulation;
	private JLabel label1;
	private JLabel lblSlide;
	private JLabel label18;
	private JLabel lblCapacity;
	private JLabel label2;
	private JLabel lblFinalSlide;
	private Movie abstractMovie1;
	private BindingGroup bindingGroup;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
