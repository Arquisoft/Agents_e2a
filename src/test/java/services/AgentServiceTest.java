package services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uo.asw.Application;
import uo.asw.entities.Agent;
import uo.asw.service.AgentsService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AgentServiceTest {
	
	@Autowired
	private AgentsService agentsService;

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
		agent.setPassword(password);
		agent.setKind(kind);
		agent.setKindCode(kindcode);
		agent.setDni(dni);
		agent.setNombre(nombre);
		agent.setApellidos(apellidos);
		agent.setEmail(email);
		
		agentsService.addAgent(agent);
		Agent a = agentsService.findAgent(nombreUsuario, password, kind);
		assertNotNull(a);
		assertTrue(agent.getDni().equals(a.getDni()));
		agentsService.eliminar(agent);
		assertNull(agentsService.findAgent(nombreUsuario, password, kind));
		
	}

}
