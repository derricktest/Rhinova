package rhinova.framework.drawable;

import java.util.ArrayList;

public class LineList extends ArrayList<Line>{


	private static final long serialVersionUID = 1L;
	
	private double largestThickness = 0.0025;
	
	private double largestInitial = 0.0;

	public boolean add(Line line) {
		
		if (line.getInitalThickness() > this.largestInitial) {
			this.largestInitial = line.getInitalThickness();
			super.add(line);
			this.scale();
			return true;
		} else {
			line.scale(largestThickness, largestInitial);
			return super.add(line);
		}
	}


	public double getLargestInitial() {
		double init = 0.0;
		for (int i=0; i<size(); i++) {
			double thickness = this.get(i).getInitalThickness();
			if (thickness>init) {
				init = thickness;
			}
		}
		return init;
	}

	public void scale() {
		for (int i=0; i<this.size(); i++) {
			this.get(i).scale(largestThickness, largestInitial);
		}
	}



}