package rhinova.gui.main.view;

import javax.swing.JTabbedPane;

import rhinova.gui.main.view.movie.properties.MoviePanel;
import rhinova.gui.main.view.simulator.properties.SimulatorPanel;
import rhinova.gui.main.view.solver.properties.SolverPanel;

public class GUITabbedPannel extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	public GUITabbedPannel(
			SolverPanel solverFrame,
			SimulatorPanel simulatorPanel,
			MoviePanel moviePanel){
		
		if (solverFrame!=null) {
			this.add(solverFrame, "Solver");
		}
		if (simulatorPanel!=null) {
			this.add(simulatorPanel, "Simulation");
		}
		if (moviePanel!=null) {
			this.add(moviePanel, "Movie");
		}
		
	}

}
