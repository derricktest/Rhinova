package rhinova.metapopulation.model.simulate;

import org.springframework.context.ApplicationEvent;

import rhinova.metapopulation.model.simulate.results.SimulatedResultSet;

public class SimulationEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	final SimulatedResultSet results;
	
	public SimulationEvent(Object source, SimulatedResultSet results) {
		super(source);
		this.results = results;
	}
	
	public SimulatedResultSet getResuts() {
		return this.results;
	}

}
