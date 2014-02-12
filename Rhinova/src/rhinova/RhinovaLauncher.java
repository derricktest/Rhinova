package rhinova;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xml.sax.SAXException;

import rhinova.gui.HomeView;

public class RhinovaLauncher {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {

		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");


		HomeView comp = ctx.getBean(HomeView.class);
		comp.setVisible(true);
		
		
		System.out.println("Hello from derrickTest");

	}





}
