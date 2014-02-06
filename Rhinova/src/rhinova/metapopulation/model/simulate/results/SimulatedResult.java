package rhinova.metapopulation.model.simulate.results;

import java.util.List;

import rhinova.metapopulation.model.components.reserve.ReserveList;
import rhinova.metapopulation.model.optimise.results.OptimisedResultLink;
import rhinova.metapopulation.model.simulate.results.data.LinkDataList;
import rhinova.metapopulation.model.simulate.results.stages.StageArriving;
import rhinova.metapopulation.model.simulate.results.stages.StageLeaving;
import rhinova.metapopulation.model.simulate.results.stages.StageLink;
import rhinova.metapopulation.model.simulate.results.stages.StageRegeneration;
import rhinova.metapopulation.model.simulate.results.stages.StageStart;


public class SimulatedResult {
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public StageStart getStageStart() {
		return stageStart;
	}


	public void setStageStart(StageStart stageStart) {
		this.stageStart = stageStart;
	}


	public StageLeaving getStageLeaving() {
		return stageLeaving;
	}


	public void setStageLeaving(StageLeaving stageLeaving) {
		this.stageLeaving = stageLeaving;
	}


	public StageArriving getStageArriving() {
		return stageArriving;
	}


	public void setStageArriving(StageArriving stageArriving) {
		this.stageArriving = stageArriving;
	}


	public StageRegeneration getStageRegeneration() {
		return stageRegeneration;
	}


	public void setStageRegeneration(StageRegeneration stageRegeneration) {
		this.stageRegeneration = stageRegeneration;
	}


	public StageLink getStageLink() {
		return stageLink;
	}


	public void setStageLink(StageLink stageLink) {
		this.stageLink = stageLink;
	}


	public LinkDataList getLinkData() {
		return linkData;
	}


	public void setLinkData(LinkDataList linkData) {
		this.linkData = linkData;
	}


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
