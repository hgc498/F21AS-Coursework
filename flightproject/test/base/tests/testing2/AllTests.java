package testing2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AirportTested.class, getCodeTest.class, getLatitudeTest.class, getLongitudeTest.class,
		getNameTest.class })
public class AllTests {

}
