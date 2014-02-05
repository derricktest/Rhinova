package rhinova.metapopulation.model.simulate.results.stages;

import rhinova.metapopulation.model.components.reserve.ReserveList;
import rhinova.metapopulation.model.simulate.results.data.ReserveDataList;

public class StageStart extends StagePopulation {

	public StageStart(ReserveDataList reservesList) {
		super(reservesList);
	}

	public StageStart(ReserveList reservesList) {
		super(reservesList);
	}
	
}
