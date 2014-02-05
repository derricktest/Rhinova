package rhinova.metapopulation.model.simulate.results.stages;

import java.util.List;

import rhinova.metapopulation.model.components.reserve.ReserveList;
import rhinova.metapopulation.model.optimise.results.OptimisedResultLink;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode(callSuper=false)
public class StageArriving extends StageHarvest {

	public StageArriving(ReserveList reserveDataList,
			List<OptimisedResultLink> harvestData) {
		super(reserveDataList, harvestData);
	}
}
