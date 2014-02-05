package rhinova.metapopulation.model.optimise.results;

import java.io.Serializable;

import rhinova.metapopulation.model.components.link.Link;
import rhinova.metapopulation.model.simulate.results.data.LinkData;
import lombok.Data;

@Data
public class OptimisedResultLink implements Comparable<OptimisedResultLink>, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	LinkData linkData;
	double value = 0.0;
	int year;
	int resFrom, resTo;
	
	public OptimisedResultLink(Link link, double value, int year, int resFrom, int resTo) {
		super();
		this.linkData = new LinkData(link);
		this.year = year;
		this.resFrom = resFrom;
		this.resTo = resTo;
		
	}

	@Override
	public int compareTo(OptimisedResultLink arg0) {
		return arg0.getLinkData().getId()-this.getLinkData().getId();
	}
	
}
