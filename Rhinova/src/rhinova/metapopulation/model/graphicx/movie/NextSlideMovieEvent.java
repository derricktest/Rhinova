package rhinova.metapopulation.model.graphicx.movie;

import org.springframework.context.ApplicationEvent;

public class NextSlideMovieEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final int movieIndex;

	public NextSlideMovieEvent(Object source, int movieIndex) {
		super(source);
		this.movieIndex = movieIndex;
	}
	
	public int getMovieIndex() {
		return this.movieIndex;
	}

}
