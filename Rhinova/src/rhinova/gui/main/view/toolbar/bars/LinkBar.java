package rhinova.gui.main.view.toolbar.bars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import rhinova.gui.main.view.toolbar.MainToolBarMenu;
import rhinova.metapopulation.model.components.link.LinkList;
import rhinova.metapopulation.model.components.link.event.LinkEditDataEvent;


public class LinkBar extends MainToolBarMenu {

	private static final long serialVersionUID = 1L;

	LinkList linkList;
	
	@Autowired
	ApplicationEventPublisher publisher;
	
	
	public void setLinkList(LinkList linkList) {
		this.linkList = linkList;
	}
	
	public LinkBar() {
		super("Link");
		addNewAl(new LinkPrintAllAction(), 	"Print all");
		addNewAl(new LinkDataTableEdit(), "Edit Link Data");
	}
	
	public class LinkPrintAllAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Printing all the Links: \n\n\n");
			linkList.printAll();
		}
		
	}
	
	public class LinkDataTableEdit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			publisher.publishEvent(new LinkEditDataEvent(this));
		}
		
	}
	

}
