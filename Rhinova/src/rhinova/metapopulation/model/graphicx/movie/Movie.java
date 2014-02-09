package rhinova.metapopulation.model.graphicx.movie;

import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import rhinova.metapopulation.model.graphicx.picture.JustCirclePicture;
import rhinova.metapopulation.model.graphicx.picture.SimulatedPicture;


public class Movie {

	// Binding Display Properties    
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    // properties change every picture
	private int year = 0;
	private String stage = "initial";
	private double population = 0.0;
	
	
	// properties change only at creation
	private double initialPopulation = 0.0;
	private double finalPopulation = 0.0;
	private double capacity = 0.0;
	
    // Picture Properties
    protected List<JustCirclePicture> pictures = new ArrayList<>();
	private int currentPictureIndex=0;
	
	private int noPictures = 0;
	
	private int populationIndex=0;
	
	
	public void clear() {
		this.pictures.clear();
	}
	
	
	
	/******************* Constructor forcing Initial Bindings ************/
	
	protected Movie(
			List<JustCirclePicture> pictures,
			double initialPopulation,
			double finalPopulation,
			double capacity) {
		
		this(initialPopulation, finalPopulation, capacity, pictures);
	}
	
	public Movie(
			double initialPopulation,
			double finalPopulation,
			double capacity,
			List<JustCirclePicture> pictures) {
		
		this.pictures = pictures;
		this.setInitialPopulation(initialPopulation);
		this.setFinalPopulation(finalPopulation);
		this.setCapacity(capacity);
		this.setNoPictures(pictures.size());
	}
	
	
	public JustCirclePicture getCurrentPicture() {
		return this.pictures.get(this.currentPictureIndex);
	}
	
	public int noPictures() {
		return this.pictures.size();
	}
	
	public Movie() {
		this(0,0.0,0, new ArrayList<JustCirclePicture>());
	}

	public Movie(double initialPopulatino, double finalPopulation2,
			double capacity2) {
		this(new ArrayList<JustCirclePicture>(), initialPopulatino, finalPopulation2, capacity2);
	}

	/**
	 * Method to draw Movie
	 * @param g
	 * @param d
	 */
	public void draw(Graphics g, Dimension d) {
		this.pictures.get(this.currentPictureIndex).draw(g, d);
	}
	
	public void addPicture(JustCirclePicture picture) {
		this.pictures.add(picture);
		this.setNoPictures(this.pictures.size());
	}
	
	/*********************** Setting the Current Picture **********************/
	
	
    public int getCurrentPictureIndex() {
		return currentPictureIndex;
	}
    
    private synchronized void setProperties() {
    	SimulatedPicture pic = this.pictures.get(this.getCurrentPictureIndex());
    	this.setYear(pic.getYear());
    	this.setStage(pic.getStage());
    	this.setPopulation(pic.getPopulation());
    	this.setNoPictures(this.pictures.size());
    	this.setPopulationIndex(pic.getPopulationIndex());
    }
    
	
	public synchronized void nextFrame() {
		int cur = this.getCurrentPictureIndex();
		int next = cur+1;
		if (next >= this.pictures.size()) {
			next = cur;
		}
		this.setCurrentPicture(next);
	}
	
	public synchronized void previousFrame() {
		int cur = this.getCurrentPictureIndex();
		int next = cur-1;
		if (next < 0) {
			next = 0;
		}
		this.setCurrentPicture(next);
	}
	
	public synchronized void lastFrame() {
		this.setCurrentPicture(this.pictures.size()-1);
	}
	
	public synchronized void firstFrame() {
		this.setCurrentPicture(0);
	}
	
	

	
	/********************* Start of Property Bindings ****************************/
	
	
	public final void setYear(int year) {
		
		int oldYear = this.year;
		int newYear = year;
		
		this.year = year;
		
		propertyChangeSupport.
	    firePropertyChange(
			       "year",
			       oldYear,
			       newYear);
	}

	
	@Autowired
	ApplicationEventPublisher publisher;
	
	private void setCurrentPicture(int currentPictureIndex) {
		
		int oldcurrentPictureIndex = this.currentPictureIndex;
		int newcurrentPictureIndex = currentPictureIndex;
		
		this.currentPictureIndex = newcurrentPictureIndex;
		
		propertyChangeSupport.
	    firePropertyChange(
			       "currentPictureIndex",
			       oldcurrentPictureIndex,
			       newcurrentPictureIndex);
		
		setProperties();
		
		//this.publisher.publishEvent(new NextSlideMovieEvent(this, this.getCurrentPictureIndex()));
	}
	
	
	
	public final void setStage(String stage) {
		
		String oldStage = this.stage;
		String newStage = stage;
		
		this.stage = stage;
		
		propertyChangeSupport.
	    firePropertyChange(
			       "stage",
			       oldStage,
			       newStage);
	}
	
	
	public final void setPopulationIndex(int populationIndex) {
		int oldPopulationIndex = this.populationIndex;
		int newPopulationIndex = populationIndex;
		
		this.populationIndex = populationIndex;
		
		propertyChangeSupport.
	    firePropertyChange(
			       "populationIndex",
			       oldPopulationIndex,
			       newPopulationIndex);
		
		
		publisher.publishEvent(new NextSlideMovieEvent(this,this.populationIndex, this.getYear()));
		
	}

	public final void setPopulation(double population) {
		
		double oldPopulation = this.population;
		double newPopulation = population;
		
		this.population = population;
		
		propertyChangeSupport.
	    firePropertyChange(
			       "population",
			       oldPopulation,
			       newPopulation);
	}

	public final void setInitialPopulation(double initialPopulation) {
		
		double oldInitialPopulation = this.initialPopulation;
		double newInitialPopulation = initialPopulation;
		
		this.initialPopulation = initialPopulation;
		
		propertyChangeSupport.
	    firePropertyChange(
			       "initialPopulation",
			       oldInitialPopulation,
			       newInitialPopulation);
	}

	public final void setFinalPopulation(double finalPopulation) {
		
		double oldFinalPopulation = this.finalPopulation;
		double newFinalPopulation = finalPopulation;
		
		this.finalPopulation = finalPopulation;
		
		propertyChangeSupport.
	    firePropertyChange(
			       "finalPopulation",
			       oldFinalPopulation,
			       newFinalPopulation);
	}

	public final void setCapacity(double capacity) {
		
		double oldCapacity = this.capacity;
		double newCapacity = capacity;
		
		this.capacity = capacity;
		
		propertyChangeSupport.
	    firePropertyChange(
			       "capacity",
			       oldCapacity,
			       newCapacity);
	}
	
	public void setCurrentPictureIndex(int currentPictureIndex) {
		
		int oldCurrentPictureIndex = this.currentPictureIndex;
		int newCurrentPictureIndex = currentPictureIndex;
		
		this.currentPictureIndex = currentPictureIndex;
		
		propertyChangeSupport.
	    firePropertyChange(
			       "currentPictureIndex",
			       oldCurrentPictureIndex,
			       newCurrentPictureIndex);
	}
	
	
	public void setNoPictures(int noPictures) {
		
		int oldNoPictures = this.noPictures;
		int newNoPictures = noPictures;
		
		this.noPictures = noPictures;
		
		propertyChangeSupport.
	    firePropertyChange(
			       "noPictures",
			       oldNoPictures,
			       newNoPictures);
	}
	
	
	
    /** Essential Bean property change handling events, so that Beans Binding
     * can use a Person as a source, not just a target */
    public void addPropertyChangeListener(PropertyChangeListener l) {
	propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
	propertyChangeSupport.removePropertyChangeListener(l);
    }

    
    /************************ End of Property Bindings **************************/
    
    
    // Getters
	public int getYear() {
		return year;
	}

	public String getStage() {
		return stage;
	}

	public double getPopulation() {
		return population;
	}

	public double getInitialPopulation() {
		return initialPopulation;
	}

	public double getFinalPopulation() {
		return finalPopulation;
	}

	public double getCapacity() {
		return capacity;
	}

	public int getNoPictures() {
		return noPictures;
	}


	public boolean isLastFrame() {
		if (this.getCurrentPictureIndex() ==  this.pictures.size() - 1) {
			return true;
		} else {
			return false;
		}
	}
}
