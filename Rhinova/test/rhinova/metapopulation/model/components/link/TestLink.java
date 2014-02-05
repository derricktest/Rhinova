package rhinova.metapopulation.model.components.link;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;
import rhinova.framework.entity.tableable.exceptions.NullInputException;
import rhinova.metapopulation.model.components.link.Link;
import rhinova.metapopulation.model.components.reserve.Reserve;
/**
 * Class for testing the Link Class.
 */
public class TestLink {

	static Reserve reserve_1;
	static Reserve reserve_2;
	static List<Reserve> list_of_reserves;

	/**
	 * Initializes the Reserves and the List of Reserves needed for the test
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		reserve_1 = new Reserve("john", "1", "2", "100", "10", "200", "0.3");
		reserve_2 = new Reserve("smith", "1", "2", "100", "10", "200", "0.3");
		list_of_reserves = new ArrayList<Reserve>();
		list_of_reserves.add(reserve_1);
		list_of_reserves.add(reserve_2);
	}

	
	/**
	 * Testing if the constructor works for a valid Link
	 */
	@Test
	public void  shouldCreateLink()
	{
		try
		{
			@SuppressWarnings("unused")
			Link link = new Link("bob", "200", "0.9", "0", "1",list_of_reserves);
		}
		catch(Exception e)
		{
			fail("Failed to create valid Link!!!");
		}
	}
	

	/**
	 * Testing that the Link constructor throws an empty NullInputException
	 * reserve_list=null.
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataType 
	 * @throws NullInputException 
	 */
	@Test(expected = NullInputException.class)
	public void shouldThrowNullInputException() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Link link = new Link("bob", "200", "0.9", "0", "1",null);
	}

	/**
	 * Testing that the Link constructor throws an NullInputException when there are inputs.
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataType 
	 * @throws NullInputException 
	 */
	@Test(expected = NullInputException.class)
	public void testLinkNullInputException() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Link link = new Link("", "200", "0.9", "0", "1",TestLink.list_of_reserves);
	}

	/**
	 * Testing the Link constructor throws an IncorrectDataTypesInputException when the
	 * string input cannot be parsed to the correct data type.
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataType 
	 * @throws NullInputException 
	 */
	@Test(expected = IncorrectDataType.class)
	public void testLinkIncorrectDataTypesInputException() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Link link = new Link("john", "a", "0.9", "0", "1",TestLink.list_of_reserves);
	}

	/**
	 * Testing the Link constructor throws an LinkIncorrectValuesException when
	 * reserve_no_1 = reserve_no_2.
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataType 
	 * @throws NullInputException 
	 */
	@Test(expected = ConstraintViolatedException.class)
	public void testLinkIncorrectValuesExceptionReservesEqual() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Link link = new Link("john", "200", "0.9", "0", "0",TestLink.list_of_reserves);
	}

	/**
	 * Testing the Link constructor throws an LinkIncorrectValuesException when the capacity
	 * is negative
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataType 
	 * @throws NullInputException 
	 */
	@Test(expected = ConstraintViolatedException.class)
	public void testLinkIncorrectValuesExceptionCapacityNegative() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Link link = new Link("john", "-200", "0.9", "0", "1",TestLink.list_of_reserves);
	}

	/**
	 * Testing the Link constructor throws an LinkIncorrectValuesException when the capacity
	 * is equal to 0.
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataType 
	 * @throws NullInputException 
	 */
	@Test(expected = ConstraintViolatedException.class)
	public void testLinkIncorrectValuesExceptionCapacity0() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Link link = new Link("john", "0", "0.9", "0", "1",TestLink.list_of_reserves);
	}
	
	/**
	 * Testing the Link constructor throws an LinkIncorrectValuesException when the survival rate
	 * is equal to 0.
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataType 
	 * @throws NullInputException 
	 */
	@Test(expected = ConstraintViolatedException.class)
	public void testLinkIncorrectValuesExceptionSurvival0() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Link link = new Link("john", "200", "0", "0", "1",TestLink.list_of_reserves);
	}
	
	/**
	 * Testing the Link constructor throws an LinkIncorrectValuesException when the survival rate
	 * is less than 0.
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataType 
	 * @throws NullInputException 
	 */
	@Test(expected = ConstraintViolatedException.class)
	public void testLinkIncorrectValuesExceptionSurvivalNegative() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Link link = new Link("john", "200", "-0.9", "0", "1",TestLink.list_of_reserves);
	}
	
	/**
	 * Testing the Link constructor throws an LinkIncorrectValuesException when the survival rate
	 * is greater than 1.
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataType 
	 * @throws NullInputException 
	 */
	@Test(expected = ConstraintViolatedException.class)
	public void testLinkIncorrectValuesExceptionSurvivalGreaterThan1() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Link link = new Link("john", "200", "1.1", "0", "1",TestLink.list_of_reserves);
	}
	
	/**
	 * Testing the Link constructor throws an LinkCannotFindReserveException when reserve1
	 * does not exist.
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataType 
	 * @throws NullInputException 
	 */
	@Test(expected = ConstraintViolatedException.class)
	public void testLinkReserve1NotFound() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Link link = new Link("john", "200", "0.9", "100", "1",TestLink.list_of_reserves);
	}

	/**
	 * Testing the Link constructor throws an LinkCannotFindReserveException when reserve2
	 * does not exist.
	 * @throws ConstraintViolatedException 
	 * @throws IncorrectDataType 
	 * @throws NullInputException 
	 */
	@Test(expected = ConstraintViolatedException.class)
	public void testLinkReserve2NotFound() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Link link = new Link("john", "200", "0.9", "12332", "2332",TestLink.list_of_reserves);
	}
	
	@Test
	public void testLinkIDCreate()
	{
		try
		{
			Link link = new Link("2000","bob", "200", "0.9", "0", "1",list_of_reserves);
			assertEquals(2000, link.getId());
		}
		catch (Exception e)
		{
			fail("Failed to create valid Link");
		}
	}
}
