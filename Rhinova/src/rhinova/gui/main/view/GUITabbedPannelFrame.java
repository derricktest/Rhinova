package rhinova.gui.main.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import rhinova.metapopulation.model.optimise.OptimiseEvent;

public class GUITabbedPannelFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	ApplicationEventPublisher publisher;

	GUITabbedPannelFrame(
			GUITabbedPannel tabbedPannel) {
		
		
		super("Configuration");
		this.setLayout(new BorderLayout());
		this.add(tabbedPannel,BorderLayout.CENTER);
		
		// Button to start the model action
		JButton btnStart = new JButton("Start Process");
		btnStart.setBackground(Color.green);
		this.add(btnStart, BorderLayout.PAGE_END);
		btnStart.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				publisher.publishEvent(new OptimiseEvent(this));
			}
		} );
		
		
		
		this.setSize(500,500);
		this.setLocation(200,200);
		
	}

}
