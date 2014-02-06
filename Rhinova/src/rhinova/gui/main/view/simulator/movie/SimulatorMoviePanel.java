package rhinova.gui.main.view.simulator.movie;


import java.awt.Graphics;

import javax.swing.JPanel;

import org.springframework.context.ApplicationListener;

import rhinova.gui.main.view.controller.ControllerEvent;
import rhinova.metapopulation.model.graphicx.movie.Movie;

public class SimulatorMoviePanel extends JPanel implements ApplicationListener<ControllerEvent>, Runnable {

	private static final long serialVersionUID = 1L;

	Movie movie;


	public SimulatorMoviePanel() {
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void skipStart() {
		this.movie.firstFrame();
		this.triggerRepaint();
	}

	public void stepBack() {
		this.movie.previousFrame();
		this.triggerRepaint();
	}


	public void play() {
		this.start();
	}


	public void pause() {
		this.stop();
	}

	public void stopStep() {
		this.stop();
	}

	public void stepForward() {
		this.movie.nextFrame();
		this.triggerRepaint();
	}

	public void skipEnd() {
		this.movie.lastFrame();
		this.triggerRepaint();
	}


	private void triggerRepaint() {
		this.repaint();
	}



	@Override
	public void paint(Graphics g) {
		super.paint(g);
		try {
			movie.draw(g, this.getSize());
		} catch (Exception e) {
			System.out.println("Failed to draw yet");
		}
	}


	@Override
	public void onApplicationEvent(ControllerEvent arg0) {
		switch(arg0.getAction()) {
		case PAUSE:
			this.pause();
			break;
		case PLAY:
			this.play();
			break;
		case SKIPEND:
			this.skipEnd();
			break;
		case SKIPSTART:
			this.skipStart();
			break;
		case STEPBACK:
			this.stepBack();
			break;
		case STEPFORWARD:
			this.stepForward();
			break;
		case STOP:
			this.stopStep();
			break;
		default:
			break;
		}
	}







	Thread runner;

	public void start() {
		if (runner == null) {
			runner = new Thread(this);
			runner.start();
		}
	}

	@SuppressWarnings("deprecation")
	public void stop() {
		if (runner != null) {
			runner.stop(); // TODO fix 1 day
			runner = null;
		}
	}
	
	//volatile boolean animating;
	
	public void run() {
		while(true) {
			if (movie.isLastFrame()) {
				this.stop();
			}
			
			this.stepForward();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}







}
