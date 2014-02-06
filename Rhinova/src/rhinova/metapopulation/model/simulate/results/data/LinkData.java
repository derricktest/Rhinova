package rhinova.metapopulation.model.simulate.results.data;

import java.io.Serializable;

import rhinova.framework.drawable.Lineable;
import rhinova.metapopulation.model.components.link.Link;


public class LinkData implements Serializable, Lineable {
	

	private static final long serialVersionUID = 1L;
	
	
	final int id;
	final String name;
	final double x1Pos;
	final double y1Pos;
	final double x2Pos;
	final double y2Pos;
	final double capacity;
	final double survivalRate;
	
	public LinkData(Link link) {
		this.id = link.getId();
		this.name = link.getName();
		this.x1Pos = link.getReserve1().getXPos();
		this.y1Pos = link.getReserve1().getYPos();
		this.x2Pos = link.getReserve2().getXPos();
		this.y2Pos = link.getReserve2().getYPos();
		this.capacity = link.getCapacity();
		this.survivalRate = link.getSurvivalRate();
	}

	@Override
	public double getX1() 			{		return this.x1Pos ;	}
	@Override
	public double getY1() 			{		return this.y1Pos;	}
	@Override
	public double getX2() 			{		return this.x2Pos;	}
	@Override
	public double getY2() 			{		return this.y2Pos;	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getX1Pos() {
		return x1Pos;
	}

	public double getY1Pos() {
		return y1Pos;
	}

	public double getX2Pos() {
		return x2Pos;
	}

	public double getY2Pos() {
		return y2Pos;
	}

	public double getCapacity() {
		return capacity;
	}

	public double getSurvivalRate() {
		return survivalRate;
	}
	@Override
	public double getColor() 		{		return this.getSurvivalRate();			}
	@Override
	public double getThickness() 	{		return this.getCapacity();				}
	
}