package testing4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ getConsumptionTest.class, getManufacturerTest.class, getModelTest.class })
public class AllTests {

}
