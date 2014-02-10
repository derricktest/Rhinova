package rhinova.metapopulation.model.components.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.xml.bind.JAXBException;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;
import rhinova.framework.entity.tableable.exceptions.NullInputException;
import rhinova.metapopulation.model.components.dao.aspect.DaoAction;
import rhinova.metapopulation.model.components.link.Link;
import rhinova.metapopulation.model.components.link.LinkList;
import rhinova.metapopulation.model.components.link.aspect.LinkUpdate;
import rhinova.metapopulation.model.components.reserve.Reserve;
import rhinova.metapopulation.model.components.reserve.ReserveList;
import rhinova.metapopulation.model.components.reserve.aspect.ReserveUpdate;


/**
 * Class responsible for serializing and opening the Meta-population
 */
public class MetapopulationDao {


	/** LinkList */
	private LinkList linkList;


	/** ReserveList */
	private ReserveList reserveList;
	
	
	
	public LinkList getLinkList() {
		return linkList;
	}

	public void setLinkList(LinkList linkList) {
		this.linkList = linkList;
	}

	public ReserveList getReserveList() {
		return reserveList;
	}

	public void setReserveList(ReserveList reserveList) {
		this.reserveList = reserveList;
	}


	final String firstReserveElement = "R";
	final String firstLinkElement = "L";

	/**
	 * Method to serialize a Meta-population to XML
	 * @param fileName
	 */
	@DaoAction
	public void save(String fileName) {
		CSVWriter writer = null;
		try{
			writer = new CSVWriter(new FileWriter(fileName));

			// write the reserves to the csv file
			for (int i=0; i<this.reserveList.size(); i++) {
				Reserve reserve = reserveList.get(i);
				
				String id = reserve.getId()+"";
				String name = reserve.getName();
				String x = reserve.getXPos()+"";
				String y = reserve.getYPos()+"";
				String pop = reserve.getCurrentPopulation()+"";
				String min = reserve.getMinPopulation()+"";
				String max = reserve.getMaxPopulation()+"";
				String reg = reserve.getRegenerationRate()+"";
				String init = reserve.getInitialPopulation()+"";

				String[] resRow = new String[]{firstReserveElement, id, name, x, y, pop, min, max, reg, init};
				writer.writeNext(resRow);
			}
			
			
			for (int i=0; i<this.linkList.size(); i++) {
				Link link = this.linkList.get(i);
				
				String id = link.getId()+"";
				String name = link.getName();
				String cap = link.getCapacity()+"";
				String surv = link.getSurvivalRate()+"";
				String res1 = link.getReserve1No()+"";
				String res2 = link.getReserve2No()+"";
				
				String[] linkRow = new String[]{firstLinkElement, id, name, cap, surv, res1, res2};
				writer.writeNext(linkRow);
			}

			this.trackFile(fileName);
			System.out.println("Saved file: "+fileName);
		} catch(Exception e) {
			System.out.println("Could not save file!");
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * Method to open a file containing a Meta-population
	 * @param fileName
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * @throws JAXBException
	 */
	@LinkUpdate
	@ReserveUpdate // only need one of these
	@DaoAction
	public void open(String fileName) throws NumberFormatException, IOException {
		CSVReader reader = new CSVReader(new FileReader(fileName));
		
		
		// clear the lists
		this.reserveList.clear();
		this.linkList.clear();
		
			String nextLine[] = null;
			while ((nextLine = reader.readNext()) != null) {
				
				
				/** Reserve entry */
				if (nextLine[0].equals(this.firstReserveElement)) {
						
						// get the values of the old reserve
						// {firstReserveElement, id, name, x, y, pop, min, max, reg, init};
						String id = nextLine[1];
						String name = nextLine[2];
						String x = nextLine[3];
						String y = nextLine[4];
						String pop = nextLine[5];
						String min = nextLine[6];
						String max = nextLine[7];
						String reg = nextLine[8];
						String init = nextLine[9];
						
						// create the reserve
						Reserve reserve=null;
						try {
							reserve = new Reserve(
									id,
									name,
									x,
									y,
									pop,
									min,
									max,
									reg);
						} catch (NullInputException | IncorrectDataType
								| ConstraintViolatedException e) {
							e.printStackTrace();
						}
						
						// set the initial population and current population
						reserve.setInitialPopulation(Double.parseDouble(init));
						reserve.setCurrentPopulation(Double.parseDouble(init));
						
						// add the reserve
						this.reserveList.add(reserve);
					
				}
				
				
				/** Link Entry */
				if (nextLine[0].equals(this.firstLinkElement)) {

						String id = nextLine[1];
						String name = nextLine[2];
						String cap = nextLine[3];
						String surv = nextLine[4];
						String res1 = nextLine[5];
						String res2 = nextLine[6];

						try {
							this.linkList.add(new Link(
									id,
									name,
									cap,
									surv,
									res1,
									res2,
									this.reserveList.getList()));
						} catch (NullInputException | IncorrectDataType
								| ConstraintViolatedException e) {
							e.printStackTrace();
						}
						

				}
				System.out.println("Openend file "+fileName);
			}
			reader.close();
		this.trackFile(fileName);
	}


	/** Properties for keeping track for the last open file. */
	Properties properties = new Properties();

	String propertiesPath = null;


	public void trackFile(String fileName) {
		lastOpendFilePath = fileName;
	}

	String lastOpendFilePath = "";
	
	/** get the last open path */
	public String getLastFilePath() {
		return lastOpendFilePath;
	}

	@DaoAction
	public void close() {
		this.trackFile("");
		this.reserveList.clear();
		this.linkList.clear();
	}

}
