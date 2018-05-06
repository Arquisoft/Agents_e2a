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
import uo.asw.agents.controller.AgentController;
import uo.asw.agents.entities.Agent;
import uo.asw.agents.entities.AgentError;
import uo.asw.agents.entities.AgentInterface;


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
		assertEquals(HttpStatus.NOT_ACCEPTABLE, r.getStatusCode());
		AgentError e = (AgentError) r.getBody();
		assertEquals("Los parámetros no son correctos", e.getError());
		assertEquals("406", e.getStatus());
	}
	
	@Test
	public void test2() {
		AgentController c = new AgentController();
		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put("login", "login");
		payload.put("clave incorrecta", "password incorrecta");
		payload.put("kind", "kind");
		ResponseEntity<AgentInterface> r = c.showInfo(payload);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, r.getStatusCode());
		AgentError e = (AgentError) r.getBody();
		assertEquals("Los parámetros no son correctos", e.getError());
		assertEquals("406", e.getStatus());
	}
	
	@Test
	public void test3() {
		AgentController c = new AgentController();
		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put("Clave incorrecta", "login incorrecto");
		payload.put("password", "password");
		payload.put("kind", "kind");
		ResponseEntity<AgentInterface> r = c.showInfo(payload);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, r.getStatusCode());
		AgentError e = (AgentError) r.getBody();
		assertEquals("Los parámetros no son correctos", e.getError());
		assertEquals("406", e.getStatus());
	}
	
	@Test
	public void test4() {
		AgentController c = new AgentController();
		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put("Clave incorrecta", "login incorrecto");
		payload.put("Clave incorrecta 2", "password incorrecto");
		payload.put("kind", "kind");
		ResponseEntity<AgentInterface> r = c.showInfo(payload);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, r.getStatusCode());
		AgentError e = (AgentError) r.getBody();
		assertEquals("Los parámetros no son correctos", e.getError());
		assertEquals("406", e.getStatus());
	}
	
	@Test
	public void test5() {
		AgentController c = new AgentController();
		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put("Clave incorrecta", "login incorrecto");
		payload.put("password", "password");
		payload.put("Clave incorrecta 2", "kind incorrecto");
		ResponseEntity<AgentInterface> r = c.showInfo(payload);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, r.getStatusCode());
		AgentError e = (AgentError) r.getBody();
		assertEquals("Los parámetros no son correctos", e.getError());
		assertEquals("406", e.getStatus());
	}
	
	@Test
	public void test6() {
		AgentController c = new AgentController();
		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put("login", "login");
		payload.put("Clave incorrecta", "password incorrecto");
		payload.put("Clave incorrecta 2", "kind incorrecto");
		ResponseEntity<AgentInterface> r = c.showInfo(payload);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, r.getStatusCode());
		AgentError e = (AgentError) r.getBody();
		assertEquals("Los parámetros no son correctos", e.getError());
		assertEquals("406", e.getStatus());
	}
	
	@Test
	public void test7() {
		AgentController c = new AgentController();
		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put("Clave incorrecta", "login incorrecto");
		payload.put("Clave incorrecta", "password incorrecto");
		payload.put("Clave incorrecta 3", "kind incorrecto");
		ResponseEntity<AgentInterface> r = c.showInfo(payload);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, r.getStatusCode());
		AgentError e = (AgentError) r.getBody();
		assertEquals("Los parámetros no son correctos", e.getError());
		assertEquals("406", e.getStatus());
	}
	
	@Test
	public void test8() throws Exception {
		AgentController c = new AgentController();
		c.setAgente(null);
		assertEquals("log", c.showView(null));
		assertNull(c.getAgente());
		c.setAgente(new Agent());
		assertEquals("view", c.showView(null));
	}
	
	@Test
	public void test9() {
		AgentController c = new AgentController();
		assertEquals("log", c.showView());
	}
}