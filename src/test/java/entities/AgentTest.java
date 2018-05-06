package entities;

import static org.junit.Assert.*;
import org.junit.Test;

import uo.asw.agents.entities.Agent;


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
	
	@Test
	public void test2() {
		Agent a = new Agent ("Usuario");
		assertEquals("Usuario", a.getUsername());
		assertNull(a.getId());
		assertNull(a.getPassword());
		assertNull(a.getKind());
		assertNull(a.getKindCode());
		assertNull(a.getDni());
		assertNull(a.getNombre());
		assertNull(a.getApellidos());
		assertNull(a.getEmail());
	}
	
	@Test
	public void test3 () {
		Agent a = new Agent ("Usuario", "Password");
		assertEquals("Usuario", a.getUsername());
		assertNull(a.getId());
		assertEquals("Password", a.getPassword());
		assertNull(a.getKind());
		assertNull(a.getKindCode());
		assertNull(a.getDni());
		assertNull(a.getNombre());
		assertNull(a.getApellidos());
		assertNull(a.getEmail());
	}
	
	@Test
	public void test4 () {
		Agent a = new Agent ("Usuario", "Password", "Kind");
		assertEquals("Usuario", a.getUsername());
		assertNull(a.getId());
		assertEquals("Password", a.getPassword());
		assertEquals("Kind", a.getKind());
		assertNull(a.getKindCode());
		assertNull(a.getDni());
		assertNull(a.getNombre());
		assertNull(a.getApellidos());
		assertNull(a.getEmail());
	}
	
	@Test
	public void test5 () {
		Long k = 1l;
		Agent a = new Agent ("Password", "Usuario", "Kind", k, "dni", "nombre", "apellidos", "email");
		assertEquals("Usuario", a.getUsername());
		assertNull(a.getId());
		assertEquals("Password", a.getPassword());
		assertEquals("Kind", a.getKind());
		assertEquals(k ,a.getKindCode());
		assertEquals("dni", a.getDni());
		assertEquals("nombre", a.getNombre());
		assertEquals("apellidos", a.getApellidos());
		assertEquals("email", a.getEmail());
	}

}
