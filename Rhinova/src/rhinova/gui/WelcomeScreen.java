/*
 * Created by JFormDesigner on Thu Jan 09 23:23:20 FET 2014
 */

package rhinova.gui;

import java.awt.*;
import javax.swing.*;

/**
 * @author derrick futschik
 */
public class WelcomeScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WelcomeScreen() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		label1 = new JLabel();
		label2 = new JLabel();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- label1 ----
		label1.setText("Welcome to Rhinova!");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(label1);
		label1.setBounds(70, 75, 235, 55);

		//---- label2 ----
		label2.setText("written by Derrick Futschik 2014 - s3236434@student.rmit.edu.au");
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(30, 135), label2.getPreferredSize()));

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JLabel label1;
	private JLabel label2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
