package rhinova.gui.main.view.simulator;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.springframework.context.ApplicationListener;

import rhinova.gui.main.view.controller.GISViewController;
import rhinova.gui.main.view.simulator.graphs.GraphTabbedPane;
import rhinova.gui.main.view.simulator.movie.SimulatorMoviePanel;
import rhinova.metapopulation.model.graphicx.ComposedEvent;

public class SimulatorResultsFrame extends JFrame implements ApplicationListener<ComposedEvent>{


	private static final long serialVersionUID = 1L;
	
	/** List of all the graphs */
	GraphTabbedPane graphTabbedPane;

	
	/** The Panel which displays the simulated movie */
	SimulatorMoviePanel simulatorPanel;
	
	/** The buttons for controlling the movie */
	GISViewController gisViewController;
	
	
	public SimulatorResultsFrame(
			GraphTabbedPane graphTabbedPane,
			SimulatorMoviePanel simulatorPanel,
			GISViewController gisViewController	)
					
					throws HeadlessException {
		super();
		
		this.graphTabbedPane = graphTabbedPane;
		
		this.simulatorPanel = simulatorPanel;
		this.gisViewController = gisViewController;
		
		initComponents();
	}

	private void initComponents() {

		// frame
		this.setLayout(new BorderLayout());
		this.setSize(500,500);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		// centre panel
		JPanel centre = new JPanel();
		centre.setLayout(new BorderLayout());
		centre.add(simulatorPanel, BorderLayout.CENTER);
		centre.add(gisViewController, BorderLayout.SOUTH);
		centre.setSize(400,400);
		
		//main JScrollpane
		JSplitPane main = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT,
				centre,
				new JScrollPane(graphTabbedPane));
		
		
		this.add(main);
	}

	@Override
	public void onApplicationEvent(ComposedEvent arg0) {
		this.setVisible(true);
	}


}
