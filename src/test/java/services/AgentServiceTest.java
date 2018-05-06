package services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uo.asw.Application;
import uo.asw.agents.entities.Agent;
import uo.asw.agents.service.AgentsService;
import uo.asw.agents.service.ChangeInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AgentServiceTest {

	@Autowired
	private AgentsService agentsService;

	@Autowired
	private ChangeInfoService changeInfoService;

	@Test
	public void test() {

		Agent agent = new Agent();

		String nombreUsuario = "usuarioDePrueba";
		String password = "123456789abcd";
		String kind = "Person";

		Long kindcode = 1L;
		String dni = "sadclknqwer82ornjfceiwojkcnq34ot8y";
		String nombre = "User";
		String apellidos = "Prueba";
		String email = "user@uniovi.es";

		agent.setUsername(nombreUsuario);
		agent.setPassword(agentsService.encripta(nombreUsuario, password, kind));
		agent.setKind(kind);
		agent.setKindCode(kindcode);
		agent.setDni(dni);
		agent.setNombre(nombre);
		agent.setApellidos(apellidos);
		agent.setEmail(email);

		changeInfoService.updateAgent(agent);
		Agent a = agentsService.findAgent(nombreUsuario, password, kind);
		assertNotNull(a);
		assertTrue(agent.getDni().equals(a.getDni()));
		changeInfoService.eliminar(agent);
		assertNull(agentsService.findAgent(nombreUsuario, password, kind));
	}
}