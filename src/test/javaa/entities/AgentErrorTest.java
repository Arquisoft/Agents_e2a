package entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uo.asw.entities.AgentError;

public class AgentErrorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		AgentError ae = new AgentError("STATUS", "ERROR:02");
		
		assertEquals("STATUS", ae.getStatus());
		assertEquals("ERROR:02", ae.getError());
		
		ae.setError("NUEVO ERROR");
		ae.setStatus("NUEVO STATUS");
		
		assertEquals("NUEVO STATUS", ae.getStatus());
		assertEquals("NUEVO ERROR", ae.getError());
	}

}
