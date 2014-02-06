package rhinova.metapopulation.model.simulate.results.stages;


import rhinova.metapopulation.model.components.reserve.ReserveList;
import rhinova.metapopulation.model.simulate.results.data.ReserveData;
import rhinova.metapopulation.model.simulate.results.data.ReserveDataList;


public class StagePopulation {
	
	ReserveDataList reserveDataList;

	public ReserveDataList getReserveDataList() {
		return reserveDataList;
	}

	public void setReserveDataList(ReserveDataList reserveDataList) {
		this.reserveDataList = reserveDataList;
	}

	public StagePopulation(ReserveDataList reserveDataList) {
		this.reserveDataList = reserveDataList;
	}
	
	public StagePopulation(ReserveList reserveList) {
		this(new ReserveDataList(reserveList));
	}
	
	public double getPopoulation(int reserveID) {
		for (int i=0; i<reserveDataList.size(); i++) {
			ReserveData reserveData = reserveDataList.get(i);
			if (reserveData.getId() == reserveID) {
				return reserveData.getCurrentPopulation();
			}
		}
		return -100.0;
	}
}
