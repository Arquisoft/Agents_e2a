package uo.asw.participants.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	
	AgentControllerTest.class,
	DBTest.class,
	UtilTest.class,
	WebControllerTest.class,
	AgentTest.class
})
public class AllTests { }
