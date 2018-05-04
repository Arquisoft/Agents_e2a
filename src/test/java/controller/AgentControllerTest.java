package controller;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uo.asw.Application;
import uo.asw.controllers.AgentController;
import uo.asw.entities.AgentError;
import uo.asw.entities.AgentInterface;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AgentControllerTest {

	@Test
	public void test1() {
		AgentController c = new AgentController();
		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put("login", "login");
		payload.put("password", "password");
		payload.put("Clave incorrecta", "kind incorrecto");
		ResponseEntity<AgentInterface> r = c.showInfo(payload);
		assertEquals(HttpStatus.BAD_REQUEST, r.getStatusCode());
		AgentError e = (AgentError) r.getBody();
		assertEquals("Los parámetros no son correctos", e.getError());
		assertEquals("406", e.getStatus());
	}
}