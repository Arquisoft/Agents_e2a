package entities;

import static org.junit.Assert.*;
import org.junit.Test;

import uo.asw.entities.Agent;


public class AgentTest {

	@Test
	public void test() {
		
		Agent agent = new Agent();
		
		Long id = 2L;
		
		String nombreUsuario = "pepe";
		String password = "123";
		String kind = "Entity";
		
		Long kindcode = 1L;
		String dni = "12345678P";
		String nombre = "Pelayo";
		String apellidos = "García";
		String email = "pelayo@uniovi.es";
		
		agent.setId(id);
		agent.setUsername(nombreUsuario);
		agent.setPassword(password);
		agent.setKind(kind);
		agent.setKindCode(kindcode);
		agent.setDni(dni);
		agent.setNombre(nombre);
		agent.setApellidos(apellidos);
		agent.setEmail(email);
		
		assertEquals(id, agent.getId());
		assertEquals(nombreUsuario, agent.getUsername());
		assertEquals(password, agent.getPassword());
		assertEquals(kind, agent.getKind());
		assertEquals(kindcode, agent.getKindCode());
		assertEquals(dni, agent.getDni());
		assertEquals(nombre, agent.getNombre());
		assertEquals(apellidos, agent.getApellidos());
		assertEquals(email, agent.getEmail());
		
		assertEquals("Agent [nombreUsuario=" + nombreUsuario + ", password=" + password + ", kind=" + kind + ", kindCode="
				+ kindcode + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ "]", agent.toString());
	}

}
