package rhinova.metapopulation.model.simulate.results.data;

import java.io.Serializable;
import java.util.ArrayList;

import rhinova.framework.drawable.Circle;
import rhinova.framework.drawable.CircleList;
import rhinova.metapopulation.model.components.reserve.ReserveList;

public class ReserveDataList extends ArrayList<ReserveData> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public ReserveDataList(ReserveList reserveList) {
		super();
		for (int i=0; i<reserveList.size(); i++) {
			this.add(new ReserveData(reserveList.get(i)));
		}
	}
	
	public CircleList getCircles() {
		CircleList circles = new CircleList();
		for (int i=0; i<this.size(); i++) {
			circles.add(new Circle(this.get(i)));
		}
		return circles;
	}
	
	public double getPopulation() {
		double sum = 0.0;
		for (int i=0; i<this.size(); i++) {
			sum+=this.get(i).getCurrentPopulation();
		}
		return sum;
	}

	public double getCapacity() {
		double sum = 0.0;
		for (int i=0; i<this.size(); i++) {
			sum+=this.get(i).getMaxPopulation();
		}
		return sum;
	}

}
