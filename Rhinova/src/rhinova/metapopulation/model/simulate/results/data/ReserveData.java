package rhinova.metapopulation.model.simulate.results.data;

import lombok.Data;
import rhinova.framework.drawable.Circleable;
import rhinova.metapopulation.model.components.reserve.Reserve;

@Data
public class ReserveData implements Circleable {
	
	final int id;
	final String name;
	final double xPos;
	final double yPos;
	final double maxPopulation;
	final double minPopulation;
	final double currentPopulation;
	final double regenerationRate;
	final double intit;
	
	public ReserveData(Reserve reserve) {
		this.id = reserve.getId();
		this.name = reserve.getName();
		this.xPos = reserve.getXPos();
		this.yPos = reserve.getYPos();
		this.maxPopulation = reserve.getMaxPopulation();
		this.minPopulation = reserve.getMinPopulation();
		this.currentPopulation = reserve.getCurrentPopulation();
		this.regenerationRate = reserve.getRegenerationRate();
		this.intit = reserve.getInitialPopulation();
	}


	@Override
	public double getX()    {		return this.getXPos();	}
	@Override
	public double getY()    {		return this.getYPos();	}
	@Override
	public double getMinR() {		return Math.sqrt(this.getMinPopulation() /Math.PI);	}
	@Override
	public double getCurR() {		return Math.sqrt(this.getCurrentPopulation()/Math.PI);	}
	@Override
	public double getMaxR() {		return Math.sqrt(this.getMaxPopulation()/Math.PI);	}
	@Override
	public double getG()    {		return Math.sqrt(this.getRegenerationRate());	}
	@Override
	public String getCircleName() {		return this.getId()+" - "+this.name;}
}