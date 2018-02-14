package uo.asw.participants.controller;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import uo.asw.Application;
import uo.asw.dbManagement.model.Citizen;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class CitizenTest {
	
    private Citizen citizen;
    private SimpleDateFormat sdf;
    
    @Before
    public void setUp() throws Exception {
    	sdf = new SimpleDateFormat("dd-M-yyyy");
    }

	@Test
	public void newCitizenTest() throws ParseException {
		
		String dateString1 = "10-02-1990";
		Date date1 = sdf.parse(dateString1);
		
    	citizen = new Citizen("1234", "juanTorre", "12345678J", "Juan Antonio", "Vázquez", date1, "juan@gmail.com", "33962", "España");
		
		assertTrue(citizen != null);
		
		assertEquals("1234", citizen.getContraseña());
		assertEquals("juanTorre", citizen.getNombreUsuario());
		assertEquals("12345678J", citizen.getDni());
		assertEquals("Juan Antonio", citizen.getNombre());
		assertEquals("Vázquez", citizen.getApellidos());
		assertEquals("juan@gmail.com", citizen.getEmail());
		assertEquals(date1, citizen.getFechaNacimiento());
		assertEquals("33962", citizen.getDireccionPostal());
		assertEquals("España", citizen.getNacionalidad());
	}
	
	

}
