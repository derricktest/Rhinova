package rhinova.metapopulation.model.graphicx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;

import rhinova.framework.binding.BindableObject;
import rhinova.metapopulation.model.graphicx.movie.Movie;
import rhinova.metapopulation.model.graphicx.picture.JustCirclePicture;
import rhinova.metapopulation.model.simulate.SimulationEvent;
import rhinova.metapopulation.model.simulate.results.SimulatedResult;
import rhinova.metapopulation.model.simulate.results.SimulatedResultSet;
import util.SerializeTools;

public class Composer extends BindableObject implements
		ApplicationListener<SimulationEvent> {
	
	
	public Composer() {};

	Movie movie;
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Autowired
	ApplicationEventPublisher publisher;
	
	SimulatedResultSet simultatedResults;
	
	final static PictureFactory pictureFactory = new PictureFactory();
	
	// Default Values
	private final int numberOfYearsD = 2;
	private final int waitStartD = 300;
	private final int waitLeavingD = 300;
	private final int noMigratingPicturesD = 10;
	private final int waitMigratingD = 200;
	private final int waitArrivingD = 300;
	private int waitRegenerationD = 300;
	
	public void setDefault() {
		//this.setNumberOfYears(numberOfYearsD);
		this.setWaitStart(waitStartD);
		this.setWaitLeaving(waitLeavingD);
		this.setNoMigratingPictures(noMigratingPicturesD);
		this.setWaitMigrating(waitMigratingD);
		this.setWaitArriving(waitArrivingD);
		this.setWaitRegeneration(waitRegenerationD);
	}

	private int numberOfYears = numberOfYearsD; // TODO implement
	private int waitStart = waitStartD;
	private int waitLeaving = waitLeavingD;
	private int noMigratingPictures = noMigratingPicturesD;
	private int waitMigrating = waitMigratingD;
	private int waitArriving = waitArrivingD;
	private int waitRegeneration = waitRegenerationD;

	
	
	
	
	
	
	/** Need to create setters for binding the properties of this BindableObject */

	public void setWaitStart(int waitStart) {
		firePropertyChange(
				"waitStart",
				this.waitStart,
				this.waitStart = waitStart);
	}

	public void setWaitLeaving(int waitLeaving) {
		firePropertyChange(
				"waitLeaving",
				this.waitLeaving,
				this.waitLeaving = waitLeaving);
	}

	public void setWaitMigrating(int waitMigrating) {
		firePropertyChange(
				"waitMigrating",
				this.waitMigrating,
				this.waitMigrating = waitMigrating);
	}

	public void setWaitArriving(int waitArriving) {
		firePropertyChange(
				"waitArriving",
				this.waitArriving,
				this.waitArriving = waitArriving);
	}

	public void setWaitRegeneration(int waitRegeneration) {
		firePropertyChange(
				"waitRegeneration",
				this.waitRegeneration,
				this.waitRegeneration = waitRegeneration);
	}
	
	public void setNoMigratingPictures(int noMigratingPictures) {
		firePropertyChange(
				"noMigratingPictures",
				this.noMigratingPictures,
				this.noMigratingPictures = noMigratingPictures);
	}
	
	public void setNumberOfYears(int numberOfYears) {
		firePropertyChange(
				"numberOfYears",
				this.numberOfYears,
				this.numberOfYears = numberOfYears);
	}

	public int getWaitStart() {				return waitStart;	}
	public int getWaitLeaving() {			return waitLeaving;	}
	public int getWaitMigrating() {			return waitMigrating;	}
	public int getWaitArriving() {			return waitArriving;	}
	public int getWaitRegeneration() {		return waitRegeneration;	}
	public int getNoMigratingPictures() {	return noMigratingPictures;	}
	public int getNumberOfYears() {			return numberOfYears;	}
	
	
	/**
	 * Method to compose a movie from a SimulatedResultSet
	 * 
	 * @param simultatedResults
	 * @return
	 */
	public void compose(SimulatedResultSet simultatedResults) {

		this.simultatedResults = simultatedResults;

		PictureFactory pictureFactory = new PictureFactory();

		movie.setInitialPopulation(simultatedResults.getInitialPopulatino());
		movie.setFinalPopulation(simultatedResults.getFinalPopulation());
		movie.setCapacity(simultatedResults.getCapacity());

		// clear the movie list of pictures
		movie.clear();

		int populationIndex = 0;
		
		for (int i = 0; i < simultatedResults.size(); i++) {
			SimulatedResult result = simultatedResults.get(i);

			// start picture
			JustCirclePicture pictureStart = pictureFactory.createCirclePicture(
					null, result.getStageStart().getReserveDataList()
							.getCircles(), waitStart, i, "Start", result
							.getStageStart().getReserveDataList()
							.getPopulation(),
							populationIndex);
			movie.addPicture(pictureStart);
			populationIndex++;

			// migrating picture
			for (int j = 1; j <= noMigratingPictures; j++) {
				JustCirclePicture migratingPicture = pictureFactory
						.createArrowCirclePicture(
								result.getStageLeaving().getHarvestDataList().getLines(),
								result.getStageLeaving().getReserveDataList().getCircles(), waitLeaving, (double) j
								/ noMigratingPictures, i, "Leaving",
								result.getStageLeaving().getReserveDataList()
										.getPopulation(),
										populationIndex);
				movie.addPicture(migratingPicture);
				
			}
			populationIndex++;

			// arriving picture
			JustCirclePicture pictureArriving = pictureFactory
					.createCirclePicture(null, result.getStageArriving()
							.getReserveDataList().getCircles(),
							waitMigrating, i, "Arriving", result
									.getStageArriving().getReserveDataList()
									.getPopulation(),
									populationIndex);
			movie.addPicture(pictureArriving);
			populationIndex++;

			// regeneration picture
			JustCirclePicture pictureRegeneration = pictureFactory
					.createCirclePicture(null, result.getStageRegeneration()
							.getReserveDataList().getCircles(),
							waitRegeneration, i, "Regeneration",
							result.getStageRegeneration().getReserveDataList()
									.getPopulation(),
									populationIndex);
			movie.addPicture(pictureRegeneration);
			populationIndex++;
		}
		this.publisher.publishEvent(new ComposedEvent(this));
	}

	/**
	 * Method to compose and save the tool.
	 * 
	 * @param simulatedResultsFilename
	 * @param movieOutputFileName
	 */
	public void composeSave(String simulatedResultsFilename,
			String movieOutputFileName) {
		SimulatedResultSet simulatedResultSet = SerializeTools.open(
				simulatedResultsFilename, SimulatedResultSet.class);
		compose(simulatedResultSet);
		SerializeTools.save(movieOutputFileName, movie);
	}

	@Override
	public void onApplicationEvent(SimulationEvent arg0) {
		this.compose(arg0.getResuts());
	}
}
