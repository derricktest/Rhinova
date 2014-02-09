package rhinova.gui.main.view.simulator.graphs;

import java.text.DecimalFormat;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import rhinova.metapopulation.model.graphicx.movie.NextSlideMovieEvent;
import rhinova.metapopulation.model.simulate.SimulationEvent;

public class HarvestGraph extends SimulatedResultsChartPanel implements ApplicationListener<ApplicationEvent> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	List<DefaultCategoryDataset> data;
	
	CategoryPlot plot;
	
	public HarvestGraph() {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
        JFreeChart chart = ChartFactory.createBarChart(
                "Harvests",  // chart title
                "No. of Population",                  // domain axis label
                "Migration Route",
                dataset,                     // data
                PlotOrientation.HORIZONTAL,  // orientation
                false,                        // include legend
                true,
                false);
        
        
        
        plot = (CategoryPlot) chart.getPlot();
        plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        plot.setRangePannable(true);
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemLabelAnchorOffset(9.0);
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelGenerator(
                new StandardCategoryItemLabelGenerator());
        renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator(
                "{0}, {1}) = {2} per 100,000", new DecimalFormat("0")));
        //renderer.setDrawBarOutline(true);
        //renderer.setBaseOutlinePaint(Color.white);
        //renderer.setBaseOutlineStroke(new BasicStroke(0.5f));

        CategoryAxis categoryAxis = plot.getDomainAxis();
        categoryAxis.setCategoryMargin(0.25);
        categoryAxis.setUpperMargin(0.02);
        categoryAxis.setLowerMargin(0.02);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setUpperMargin(0.10);
        ChartUtilities.applyCurrentTheme(chart);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        this.add(chartPanel);
	}

	@Override
	public String toString() {
		return "Harvest";
	}

	@Override
	public void onApplicationEvent(ApplicationEvent ev) {

		if (ev instanceof SimulationEvent) {
			data = ((SimulationEvent) ev).getResuts().getHarvestsDataSet();
		} else if(ev instanceof NextSlideMovieEvent) {
			plot.setDataset(data.get(((NextSlideMovieEvent) ev).getMovieYear()));
		}
	}
	
	

}
