package rhinova.metapopulation.model.optimise.results;

import java.io.Serializable;

import rhinova.metapopulation.model.components.link.Link;
import rhinova.metapopulation.model.simulate.results.data.LinkData;


public class OptimisedResultLink implements Comparable<OptimisedResultLink>, Serializable {

	
	public LinkData getLinkData() {
		return linkData;
	}

	public void setLinkData(LinkData linkData) {
		this.linkData = linkData;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getResFrom() {
		return resFrom;
	}

	public void setResFrom(int resFrom) {
		this.resFrom = resFrom;
	}

	public int getResTo() {
		return resTo;
	}

	public void setResTo(int resTo) {
		this.resTo = resTo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
