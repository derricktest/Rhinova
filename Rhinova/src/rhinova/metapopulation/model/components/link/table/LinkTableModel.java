package rhinova.metapopulation.model.components.link.table;

import javax.swing.table.AbstractTableModel;

import org.springframework.context.ApplicationListener;

import rhinova.metapopulation.model.components.link.Link;
import rhinova.metapopulation.model.components.link.LinkList;
import rhinova.metapopulation.model.components.link.aspect.LinkListUpdateEvent;

public class LinkTableModel extends AbstractTableModel implements ApplicationListener<LinkListUpdateEvent>{


	private static final long serialVersionUID = 1L;

	LinkList linkList;

	private final String[] columnNames = Link.getHeadingStatic();


	public LinkTableModel(LinkList linkList) {
		this.linkList = linkList;
	}

	@Override
	public String getColumnName(int columnIndex){
		return columnNames[columnIndex];
	}

	@Override     
	public int getRowCount() {
		return this.linkList.size();
	}

	@Override        
	public int getColumnCount() {
		return 8; 
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Link link = this.linkList.get(rowIndex);
		switch (columnIndex) {
		case 0: 
			return link.getId();
		case 1:
			return link.getName();
		case 2:
			return link.getCapacity();
		case 3:
			return link.getSurvivalRate();
		case 4:
			return link.getReserve1No();
		case 5:
			return link.getReserve2No();
		case 6:
			return link.getReserve1().getName();
		case 7:
			return link.getReserve2().getName();
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex){
		switch (columnIndex){
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return Double.class;
		case 3:
			return Double.class;
		case 4:
			return Integer.class;
		case 5:
			return Integer.class;
		case 6:
			return String.class;
		case 7:
			return String.class;
		}
		return null;
	}

	@Override
	public void onApplicationEvent(LinkListUpdateEvent arg0) {
		this.fireTableDataChanged();
		this.fireTableStructureChanged();
	}

}
