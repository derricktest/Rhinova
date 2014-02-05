package rhinova.gui.main.view.simulator.graphs;

import java.util.List;

import javax.swing.JTabbedPane;

public class GraphTabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	
	List<SimulatedResultsChartPanel> graphs;

	public GraphTabbedPane(List<SimulatedResultsChartPanel> graphs) {
		this.graphs = graphs;
		for (SimulatedResultsChartPanel graph : graphs) {
			this.add(graph.toString(),graph);
		}
	}

}
