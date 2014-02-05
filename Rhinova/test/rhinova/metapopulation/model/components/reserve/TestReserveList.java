package rhinova.metapopulation.model.components.reserve;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;
import rhinova.framework.entity.tableable.exceptions.NullInputException;
import rhinova.metapopulation.model.components.reserve.Reserve;
import rhinova.metapopulation.model.components.reserve.ReserveList;

public class TestReserveList {

	static Reserve reserve;

	
	@Before
	public void shouldNotAllowDuplicateAdds() {
		try {
			reserve = new Reserve("100",
					"chicken",
					"323",
					"233",
					"1000",
					"0",
					"50000",
					"0.3");
			
		} catch (Exception e) {
			System.err.println("ERRORR Running test suit");
			fail("Failed to create a reserve needed in the test");
			e.printStackTrace();
		}
		assert(reserve==null);
	}


	@Test
	public void testAddDuplicate() {

		ReserveList reserveList = new ReserveList();
		reserveList.add(reserve);
		reserveList.add(reserve);
		
		assertTrue("The reserve size should be 1", reserveList.size()==1);
	}
	
	@Test
	public void shouldSortIdLowToHigh() throws NullInputException, IncorrectDataType, ConstraintViolatedException {
		
		
		Reserve reserve3 = new Reserve("100",
				"chicken",
				"323",
				"233",
				"1000",
				"0",
				"50000",
				"0.3");
		
		
		Reserve reserve1 = new Reserve("100",
				"chicken",
				"323",
				"233",
				"1000",
				"0",
				"50000",
				"0.3");
		
		
		Reserve reserve2 = new Reserve("100",
				"chicken",
				"323",
				"233",
				"1000",
				"0",
				"50000",
				"0.3");
		
		ReserveList reserveList = new ReserveList();
		
		reserveList.add(reserve1);
		reserveList.add(reserve2);
		reserveList.add(reserve3);
		
		Collections.sort(reserveList);
		
		
		assertTrue("The first Id should be less than the last",
				reserveList.get(0).getId()<reserveList.get(2).getId());
		
	}

}
