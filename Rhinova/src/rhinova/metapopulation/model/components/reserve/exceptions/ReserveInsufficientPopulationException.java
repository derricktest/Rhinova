package rhinova.metapopulation.model.components.reserve.exceptions;

public class ReserveInsufficientPopulationException extends Exception {

	@SuppressWarnings("unused")
	private ReserveInsufficientPopulationException(){}
	
	double availablePopulation;
	double triedToTake;
	
	public ReserveInsufficientPopulationException(double availablePopulation, double triedToTake) {
		this.availablePopulation = availablePopulation;
		this.triedToTake = triedToTake;
	}
	
	@Override
	public void printStackTrace(){
		System.err.println("Tried to take :"+this.triedToTake + "\n However there is only: "+this.availablePopulation +"\n available");
		super.printStackTrace();
	}
	
	
	private static final long serialVersionUID = 1L;

}
