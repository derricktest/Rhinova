package rhinova.metapopulation.model.components.link;

import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;
import rhinova.framework.entity.tableable.exceptions.NullInputException;
import rhinova.metapopulation.model.components.reserve.Reserve;
import rhinova.metapopulation.model.components.reserve.ReserveList;
import static org.junit.Assert.*;


public class TestLinkList {

	
	
	public void testCreateCapacities() {
		try {
			Reserve res1 = new Reserve(
					"res1",
					"0",
					"0",
					"200.0",
					"0.2",
					"100",
					"0.3");
			
			Reserve res2 = new Reserve(
					"res1",
					"0",
					"0",
					"200.0",
					"0.2",
					"100",
					"0.3");
			
			ReserveList list = new ReserveList();
			list.add(res1);
			list.add(res2);
			
//			Link link = new Link(
//					"Smith",
//					"200",
//					stringSurvivalRate,
//					stringReserveNo1,
//					stringReserveNo2,
//					reservesList)
			
		} catch (IncorrectDataType | NullInputException | ConstraintViolatedException e) {
				fail("Need to be able to create Reserves");
			e.printStackTrace();
		}
	}
	
	
//	@Test
//	public void testSetReservesList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLinkListListOfLink() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLinkList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLinkReservesToAllLinks() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLinkReserveAtLink() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCreateAndAddNewLink() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAllObjects() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSave() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCreateNewInstance() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCreateTableable() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRemoveLinksWhichHaveReserveNo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetHeading() {
//		fail("Not yet implemented");
//	}

}
