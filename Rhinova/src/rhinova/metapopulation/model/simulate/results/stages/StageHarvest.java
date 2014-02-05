package rhinova.metapopulation.model.simulate.results.stages;


import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rhinova.metapopulation.model.components.reserve.ReserveList;
import rhinova.metapopulation.model.optimise.results.OptimisedResultLink;
import rhinova.metapopulation.model.simulate.results.data.HarvestDataList;
import rhinova.metapopulation.model.simulate.results.data.ReserveDataList;


@Data
@EqualsAndHashCode(callSuper=false)
public class StageHarvest extends StagePopulation {
	
	private HarvestDataList harvestDataList;

	public StageHarvest(ReserveDataList reserveDataList, HarvestDataList harvestData) {
		super(reserveDataList);
		this.harvestDataList = harvestData;
	}
	
	public StageHarvest(
			ReserveList reserveList,
			List<OptimisedResultLink> optimiseResults) {
		super(reserveList);
		this.harvestDataList = new HarvestDataList(optimiseResults);
		
	}
	

}
