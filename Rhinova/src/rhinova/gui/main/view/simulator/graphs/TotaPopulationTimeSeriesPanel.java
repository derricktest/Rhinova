package rhinova.gui.main.view.simulator.graphs;

import java.awt.Color;
import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import rhinova.metapopulation.model.graphicx.movie.NextSlideMovieEvent;
import rhinova.metapopulation.model.simulate.SimulationEvent;



public class TotaPopulationTimeSeriesPanel extends SimulatedResultsChartPanel implements ApplicationListener<ApplicationEvent>  {

	private static final long serialVersionUID = 1L;


	/**
	 * Keep a reference to the plot to change the data
	 */
	XYPlot plot;

	public void setData(XYDataset dataset) {
		this.plot.setDataset(dataset);
	}

	public TotaPopulationTimeSeriesPanel() {

		XYSeriesCollection dataset = new XYSeriesCollection();

		//final ChartPanel chartPanel = 

		// JFree chart
		JFreeChart chart = ChartFactory.createXYLineChart(
				"Time Series of Total Population", // chart title
				"Slide", // x axis label
				"Population", // y axis label
				dataset, // data
				PlotOrientation.VERTICAL,
				true, // include legend
				true, // tooltips
				false // urls
				);

		// set the background color for the chart...
		chart.setBackgroundPaint(Color.white);




		// plot
		plot = (XYPlot) chart.getPlot();


		plot.getDomainAxis();//.setT


		// DOMAIN AXIS 2
		DecimalFormat myFormatter = new DecimalFormat("###.");
		NumberTickUnit tick = new NumberTickUnit(1,  myFormatter, 4);

		// axis
		NumberAxis xAxis2 = new NumberAxis("Domain Axis 2");
		xAxis2.setAutoRangeIncludesZero(false);
		xAxis2.setTickUnit(tick);
		plot.setDomainAxis(1, xAxis2);
		plot.setDomainAxisLocation(1, AxisLocation.BOTTOM_OR_LEFT);

		ChartPanel chartPanel = new ChartPanel(chart);
		//chartPanel.setSize(200, 200);
		this.add(chartPanel);
	}

	Marker prevousMarker = null;

	@Override
	public void onApplicationEvent(ApplicationEvent ev) {

		if (ev instanceof SimulationEvent) {
			SimulationEvent event = (SimulationEvent) ev;
			this.setData(event.getResuts().getTotalPopulationTimeSeries());
			
		} else if(ev instanceof NextSlideMovieEvent) {
			NextSlideMovieEvent event = (NextSlideMovieEvent) ev;
			int index = event.getMovieIndex();
			Marker marker = new ValueMarker(index);
			plot.addDomainMarker(marker);
			if (prevousMarker != null) {
				plot.removeDomainMarker(prevousMarker);
			}
			prevousMarker = marker;
		}
	}

	@Override
	public String toString() {
		return "Total Population Timeseris";
	}

}
