package uo.asw.participants.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import uo.asw.Application;
import uo.asw.dbManagement.CitizenDAO;
import uo.asw.dbManagement.model.Citizen;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class WebControllerTest {

    @Autowired
    private WebApplicationContext wac;
 
    private MockMvc mockMvc;
    
    @Autowired
    private CitizenDAO citizenDAO;
     
    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
    @Test
	 //usuario y contraseña correctos
    public void showInfoTest1() throws Exception {

      mockMvc.perform(post("/info")
		.param("user", "juan")
		.param("password", "1234"))
      	.andExpect(status().isOk())
      	.andExpect(model().attributeExists("resultado"))
      	.andExpect(view().name("view"));
    	
    }

    
    @Test
    //usuario incorrecto
    public void showInfoTest2() throws Exception {
    	
        mockMvc.perform(post("/info")
    	.param("user", "usuario")
		.param("password", "1234"))
     	.andExpect(view().name("error"));

    }
    
    @Test
    //contraseña incorrecta
    public void showInfoTest3() throws Exception {

       	mockMvc.perform(post("/info")
    	.param("user", "juan")
		.param("password", "password"))
     	.andExpect(view().name("error"));
   
    }
    
    @Test
    //usuario y contraseña vacios
    public void showInfoTest4() throws Exception {

       	mockMvc.perform(post("/info")
    	.param("user", "")
		.param("password", ""))
        .andExpect(view().name("error"));
   
    }
    
   @Test
   public void showViewTest() throws Exception {
       mockMvc.perform(get("/"))
           .andExpect(status().isOk())
           .andExpect(view().name("log"));
   }
    
   
   @Test
   public void changePasswordTest1() throws Exception {
   	
	   Citizen c = citizenDAO.getParticipant("juan", "1234");

	   //Cambio de contraseña
       mockMvc.perform(post("/changeInfo")
    	.param("password", "1234")
		.param("newPassword", "new")
		.sessionAttr("citizen", c))
        .andExpect(status().isOk())
    	.andExpect(view().name("view"));

	   //Cambio de contraseña de nuevo por la original
       mockMvc.perform(post("/changeInfo")
    	.param("password", "new")
		.param("newPassword", "1234")
		.sessionAttr("citizen", c))
        .andExpect(status().isOk())
     	.andExpect(view().name("view"));
       
   }
   
   @Test
   //Contraseña incorrecta
   public void changePasswordTest2() throws Exception {
   	
	   Citizen c = citizenDAO.getParticipant("juan", "1234");

       mockMvc.perform(post("/changeInfo")
    	.param("password", "password")
		.param("newPassword", "new")
		.sessionAttr("citizen", c))
    	.andExpect(view().name("errorContrasena"));
       
   }
   
   @Test
   public void changeEmailTest1() throws Exception {
   	
	   Citizen c = citizenDAO.getParticipant("juan", "1234");

	   //Cambio de email
       mockMvc.perform(post("/changeEmail")
    	.param("email", "juanNuevo@gmail.com")
		.sessionAttr("citizen", c))
        .andExpect(status().isOk())
    	.andExpect(view().name("view"));

       assertEquals("juanNuevo@gmail.com", c.getEmail());
       
	   //Cambio de email de nuevo por el original
       mockMvc.perform(post("/changeEmail")
    	.param("email", "juan@gmail.com")
		.sessionAttr("citizen", c))
        .andExpect(status().isOk())
     	.andExpect(view().name("view"));
       
       assertEquals("juan@gmail.com", c.getEmail());

   }
}
