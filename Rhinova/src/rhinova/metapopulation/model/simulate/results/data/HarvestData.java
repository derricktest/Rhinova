package rhinova.metapopulation.model.simulate.results.data;

import java.io.Serializable;

import rhinova.framework.drawable.Lineable;
import rhinova.metapopulation.model.optimise.results.OptimisedResultLink;

public class HarvestData implements Serializable, Lineable  {
	

	public OptimisedResultLink getOptimisedResultLink() {
		return optimisedResultLink;
	}

	public void setOptimisedResultLink(OptimisedResultLink optimisedResultLink) {
		this.optimisedResultLink = optimisedResultLink;
	}
	private static final long serialVersionUID = 1L;
	
	OptimisedResultLink optimisedResultLink;
	
	public HarvestData(OptimisedResultLink optimisedResultLink) {
		this.optimisedResultLink = optimisedResultLink;
	}

	@Override
	public double getX1() 			{		return this.getOptimisedResultLink().getResFrom().getX(); }
	@Override
	public double getY1() 			{		return this.getOptimisedResultLink().getResFrom().getY();	}
	@Override
	public double getX2() 			{		return this.getOptimisedResultLink().getResTo().getX();	}
	@Override
	public double getY2() 			{		return this.getOptimisedResultLink().getResTo().getY(); }
	@Override
	public double getColor() 		{		return this.getOptimisedResultLink().getLinkData().getSurvivalRate();		}
	@Override
	public double getThickness() 	{		return this.getOptimisedResultLink().getValue();			}
	
}