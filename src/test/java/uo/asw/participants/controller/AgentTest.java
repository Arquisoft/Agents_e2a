package uo.asw.participants.controller;

import static org.junit.Assert.*;

import java.text.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import uo.asw.Application;
import uo.asw.dbManagement.model.Agent;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class AgentTest {
	
    private Agent citizen;

	@Test
	public void newCitizenTest() throws ParseException {
    	citizen = new Agent("1234", "juanTorre", "Person", 1, "12345678J", "Juan Antonio", "Vázquez", "juan@gmail.com");
		Agent citizen2 = new Agent("5678", "juanTorre", "Person", 1, "87654321Z", "Pedro", "Pedro", "pedro@gmail.com");
		assertTrue(citizen != null);
		assertTrue(citizen.equals(citizen2));
		assertEquals(citizen.hashCode(), citizen2.hashCode());

		assertEquals("1234", citizen.getContraseña());
		assertEquals("juanTorre", citizen.getNombreUsuario());
		assertEquals("12345678J", citizen.getDni());
		assertEquals("Juan Antonio", citizen.getNombre());
		assertEquals("Vázquez", citizen.getApellidos());
		assertEquals("juan@gmail.com", citizen.getEmail());
		
		citizen.setNombreUsuario("juantorre2");
		assertEquals("juantorre2", citizen.getNombreUsuario());
		citizen.setNombre("Juan");
		assertEquals("Juan", citizen.getNombre());
		citizen.setApellidos("Velázquez");
		assertEquals("Velázquez", citizen.getApellidos());
		citizen.setKind("Entity");
		assertEquals("Entity", citizen.getKind());
		citizen.setKindCode((long) 2);
		assertEquals(new Long(2), citizen.getKindCode());
	}
	
	

}