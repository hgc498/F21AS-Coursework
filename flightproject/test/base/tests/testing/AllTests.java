package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AirlineTested.class, getCodeTest.class, getNameTest.class })
public class AllTests {

}
