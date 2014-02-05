package rhinova.metapopulation.model.simulate;

import java.util.List;

import rhinova.metapopulation.model.optimise.results.OptimisedResultSet;
import rhinova.metapopulation.model.simulate.results.SimulatedResult;

public interface Simulatable {

	List<SimulatedResult> getSimulateResultSet(OptimisedResultSet resultSet) throws SimulationException;

	void reset();
}
