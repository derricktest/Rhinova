package rhinova.metapopulation.model.simulate.results;

import java.util.List;

import lombok.Data;
import rhinova.metapopulation.model.components.reserve.ReserveList;
import rhinova.metapopulation.model.optimise.results.OptimisedResultLink;
import rhinova.metapopulation.model.simulate.results.data.LinkDataList;
import rhinova.metapopulation.model.simulate.results.stages.StageArriving;
import rhinova.metapopulation.model.simulate.results.stages.StageLeaving;
import rhinova.metapopulation.model.simulate.results.stages.StageLink;
import rhinova.metapopulation.model.simulate.results.stages.StageRegeneration;
import rhinova.metapopulation.model.simulate.results.stages.StageStart;


@Data
public class SimulatedResult {
	
	private String name;
	private int year;
	
	private StageStart stageStart = null;
	private StageLeaving stageLeaving = null;
	private StageArriving stageArriving = null;
	private StageRegeneration stageRegeneration = null;
	private StageLink stageLink = null;
	
	private LinkDataList linkData = null;
	
	
	public SimulatedResult(String name, int year) {
		this.name = name;
		this.year = year;
	}
	
	
	public void newStart(ReserveList startingReserveData) {
		this.stageStart = new StageStart(startingReserveData);
	}
	
	public void newLeaving(
			ReserveList leavingReserveData,
			List<OptimisedResultLink> harvestData) {
		this.stageLeaving  = new StageLeaving(leavingReserveData, harvestData);
	}
	
	public void newArriving(ReserveList arrivingReserveData, List<OptimisedResultLink> harvestData) {
		this.stageArriving = new StageArriving(arrivingReserveData, harvestData);
	}
	
	public void newRegeneration(ReserveList regenerationReserveData) {
		this.stageRegeneration = new StageRegeneration(regenerationReserveData);
	}
	
	
	public SimulatedResult(
			String name,
			int year,
			// start
			ReserveList startingReserveData,
			// leaving
			ReserveList leavingReserveData,
			List<OptimisedResultLink> harvestData,
			// arriving
			ReserveList arrivingReserveData,
			// regenerating
			ReserveList regenerationReserveData
			)
	{
		this(name, year);
		newStart(startingReserveData);
		newLeaving(leavingReserveData, harvestData);
		newArriving(arrivingReserveData, harvestData);
		newRegeneration(regenerationReserveData);
	}

	
}
