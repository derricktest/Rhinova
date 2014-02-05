package rhinova.framework.binding;

public abstract class ModelBindingClass extends BindableObject {


	protected boolean allowOverpopulationDeaths = false;
	protected boolean inforceLinkCapacity = true;
	protected boolean inforceMaxPopulation = true;
	protected boolean inforceMinPopulationConstraint = true;
	protected boolean inforceLinkSurvivalRates = true;
	protected int	  numberOfYears = 2;
	protected String  solutionPath = "myFile.jobj"; 


	public void setAllowOverpopulationDeaths(boolean allowOverpopulationDeaths) {
		firePropertyChange(
				"allowOverpopulationDeaths",
				this.allowOverpopulationDeaths,
				this.allowOverpopulationDeaths = allowOverpopulationDeaths);
	}


	public void setInforceLinkCapacity(boolean inforceLinkCapacity) {
		firePropertyChange(
				"inforceLinkCapacity",
				this.inforceLinkCapacity,
				this.inforceLinkCapacity = inforceLinkCapacity);
	}


	public void setInforceMaxPopulation(boolean inforceMaxPopulation) {
		firePropertyChange(
				"inforceMaxPopulation",
				this.inforceMaxPopulation,
				this.inforceMaxPopulation = inforceMaxPopulation);
	}


	public void setInforceMinPopulationConstraint(boolean inforceMinPopulationConstraint) {
		firePropertyChange(
				"inforceMinPopulationConstraint",
				this.inforceMinPopulationConstraint,
				this.inforceMinPopulationConstraint = inforceMinPopulationConstraint);
	}


	public void setInforceLinkSurvivalRates(boolean inforceLinkSurvivalRates) {
		firePropertyChange(
				"inforceLinkSurvivalRates",
				this.inforceLinkSurvivalRates,
				this.inforceLinkSurvivalRates = inforceLinkSurvivalRates);
	}
	
	public void setNumberOfYears(int numberOfYears) {
		firePropertyChange(
				"numberOfYears",
				this.numberOfYears,
				this.numberOfYears = numberOfYears);
	}

	public void setSolutionPath(String solutionPath) {
		firePropertyChange(
				"solutionPath",
				this.solutionPath,
				this.solutionPath = solutionPath);
	}



	public boolean isAllowOverpopulationDeaths() {			return allowOverpopulationDeaths;	}
	public boolean isInforceLinkCapacity() {				return inforceLinkCapacity;	}
	public boolean isInforceMaxPopulation() {				return inforceMaxPopulation;	}
	public boolean isInforceMinPopulationConstraint() {		return inforceMinPopulationConstraint;}
	public boolean isInforceLinkSurvivalRates() {			return inforceLinkSurvivalRates;	}
	public int getNumberOfYears() {							return numberOfYears;	}
	public String getSolutionPath() {						return solutionPath;	}
}