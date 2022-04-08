package testing3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ getCodeTest.class, getDestinationTest.class, getPlanCodeTest.class })
public class AllTests {

}
