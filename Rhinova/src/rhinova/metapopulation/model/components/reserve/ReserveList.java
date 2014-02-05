package rhinova.metapopulation.model.components.reserve;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationListener;

import rhinova.framework.drawable.Circle;
import rhinova.framework.drawable.CircleList;
import rhinova.framework.entity.RootModelEntityList;
import rhinova.framework.entity.tableable.ObjectGetter;
import rhinova.framework.entity.tableable.Tableable;
import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;
import rhinova.framework.entity.tableable.exceptions.NullInputException;
import rhinova.metapopulation.model.components.reserve.aspect.ReserveListUpdateEvent;
import rhinova.metapopulation.model.components.reserve.aspect.ReserveUpdate;
import rhinova.metapopulation.model.components.reserve.exceptions.FatalPopulationConstraintExceededException;


public class ReserveList extends RootModelEntityList<Reserve> implements ObjectGetter, ApplicationListener<ReserveListUpdateEvent> {



	/********************* Code for bean binding  **********************************/



	private PropertyChangeSupport changeSupport = 
			new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener 
			listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener 
			listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(propertyName, listener);
	}

	protected void firePropertyChange(String propertyName, 
			Object oldValue,
			Object newValue) {
		changeSupport.firePropertyChange(propertyName, oldValue, newValue);
		
	}


	
	
	// Reserve Ids for binding
	private List<Integer> reserveIds = new ArrayList<Integer>();

	public List<Integer> getReserveIds() {
		return reserveIds;
	}

	public void setReserveIds(List<Integer> reserveIds) {
		try {
		firePropertyChange("reserveIds", this.reserveIds, this.reserveIds = reserveIds);
		} catch (Exception e){}
	}

	@Override
	public void onApplicationEvent(ReserveListUpdateEvent arg0) {
		this.setReserveIds(this.getIds());
	}









	/*******************************************************************/



	/**
	 * @param lst
	 */
	public ReserveList(List<Reserve> lst) {
		super(lst);
	}

	/** Parameterless constructor*/
	public ReserveList() {
	}

	private static final long serialVersionUID = 1L;



	public double getTotalPopulation() {
		double sum = 0.0;
		for (int i=0; i<this.size(); i++) {
			sum+=this.get(i).getCurrentPopulation();
		}
		return sum;
	}

	
	@ReserveUpdate
	public void clear() {
		super.clear();
	}
	
	/**
	 * Method to create a new reserve and then add it to the list
	 * 
	 * @param stringName
	 * @param stringXPos
	 * @param stringYPos
	 * @param stringCurrentPopulation
	 * @param stringMinPopulation
	 * @param stringMaxPopulation
	 * @param stringRegenerationRate
	 */
	@ReserveUpdate
	public void createAndAddNewReserve(
			String stringName,
			String stringXPos,
			String stringYPos,
			String stringCurrentPopulation,
			String stringMinPopulation,
			String stringMaxPopulation,
			String stringRegenerationRate) throws IncorrectDataType, NullInputException, ConstraintViolatedException
			{
		this.add(new Reserve(stringName,
				stringXPos,
				stringYPos,
				stringCurrentPopulation,
				stringMinPopulation,
				stringMaxPopulation,
				stringRegenerationRate));
			}

//	@Override
//	public Tableable[] getAllObjects() {
//		return (Tableable[]) this.toArray();
//	}
	
	@Override
	public Object[][] getAllObjects() {
		final int noRows = this.size();
		final int noColumns = 8;//this.get(0).getRow().length;
		Object[][] allObjects = new Object[noRows][noColumns];
		for (int r=0; r<noRows; r++) {
			Tableable tableable = this.get(r);
			Object[] row = tableable.getRow();
			for (int c=0; c<noColumns; c++) {
				allObjects[r][c] = row[c];
			}
		}
		return allObjects;
	}

	@Override
	public void save(Tableable obj) {
		System.out.println("haven't implemented this yet");
	}


	// {"id","name", "x position", "y position", "min population", "max population", "current population", "regeneration rate"};
	@Override
	@ReserveUpdate
	public void createAndAddNewInstance(String[] values) throws IncorrectDataType, NullInputException, ConstraintViolatedException {

		//String id 						= values[0];
		String stringName 				= values[1];
		String stringXPos 				= values[2];
		String stringYPos 				= values[3];
		String stringMinPopulation 		= values[4];
		String stringMaxPopulation 		= values[5];
		String stringCurrentPopulation 	= values[6];
		String stringRegenerationRate 	= values[7];

		this.createAndAddNewReserve(stringName,
				stringXPos,
				stringYPos,
				stringCurrentPopulation,
				stringMinPopulation,
				stringMaxPopulation,
				stringRegenerationRate);
	}

	@Override
	@ReserveUpdate
	public void update(String[] values) {


		int id = Integer.parseInt(values[0]);
		String stringName = values[1];
		String stringXPos = values[2];
		String stringYPos = values[3];
		String stringMinPopulation = values[4];
		String stringMaxPopulation = values[5];
		String stringCurrentPopulation = values[6];
		String stringRegenerationRate = values[7];


		try {
			// check to see if the values are valid by creating a Reserve with the same values
			@SuppressWarnings("unused")
			Reserve reserve = new Reserve(stringName,stringXPos, stringYPos, stringCurrentPopulation, stringMinPopulation, stringMaxPopulation, stringRegenerationRate);
			// perform update
			this.getById(id).editUpdat(values);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to update");
		}
	}

	@Override
	@ReserveUpdate
	public void delete(String[] values) {
		this.removeById(Integer.parseInt(values[0]));
	}

	@Override
	@ReserveUpdate
	public void createTableable(String[] values) throws IncorrectDataType,
	ConstraintViolatedException, NullInputException {
		String stringName 				= values[1];
		String stringXPos 				= values[2];
		String stringYPos 				= values[3];
		String stringMinPopulation 		= values[4];
		String stringMaxPopulation 		= values[5];
		String stringCurrentPopulation 	= values[6];
		String stringRegenerationRate 	= values[7];

		this.add(new Reserve(stringName, stringXPos, stringYPos, stringCurrentPopulation, stringMinPopulation, stringMaxPopulation, stringRegenerationRate));
	}

	@ReserveUpdate
	public void remove(Reserve reserve) {
		super.remove(reserve);
	}

	@Override
	public String[] getHeading() {
		return Reserve.getHeadingStatic();
	}





	/** Array functions to be used constructing the objective function */

	/**
	 * @return array of all minimum populations
	 */
	public double[] getMinArray() {
		double[] min = new double[this.size()];
		for (int i=0; i<this.size(); i++) {
			min[i] = this.get(i).getMinPopulation();
		}
		return min;
	}

	/**
	 * @return array of all maximum populations
	 */
	public double[] getMaxArray() {
		double[] max = new double[this.size()];
		for (int i=0; i<this.size(); i++) {
			max[i] = this.get(i).getMaxPopulation();
		}
		return max;
	}

	/**
	 * @return array of all initial populations 
	 */
	public double[] getInitialArray() {
		double[] ini = new double[this.size()];
		for (int i=0; i<this.size(); i++) {
			ini[i] = this.get(i).getInitialPopulation();
		}
		return ini;
	}

	/**
	 * @return array of all regeneration rates
	 */
	public double[] getRegenerationArray() {
		double[] reg = new double[this.size()];
		for (int i=0; i<this.size(); i++) {
			reg[i] = this.get(i).getRegenerationRate();
		}
		return reg;
	}



	public void regenerateAll() {
		for (int i=0; i<this.size(); i++) {
			try {
				this.get(i).regenerate();
			} catch (FatalPopulationConstraintExceededException e) {
				e.printStackTrace();
			}
		}
	}

	public CircleList getCircleList() {
		CircleList circelableList = new CircleList();
		for (int i=0; i<this.size(); i++) {
			circelableList.add(new Circle(this.get(i)));
		}
		return circelableList;
	}



}
