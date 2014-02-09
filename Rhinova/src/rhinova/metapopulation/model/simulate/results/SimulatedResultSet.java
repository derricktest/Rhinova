package rhinova.metapopulation.model.simulate.results;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import rhinova.framework.graph.Graphable;
import rhinova.metapopulation.model.simulate.results.data.HarvestData;
import rhinova.metapopulation.model.simulate.results.data.HarvestDataList;
import rhinova.metapopulation.model.simulate.results.data.ReserveData;
import rhinova.metapopulation.model.simulate.results.data.ReserveDataList;


public class SimulatedResultSet extends ArrayList<SimulatedResult> implements Graphable {

	private static final long serialVersionUID = 1L;
	private final String nameOfSimulation;

	public SimulatedResultSet(List<SimulatedResult> simulatedResultSet,
			String nameOfSimulation) {
		super();
		this.nameOfSimulation = nameOfSimulation;
		this.addAll(simulatedResultSet);
	}


	public String getNameOfSimulation(String name) {
		return this.nameOfSimulation;
	}

	public double getFinalPopulation() {
		return this.get(this.size()-1).getStageRegeneration().getReserveDataList().getPopulation();
	}

	public double getInitialPopulatino() {
		return this.get(0).getStageStart().getReserveDataList().getPopulation();
	}

	public double getCapacity() {
		return this.get(0).getStageStart().getReserveDataList().getCapacity();
	}



	@Override
	public XYSeriesCollection getPopulationsTimeSeries() {

		XYSeriesCollection xySeries = new XYSeriesCollection();
		ReserveDataList reserveDataList = this.get(0).getStageStart().getReserveDataList();
		for (int i=0; i<reserveDataList.size(); i++) {
			ReserveData reserveData = reserveDataList.get(i);
			xySeries.addSeries(this.getPopulationSeriesForReserve(reserveData.getId()));
		}
		return xySeries;
	}

	public XYSeriesCollection getTotalPopulationTimeSeries() {

		XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
		XYSeries xySeries = new XYSeries("Total Population");

		int j=0;
		for (int i=0; i<this.size(); i++) {
			SimulatedResult result = this.get(i);
			xySeries.add(j, result.getStageStart().getReserveDataList().getPopulation());
			j++;
			xySeries.add(j, result.getStageLeaving().getReserveDataList().getPopulation());
			j++;
			xySeries.add(j, result.getStageArriving().getReserveDataList().getPopulation());
			j++;
			xySeries.add(j, result.getStageRegeneration().getReserveDataList().getPopulation());
			j++;
		}
		xySeriesCollection.addSeries(xySeries);
		return xySeriesCollection;
	}



	/**
	 * Gets the time series for a particular reserve
	 * @param reserveID - id of reserve
	 * @return
	 */
	private XYSeries getPopulationSeriesForReserve(int reserveID) {
		XYSeries series = new XYSeries("res-"+reserveID);
		int j = 0;
		for (SimulatedResult result : this) {
			//SimulatedResult result = this.get(i);
			// start
			series.add(j, result.getStageStart().getPopoulation(reserveID));
			j++;
			// leaving
			series.add(j, result.getStageLeaving().getPopoulation(reserveID));
			j++;
			// arriving
			series.add(j, result.getStageArriving().getPopoulation(reserveID));
			j++;
			// regeneration
			series.add(j, result.getStageRegeneration().getPopoulation(reserveID));
			j++;
		}
		return series;
	}



	/**
	 * Method to a CategoryDataset for the harvest.
	 * @return
	 */
	public List<DefaultCategoryDataset> getHarvestsDataSet() {


		List<DefaultCategoryDataset> globalData = new ArrayList<DefaultCategoryDataset>(); 


		for (SimulatedResult result : this) {

			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			HarvestDataList harvestData = result.getStageLeaving().getHarvestDataList();
			for (HarvestData harv : harvestData) {
				int resFrom = harv.getOptimisedResultLink().getResFrom().getId();
				int resTo = harv.getOptimisedResultLink().getResTo().getId();
				double value = harv.getOptimisedResultLink().getValue();
				
				dataset.addValue(value, (Comparable<?>)value, resFrom + " -> " + resTo);
				
			}
			globalData.add(dataset);
		}
		return globalData;
	}





















	/**
	 * Record the reservedata, assumes that this is called sequentially so that the place
	 * does not need to be determined.
	 * @param map
	 * @param reserveDataList
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private void recordResult(Map<Integer, XYSeries> map, ReserveDataList reserveDataList) {
		for (int i=0; i<reserveDataList.size(); i++) {
			ReserveData reserveData = reserveDataList.get(i);
			XYSeries xySeries = map.get(reserveData.getId());//.add(x, y);
			int no = xySeries.getItemCount();
			xySeries.add(no, reserveData.getCurrentPopulation());
		}
	}


	/**
	 * Initializes the map of series
	 * @return
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private Map<Integer, XYSeries> initializeMapOfSeries() {
		Map<Integer, XYSeries> series = new HashMap<Integer, XYSeries>();
		ReserveDataList reserveDataList = this.get(0).getStageArriving().getReserveDataList();
		for (int i=0; i<reserveDataList.size(); i++) {
			ReserveData reserveData = reserveDataList.get(i);
			series.put(reserveData.getId(), new XYSeries(reserveData.getId()+"-"+reserveData.getName()));
		}
		return series;
	}

	/**
	 * Turn a map of XYSeries into a XYSeriesCollection
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private XYSeriesCollection getXYSeriesCollectionFromMap(Map<Integer, XYSeries> map) {
		XYSeriesCollection xyseriesCollection = new XYSeriesCollection();
		for (Entry<Integer, XYSeries> entry : map.entrySet()) {
			xyseriesCollection.addSeries(entry.getValue());
		}
		return xyseriesCollection;
	}



}
