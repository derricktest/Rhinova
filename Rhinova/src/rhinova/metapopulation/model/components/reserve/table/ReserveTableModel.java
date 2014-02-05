package rhinova.metapopulation.model.components.reserve.table;

import javax.swing.table.AbstractTableModel;

import org.springframework.context.ApplicationListener;

import rhinova.metapopulation.model.components.reserve.Reserve;
import rhinova.metapopulation.model.components.reserve.ReserveList;
import rhinova.metapopulation.model.components.reserve.aspect.ReserveListUpdateEvent;

public class ReserveTableModel extends AbstractTableModel implements ApplicationListener<ReserveListUpdateEvent> {

	private static final long serialVersionUID = 1L;

	ReserveList reserveList;

	private final String[] columnNames = Reserve.getHeadingStatic();


	public ReserveTableModel(ReserveList linkList) {
		this.reserveList = linkList;
	}

	@Override
	public String getColumnName(int columnIndex){
		return columnNames[columnIndex];
	}

	@Override     
	public int getRowCount() {
		return this.reserveList.size();
	}

	// {"id","name", "x position", "y position", "min population", "max population", "current population", "regeneration rate"};
	@Override        
	public int getColumnCount() {
		return 8; 
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Reserve reserve = this.reserveList.get(rowIndex);
		switch (columnIndex) {
		case 0: 
			return reserve.getId();
		case 1:
			return reserve.getName();
		case 2:
			return reserve.getXPos();
		case 3:
			return reserve.getYPos();
		case 4:
			return reserve.getMinPopulation();
		case 5:
			return reserve.getMaxPopulation();
		case 6:
			return reserve.getCurrentPopulation();
		case 7:
			return reserve.getRegenerationRate();
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
			return Double.class;
		case 5:
			return Double.class;
		case 6:
			return Double.class;
		case 7:
			return Double.class;
		}
		return null;
	}

	@Override
	public void onApplicationEvent(ReserveListUpdateEvent arg0) {
		this.fireTableDataChanged();
	}

}
