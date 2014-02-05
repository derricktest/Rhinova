package rhinova.metapopulation.model;



import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;


/**
 * @author Derrick
 *
 */

@Component
@XmlRootElement
public class Metapopulation extends BaseModel
{

	
	

//	
//	
//	public void print()
//	{
//		System.out.println("hello");
//	}
//	
//	/** Adding Reserves **/
//	
//	public Reserve createNewReserve(
//			String stringName,
//			String stringXPos,
//			String stringYPos,
//			String stringCurrentPopulation,
//			String stringMinPopulation,
//			String stringMaxPopulation,
//			String stringRegenerationRate)
//					throws
//					NullInputException,
//					IncorrectDataTypesInputException,
//					ReservePopulationInputError
//	{
//		return new Reserve (
//				stringName,
//				stringXPos,
//				stringYPos,
//				stringCurrentPopulation,
//				stringMinPopulation,
//				stringMaxPopulation,
//				stringRegenerationRate);
//	}
//	
//	public void addReserve(Reserve new_reserve)
//	{
//		// TODO need to add for duplicates
//		this.reserves.add(new_reserve);
//	}
//	
//	public void createAndAddNewReserve(
//			String stringName,
//			String stringXPos,
//			String stringYPos,
//			String stringCurrentPopulation,
//			String stringMinPopulation,
//			String stringMaxPopulation,
//			String stringRegenerationRate)
//					throws NullInputException,
//					IncorrectDataTypesInputException,
//					ReservePopulationInputError
//	{
//		this.addReserve(this.createNewReserve(stringName,
//				stringXPos,
//				stringYPos,
//				stringCurrentPopulation,
//				stringMinPopulation,
//				stringMaxPopulation,
//				stringRegenerationRate));
//	}
//	
//
//	public Link createLink(String s_name,
//			String stringCapacity,
//			String stringSurvivalRate,
//			String stringReserveNo1,
//			String stringReserveNo2)
//					throws
//					NullInputException,
//					IncorrectDataTypesInputException,
//					LinkIncorrectValuesException,
//					EmptyReserveListException,
//					LinkCannotFindReserveException
//	{
//		return new Link(s_name,
//				stringCapacity,
//				stringSurvivalRate,
//				stringReserveNo1,
//				stringReserveNo2,
//				this.reserves);
//	}
//	
//	public void addLink(Link new_link)
//	{
//		// TODO need to check for duplicates 
//		this.links.add(new_link);
//	}
//	
//	public void createAndAddNewLink(String nameString,
//			String capacityString,
//			String survivalRateString,
//			String reserveNo1String,
//			String reserveNo2String)
//					throws NullInputException,
//					IncorrectDataTypesInputException,
//					LinkIncorrectValuesException,
//					EmptyReserveListException,
//					LinkCannotFindReserveException
//	{
//		this.addLink(this.createLink(nameString,
//				capacityString,
//				survivalRateString,
//				reserveNo1String,
//				reserveNo2String));
//	}
//	
//
//
//	public void printAllReserves()
//			throws EmptyReserveListException
//	{
//		if (this.reserves.size() == 0)
//		{
//			throw new EmptyReserveListException();
//		}
//		for (Reserve reserve: this.reserves)
//		{
//			System.out.println(reserve);
//			System.out.println("...");
//		}
//	}
//
//
//	public void printAllLinks()
//			throws EmptyLinkException {
//		if (this.links.size() == 0)
//		{
//			throw new EmptyLinkException();
//		}
//		for (Link link: this.links)
//		{
//			System.out.println(link);
//			System.out.println("...");
//		}
//	}
//	
//	/**
//	 * Finds the most efficient harvest using the Python Pulp module
//	 * @param folder_path
//	 */
//	public void findMostEfficientHarvestUsingPulp(String folder_path)
//	{
//		System.out.println(folder_path);
//	}
//	
//	
//	/**
//	 * Simulates one year of harvesting
//	 * @param file_path
//	 */
//	public void simulateOneYear(String file_path)
//	{
//		
//	}
//	
//	/**
//	 * Simulates all years of harvesting
//	 * @param folder_path
//	 */
//	public void simulateAllYears(String folder_path)
//	{
//		
//	}
//
//
//
//
////	@Override
////	public CircleData getDrawingDetailsReserves() throws EmptyReserveListException
////	{
////		if (this.reserves.size()== 0 || this.reserves == null)
////		{
////			throw new EmptyReserveListException();
////		}
////		
////		int size = this.reserves.size();
////		
////		double[] capacities 		= new double[size];
////		double[] regeneration_rates = new double[size];
////		double[] population			= new double[size];
////		int[] x_coordinates 		= new int[size];
////		int[] y_coordinates 		= new int[size];
////		String[] names				= new String[size];
////		int[] ids					= new int[size];
////		
////		
////		for (int i=0; i<this.reserves.size(); i++)
////		{
////			Reserve reserve = this.reserves.get(i);
////			capacities[i] = reserve.getMax_population();
////			regeneration_rates[i] = reserve.getRegeneration_rate();
////			population[i] = reserve.getCurrent_population();
////			x_coordinates[i] = reserve.getY();
////			y_coordinates[i] = reserve.getX();
////			names[i] = reserve.getName();
////			ids[i] = reserve.getId();
////		}
////		
////		return new CircleData(
////				x_coordinates,
////				y_coordinates,
////				capacities,
////				population,
////				regeneration_rates,
////				names,
////				ids);
////	}
//	
//	
//
//
//	public static void main(String[] args) throws JAXBException, FileNotFoundException {
//		Metapopulation metapopulation= new Metapopulation();
//		try {
//			metapopulation.createAndAddNewReserve(
//					"Pop1",
//					"4",
//					"3",
//					"10",
//					"0",
//					"1000",
//					"0.3");
//			
//			metapopulation.createAndAddNewReserve(
//					"Pop2",
//					"4",
//					"3",
//					"10",
//					"0",
//					"1000",
//					"0.3");
//			
//			metapopulation.createAndAddNewLink(
//					"l1",
//					"200",
//					"0.9",
//					"0",
//					"1"
//					);
//			
//			
//			String file = "C:\\Users\\Derrick\\Desktop\\test.xml";
//			
//			metapopulation.save(file);
//			metapopulation.setLinks(new ArrayList<Link>());
//			metapopulation.setReserves(new ArrayList<Reserve>());
//			System.out.println(metapopulation.links.size());
//			metapopulation.open(file);
//			System.out.println(metapopulation.links.size());
//			System.out.println(metapopulation.links.get(0).getReserve1());
//			
//			
//			System.out.println("Success");
//		} catch (
//				NullInputException |
//				IncorrectDataTypesInputException |
//				ReservePopulationInputError |
//				LinkIncorrectValuesException |
//				EmptyReserveListException |
//				LinkCannotFindReserveException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
