package rhinova.gui.main.view.gis;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.annotation.PostConstruct;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;

import rhinova.metapopulation.model.components.link.LinkList;
import rhinova.metapopulation.model.components.link.aspect.LinkListUpdateEvent;
import rhinova.metapopulation.model.components.reserve.ReserveList;
import rhinova.metapopulation.model.components.reserve.aspect.ReserveListUpdateEvent;
import rhinova.metapopulation.model.graphicx.PictureFactory;
import rhinova.metapopulation.model.graphicx.picture.SimulatedPicture;


public class HomeGISPanel extends JPanel implements MouseListener, ApplicationListener<ApplicationEvent> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ApplicationEventPublisher publisher;

	PictureFactory pictureFactory = new PictureFactory();
	
	
	ReserveList reserveList;
	
	LinkList linkList;
	
	
	
	
	public void setReserveList(ReserveList reserveList) {
		this.reserveList = reserveList;
	}



	public void setLinkList(LinkList linkList) {
		this.linkList = linkList;
	}



	public HomeGISPanel() {
		this.setSize(400,400);
		this.setMinimumSize(this.getSize());
		this.addMouseListener(this);
	}



	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Dimension size = getSize();
		
		if (reserveList != null && linkList!=null) {
			// start picture
			SimulatedPicture pictureStart = pictureFactory.createCircleLinePicture(
					linkList.getLines(),
					reserveList.getCircleList(),
					0,
					0,
					"Start",
					reserveList.getTotalPopulation(),
					0);
			
			pictureStart.draw(g, size);
		}		

	}

	@PostConstruct
	private void init() {
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0)  {}
	@Override
	public void mouseExited(MouseEvent arg0)   {}
	@Override
	public void mousePressed(MouseEvent arg0)  {}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		GISPanelClickedEvent ev = new GISPanelClickedEvent(
				this,
				(double)arg0.getX()/this.getWidth(),
				(double)arg0.getY()/this.getHeight()
				);
		this.publisher.publishEvent(ev);

	}


	@Override
	public void onApplicationEvent(ApplicationEvent ev) {

		if (ev instanceof LinkListUpdateEvent ||
			ev instanceof ReserveListUpdateEvent)
		{		
			this.repaint();
		}
	}
}
