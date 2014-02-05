package rhinova.gui.main.view.toolbar.bars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import rhinova.gui.main.view.toolbar.MainToolBarMenu;
import rhinova.metapopulation.model.components.reserve.ReserveEditDataEvent;
import rhinova.metapopulation.model.components.reserve.ReserveList;


public class ReserveBar extends MainToolBarMenu {

	private static final long serialVersionUID = 1L;
	
	ReserveList reserveList;
	
	@Autowired
	ApplicationEventPublisher publisher;
	
	public void setReserveList(ReserveList reserveList) {
		this.reserveList = reserveList;
	}

	public ReserveBar() {
		
		super("Reserve");
		
		addNewAl(new ReservePrintAllAction(), 	"Print all");
		addNewAl(new ReserveEditData(), "Edit Data");
	}
	
	
	public class ReservePrintAllAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Printing all Reserves: \n\n\n");
			reserveList.printAll();
		}
		
	}
	
	
	public class ReserveEditData implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			publisher.publishEvent(new ReserveEditDataEvent(this));
		}
		
	}
}
