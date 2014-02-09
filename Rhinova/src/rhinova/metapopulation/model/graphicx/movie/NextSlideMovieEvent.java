package rhinova.metapopulation.model.graphicx.movie;

import org.springframework.context.ApplicationEvent;

public class NextSlideMovieEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final int movieIndex;
	final int movieYear;

	public NextSlideMovieEvent(Object source, int movieIndex, int movieYear) {
		super(source);
		this.movieIndex = movieIndex;
		this.movieYear = movieYear;
	}
	
	public int getMovieIndex() {
		return this.movieIndex;
	}
	
	public int getMovieYear() {
		return this.movieYear;
	}

}
