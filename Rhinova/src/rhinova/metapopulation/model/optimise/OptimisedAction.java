package rhinova.metapopulation.model.optimise;

import org.springframework.context.ApplicationEvent;

import rhinova.metapopulation.model.optimise.results.OptimisedResultSet;

public class OptimisedAction extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	final OptimisedResultSet resultSet;

	public OptimisedAction(Object source, OptimisedResultSet resultSet) {
		super(source);
		this.resultSet = resultSet;
	}
	
	public OptimisedResultSet getResultSet() {
		return this.resultSet;
	}

}
