package rhinova.metapopulation.model.components.reserve;


import static org.junit.Assert.*;

import org.junit.Test;

import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;
import rhinova.framework.entity.tableable.exceptions.NullInputException;
import rhinova.metapopulation.model.components.reserve.Reserve;
import rhinova.metapopulation.model.components.reserve.exceptions.*;


public class TestReserve {

	private static String[] headings = {"id","name", "x position", "y position", "min population", "max population", "current population", "regeneration rate"};
	
	/*
	 * Testing the creation of a valid <code>Reserve<code> with only Strings as inputs
	 */
	@Test
	public void testReserve() {
		try
		{
			@SuppressWarnings("unused")
			Reserve reserve = 
			new Reserve("100",
					"chicken",
					"323",
					"233",
					"1000",
					"0",
					"50000",
					"0.3");
		}
		catch (Exception e)
		{
			fail("Failed to create valid Reserve!!");
		}
	}

	/*
	 * Testing the throwing of the null input exception
	 */
	@Test(expected = NullInputException.class)
	public void testNullReserveNullInputException() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Reserve reserve =
		new Reserve("",
				"chicken",
				"323",
				"233",
				"1000",
				"0",
				"50000",
				"0.3");
	}

	/*
	 * Test the throwing of <code> IncorrectDataTypesInputException </code>
	 */
	@Test(expected = IncorrectDataType.class)
	public void testIncorrectDataTypesInputException() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Reserve reserve = 
		new Reserve("100",
				"chicken",
				"adsf",
				"233",
				"1000",
				"0",
				"50000",
				"0.3");
	}

	/*
	 * Test the throwing of ReservePopulationInputError
	 */
	@Test(expected=ConstraintViolatedException.class)
	public void testReservePopulationInputError() throws NullInputException, IncorrectDataType, ConstraintViolatedException
	{
		@SuppressWarnings("unused")
		Reserve reserve = 
		new Reserve("100",
				"chicken",
				"323",
				"233",
				"-4",
				"0",
				"50000",
				"0.3");
	}

	/*
	 * Test the setting and creating of ids
	 */
	@Test
	public void testSetIdint()
	{
		try
		{
			Reserve res1 = 
					new Reserve("299",
							"chicken",
							"323",
							"233",
							"1000",
							"0",
							"504000",
							"0.3");

			Reserve res2 = 
					new Reserve("299",
							"Smisth",
							"2322",
							"443",
							"1000",
							"0",
							"50040",
							"0.3");

			System.out.println(res1.getId());
			System.out.println(res2.getId());

			assertEquals("failed to set id correctly!", res2.getId(), 300);
		}
		catch(Exception e)
		{
			fail();
		}
	}

	/*
	 * Testing that the give population throws the correct exception if
	 * more population withdrawn than there is available
	 */
	@Test(expected=ReserveInsufficientPopulationException.class)
	public void testTakeTooMuchPopulation() throws NullInputException, IncorrectDataType, ConstraintViolatedException, ReserveInsufficientPopulationException
	{
		double population = 1000;

		Reserve reserve = 
				new Reserve("100",
						"chicken",
						"323",
						"233",
						population+"",
						"0",
						"50000",
						"0.3");

		double population_to_take = population + 1;

		@SuppressWarnings("unused")
		double taken_population = reserve.givePopulation(population_to_take);

	}


	/*
	 * Testing that the take population method throws an exception when too much population is taken
	 * from a <code> Reserve </code>
	 */
	@Test(expected=ReserveCapacityExceededException.class)
	public void testAcceptPopulation() throws IncorrectDataType, NullInputException, ConstraintViolatedException, ReserveCapacityExceededException
	{

		String current_population = "100";
		String max_population = "120";
		String regeneration_rate = "0.19";
		double population_to_take = 10;

		Reserve reserve = new Reserve("smith",
				"23",
				"323",
				current_population,
				"0",
				max_population,
				regeneration_rate);

		reserve.acceptPopulation(population_to_take);
		fail("The line above should throw an exception");
		try
		{
			reserve.regenerate();
			fail("Should not be able to regenerate");
		}
		catch(Exception e)
		{

		}
	}

	/*
	 * Test the regenerate function
	 */
	@Test
	public void testRegenerate() throws IncorrectDataType, NullInputException, ConstraintViolatedException
	{
		double current_population = 100;
		double regeneration_rate = 0.1;

		Reserve reserve = new Reserve("smith",
				"23",
				"323",
				current_population+"",
				"0",
				"10000",
				regeneration_rate+"");

		try
		{
			reserve.regenerate();
			assertEquals(reserve.getCurrentPopulation(), (1+regeneration_rate)*current_population, 0);
		} catch (FatalPopulationConstraintExceededException e) {
			fail("Failed to legitimately regenerate");
		}
	}

	/*
	 * Testing that a <code> Reserve </code> cannot regenerate past its carrying capacity
	 */
	@Test(expected=FatalPopulationConstraintExceededException.class)
	public void testRegenerateTooMuch() throws NullInputException, IncorrectDataType, ConstraintViolatedException, FatalPopulationConstraintExceededException
	{

		Reserve reserve = 
				new Reserve("100",
						"chicken",
						"323",
						"233",
						"100",
						"0",
						"100",
						"0.3");
		reserve.regenerate();
	}

	/** Test that all headings are found. */
	@Test
	public void shouldFindAllHeadingPositions() {
		
		for (int i=0; i<headings.length; i++) {
			String headingToFind = headings[i];
			assertEquals("Expected Headings to be in these positions",
					Reserve.findHeadingPosition(headingToFind),i);
		}

	}

	@Test
	public void testFindXPosition() {
		try{
			int pos = Reserve.getXHeadingPosition();
			String heading = Reserve.getHeadingStatic()[pos];
			assertEquals("Both heading values should be the same", headings[pos], heading);
		} catch(Exception e) {
			fail("No exception should be thrown when searching for the heading");
		}
	}

	@Test
	public void testFindYPosition() {
		try{
			int pos = Reserve.getYHeadingPosition();
			String heading = Reserve.getHeadingStatic()[pos];
			assertEquals("Both heading values should be the same", headings[pos], heading);
		} catch(Exception e) {
			fail("No exception should be thrown when searching for the heading");
		}
	}


}



