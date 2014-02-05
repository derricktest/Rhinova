package rhinova;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import rhinova.metapopulation.model.components.link.TestLink;
import rhinova.metapopulation.model.components.reserve.TestReserve;
import rhinova.metapopulation.model.components.reserve.TestReserveList;

@RunWith(Suite.class)
@SuiteClasses({ TestLink.class, TestReserve.class, TestReserveList.class })
public class TestsSuiteModel {

}
