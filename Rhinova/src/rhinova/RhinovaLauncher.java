package rhinova;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xml.sax.SAXException;

import rhinova.gui.HomeView;
import rhinova.metapopulation.model.components.dao.MetapopulationDao;

public class RhinovaLauncher {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {

		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");


		try {
			MetapopulationDao dao = ctx.getBean(MetapopulationDao.class);
			try {
				dao.open(dao.getLastOpen());
			} catch(Exception e) {}
		}catch(Exception e) {}
		HomeView comp = ctx.getBean(HomeView.class);
		comp.setVisible(true);
		

	}





}
