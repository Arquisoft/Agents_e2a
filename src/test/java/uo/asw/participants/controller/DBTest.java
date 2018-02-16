package uo.asw.participants.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import uo.asw.Application;
import uo.asw.dbManagement.CitizenDAO;
import uo.asw.dbManagement.model.Agent;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration

public class DBTest {

	
	@Autowired
    private CitizenDAO citizenDAO;
	
	@Test
    public void getExistingCitizen() throws Exception {
    	Agent c1 = citizenDAO.getAgent("juan", "1234", "Person");
    	Agent c2 = citizenDAO.getAgent("pedro", "1234", "Entity");
    	Agent c3 = citizenDAO.getAgent("raul", "1234", "Sensor");

		assertEquals("juan", c1.getNombreUsuario());
		assertEquals("1234", c1.getContraseña());
		
		assertEquals("pedro", c2.getNombreUsuario());
		assertEquals("1234", c2.getContraseña());
		
		assertEquals("raul", c3.getNombreUsuario());
		assertEquals("1234", c3.getContraseña());
    }
    
    @Test
    public void getNonExistingCitizen() throws Exception {
    	Agent c1 = citizenDAO.getAgent("antonio", "1234", "Person");
    	Agent c2 = citizenDAO.getAgent("daniel", "1234", "Person");
    	Agent c3 = citizenDAO.getAgent("rodrigo", "1234", "Person");

    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);

     }
    
    @Test
    public void wrongPasswordTest() throws Exception {
    	
    	Agent c1 = citizenDAO.getAgent("juan", "password", "Person");
    	Agent c2 = citizenDAO.getAgent("pedro", "password", "Person");
    	Agent c3 = citizenDAO.getAgent("raul", "password", "Person");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void wrongUserPasswordTest() throws Exception {
    	
    	Agent c1 = citizenDAO.getAgent("juan@gmail.com", "password", "Person");
    	Agent c2 = citizenDAO.getAgent("pedro@gmail.com", "password", "Person");
    	Agent c3 = citizenDAO.getAgent("raul@gmail.com", "password", "Person");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void updateTest() throws Exception {
    	
    	Agent c1 = citizenDAO.getAgent("juan", "1234", "Person");
    	
    	//Cambio de contraseña
    	c1.setContraseña("new password");
       	citizenDAO.updateInfo(c1);
       
       	assertEquals("new password", c1.getContraseña());
       	
       	//Cambio de contraseña por la original
       	c1.setContraseña("1234");
       	citizenDAO.updateInfo(c1);
       	
       	assertEquals("1234", c1.getContraseña());

        	
    }

}