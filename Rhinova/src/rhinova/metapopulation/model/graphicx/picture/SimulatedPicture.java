package rhinova.metapopulation.model.graphicx.picture;

public abstract class SimulatedPicture extends Picture {

	private final int populationIndex;
	
	public int getPopulationIndex() {
		return populationIndex;
	}
	
	public int getYear() {
		return year;
	}

	public String getStage() {
		return stage;
	}

	public double getPopulation() {
		return population;
	}


	private int year = 0;
	private String stage = "initial";
	private double population = 0.0;


	SimulatedPicture(
			int pause,
			int year,
			String stage,
			double population,
			int populationIndex) {
		super(pause);
		this.year = year;
		this.stage = stage;
		this.population = population;
		this.populationIndex = populationIndex;
	}
}
