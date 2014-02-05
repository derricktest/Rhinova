package rhinova.gui.main.view.simulator.graphs;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import rhinova.metapopulation.model.graphicx.movie.Movie;

public class PopulationPieChart extends SimulatedResultsChartPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	PiePlot3D plot;
	
	
	Movie movie;

	public PopulationPieChart(Movie movie) {
		
		// add the movie and property change support
		this.movie = movie;
		
		movie.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				moviePropertyChange(e);
			}
		});
		
		PieDataset dataset = new DefaultPieDataset();
		
		JFreeChart chart = ChartFactory.createPieChart3D(
				"Pie Chart 3D Demo 3",  // chart title
				dataset,                // data
				true,                   // include legend
				true,
				false);

		plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		//plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		plot.setNoDataMessage("No data to display");
		//plot.setLabelGenerator(new CustomLabelGenerator());
		
		ChartPanel chartPanel = new ChartPanel(chart);
		//chartPanel.setSize(200, 200);
		this.add(chartPanel);
	}
	
	
	private void moviePropertyChange(PropertyChangeEvent e) {
		if (this.movie.getNoPictures()!=0) {
			this.plot.setDataset(this.movie.getCurrentPicture().getCircles().getPieDataSet());
		}
		
	}
	

    
	public void setData(PieDataset dataset) {
		this.plot.setDataset(dataset);
	}


	@Override
	public String toString() {
		return "Populations Pie Chart";
	}
    
    
}

