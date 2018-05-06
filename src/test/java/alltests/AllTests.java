package alltests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import controller.AgentControllerTest;
import controller.ChangeInfoControllerTest;
import entities.AgentErrorTest;
import entities.AgentTest;
import junit.framework.JUnit4TestAdapter;
import services.AgentServiceTest;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@SuiteClasses({ AgentControllerTest.class, ChangeInfoControllerTest.class, AgentErrorTest.class, AgentTest.class,
		AgentServiceTest.class })
public class AllTests {
	public static JUnit4TestAdapter suite() {
		return new JUnit4TestAdapter(AllTests.class);
	}
}