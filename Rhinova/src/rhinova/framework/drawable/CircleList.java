package rhinova.framework.drawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class CircleList extends ArrayList<Circle>{

	
	private static final long serialVersionUID = 1L;
	
	private double largestRadius = 0.09;
	
	private double largestInitial = 0.0;
	
	
	
	@Override
	public boolean add(Circle circle) {
		
		if (circle.getInitMax() > largestInitial) {
			this.largestInitial = circle.getInitMax();
			super.add(circle);
			this.scale();
			return true;
		} else {
			circle.scale(largestRadius, largestInitial);
			return super.add(circle);
		}
	}
	
	
	public double getLargestInitial() {
		double init = 0.0;
		for (int i=0; i<size(); i++) {
			double thickness = this.get(i).getInitMax();
			if (thickness>init) {
				init = thickness;
			}
		}
		return init;
	}
	
	public double getLargestMaxR() {
		double max = 0.0;
		for (int i=0; i<size(); i++) {
			double thickness = this.get(i).getMaxR();
			if (thickness>max) {
				max = thickness;
			}
		}
		return max;
	}
	
	
	
	public void scale() {
		for (int i=0; i<this.size(); i++) {
			this.get(i).scale(largestRadius, largestInitial);;
		}
	}
	
	public Map<String,Double> getPopulations() {
		Map<String,Double> map = new HashMap<String,Double>();
		for (Circle circle : this) {
			map.put(circle.getName(), circle.getInitCur());
		}
		return map;
	}
	
    /**
     * Pie data for each of the individual populations
     * @return
     */
    public PieDataset getPieDataSet() {
    	Map<String,Double> map = this.getPopulations();
    	
        DefaultPieDataset result = new DefaultPieDataset();
        for (Entry<String, Double> entry: map.entrySet()) {
        	result.setValue(entry.getKey(), entry.getValue());
        }
        return result;
    }
	

}
