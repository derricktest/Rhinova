package rhinova.metapopulation.model.simulate.results.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import rhinova.framework.drawable.Line;
import rhinova.metapopulation.model.components.link.LinkList;

public class LinkDataList extends ArrayList<LinkData> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public LinkDataList(LinkList links)
	{
		super();
		for (int i=0; i<links.size(); i++) {
			this.add(new LinkData(links.get(i)));
		}
	}
	
	public List<Line> getLines() {
		List<Line> lines = new ArrayList<>();
		for (int i=0; i<this.size(); i++) {
			lines.add(new Line(this.get(i)));
		}
		return lines;
	}

}
