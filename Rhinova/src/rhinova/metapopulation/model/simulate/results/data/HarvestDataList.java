package rhinova.metapopulation.model.simulate.results.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import rhinova.framework.drawable.Line;
import rhinova.framework.drawable.LineList;
import rhinova.metapopulation.model.optimise.results.OptimisedResultLink;

public class HarvestDataList extends ArrayList<HarvestData> implements Serializable {

	private static final long serialVersionUID = 1L;

	public HarvestDataList(List<OptimisedResultLink> optimiseResults) {
		super();
		for (int i=0; i<optimiseResults.size(); i++) {
			OptimisedResultLink result = optimiseResults.get(i);
			this.add(new HarvestData(result));
		}
	}

	public LineList getLines() {
		LineList lines = new LineList();
		for (int i=0; i<this.size(); i++) {
			if (! (this.get(i).getThickness() <= 0.0)) {
				lines.add(new Line(this.get(i)));
			}
		}
		return lines;
	}
}
