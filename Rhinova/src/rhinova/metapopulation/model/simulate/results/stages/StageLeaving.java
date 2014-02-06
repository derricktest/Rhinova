package rhinova.metapopulation.model.simulate.results.stages;

import java.util.List;

import rhinova.metapopulation.model.components.reserve.ReserveList;
import rhinova.metapopulation.model.optimise.results.OptimisedResultLink;


public class StageLeaving extends StageHarvest {

	public StageLeaving(ReserveList reserveList, List<OptimisedResultLink> results) {
		super(reserveList, results);
	}
}
