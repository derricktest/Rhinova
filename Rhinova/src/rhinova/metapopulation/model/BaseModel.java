package rhinova.metapopulation.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import rhinova.metapopulation.model.components.link.LinkList;
import rhinova.metapopulation.model.components.reserve.ReserveList;




/**
 * @author Derrick
 *
 */
@XmlRootElement
public class BaseModel {
	


	/** List of Reserves in the meta-population. **/
	@Autowired
	protected ReserveList reserves;
	
	/** List of Links in the meta-population **/
	@Autowired
	protected LinkList links;
	
	/** Empty constructor */
	public BaseModel(){}
	
	public ReserveList getReserves() {
		return reserves;
	}



	public LinkList getLinks() {
		return links;
	}


	
	public void save(String fileName) throws JAXBException {
		
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(this.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

             // output pretty printed
            jaxbMarshaller.setProperty(Marshaller. JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(this, file);
            jaxbMarshaller.marshal(this, System.out);
            System. out.println("file path = " );
            System. out.println(file.getAbsolutePath());

	}
	
	public void open(String fileName) throws JAXBException, FileNotFoundException {
		
		File file = new File(fileName);
		JAXBContext jaxbContext = JAXBContext.newInstance(this.getClass());
		Unmarshaller um = jaxbContext.createUnmarshaller();
		BaseModel tempMetapopulation = (BaseModel) um.unmarshal(new FileReader(file));
		
		this.reserves = tempMetapopulation.getReserves();
		this.links = tempMetapopulation.getLinks();


	}

}
