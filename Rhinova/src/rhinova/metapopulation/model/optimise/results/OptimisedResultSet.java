package rhinova.metapopulation.model.optimise.results;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OptimisedResultSet implements Serializable {
	
	private static final long serialVersionUID = 1L;


	// map with a list of simulated results per a year
	private List<List<OptimisedResultLink>> results = new ArrayList<List<OptimisedResultLink>>();

	int noYears = 0;
	
	
	public OptimisedResultSet(int noYears) {
		this.noYears = noYears;
		
		for (int y=1; y<=noYears; y++) {
			this.results.add(new ArrayList<OptimisedResultLink>());
		}
	}
	
	
	
	
	
	public int getNoYears() { return this.noYears;	}





	public void addSimulatedResultLink(OptimisedResultLink value) {
		this.results.get(value.getYear()-1).add(value);
	}





	public List<List<OptimisedResultLink>> getResults() {
		return this.results;
	}





	public List<OptimisedResultLink> getYearResults(int year) {
		return this.results.get(year);
	}





	public void printAllYears() {
		for (int y=0; y<this.results.size(); y++) {
			List<OptimisedResultLink> yearResults = this.results.get(y);
			for (int i=0; i<yearResults.size(); i++){
				System.out.println(yearResults.get(i));
			}
		}
	}

}
