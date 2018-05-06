package entities;

import static org.junit.Assert.*;
import org.junit.Test;

import uo.asw.agents.entities.AgentError;

public class AgentErrorTest {

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
