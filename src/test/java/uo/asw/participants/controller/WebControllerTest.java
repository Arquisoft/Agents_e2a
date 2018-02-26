package uo.asw.participants.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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
import uo.asw.dbmanagement.model.Agent;
import uo.asw.dbmanagement.AgentDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class WebControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Autowired
	private AgentDAO citizenDAO;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	// usuario y contraseña correctos
	public void showInfoTest1() {

		try {
			mockMvc.perform(post("/info").param("login", "juan").param("password", "1234").param("kind", "Person"))
					.andExpect(status().isOk()).andExpect(model().attributeExists("resultado"))
					.andExpect(view().name("view"));
		} catch (Exception e) {
			fail("Los test no se han ejecutado correctamente");
			e.printStackTrace();
		}

	}

	@Test
	// usuario incorrecto
	public void showInfoTest2() {

		try {
			mockMvc.perform(post("/info").param("login", "usuario").param("password", "1234").param("kind", "Person"))
					.andExpect(view().name("error"));
		} catch (Exception e) {
			fail("Los test no se han ejecutado correctamente");
			e.printStackTrace();
		}

	}

	@Test
	// contraseña incorrecta
	public void showInfoTest3() {

		try {
			mockMvc.perform(post("/info").param("login", "juan").param("password", "password").param("kind", "Person"))
					.andExpect(view().name("error"));
		} catch (Exception e) {
			fail("Los test no se han ejecutado correctamente");
			e.printStackTrace();
		}

	}

	@Test
	// usuario y contraseña vacios
	public void showInfoTest4() {

		try {
			mockMvc.perform(post("/info").param("login", "").param("password", "").param("kind", "Person"))
					.andExpect(view().name("error"));
		} catch (Exception e) {
			fail("Los test no se han ejecutado correctamente");
			e.printStackTrace();
		}

	}

	@Test
	public void showViewTest() {
		try {
			mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("log"));
		} catch (Exception e) {
			fail("Los test no se han ejecutado correctamente");
			e.printStackTrace();
		}
	}

	@Test
	public void changePasswordTest1() {

		Agent c = citizenDAO.getAgent("juan", "1234", "Person");

		// Cambio de contraseña
		try {
			mockMvc.perform(
					post("/changeInfo").param("password", "1234").param("newPassword", "new").sessionAttr("agent", c))
					.andExpect(status().isOk()).andExpect(view().name("view"));
			getClass();

			// Cambio de contraseña de nuevo por la original
			mockMvc.perform(
					post("/changeInfo").param("password", "new").param("newPassword", "1234").sessionAttr("agent", c))
					.andExpect(status().isOk()).andExpect(view().name("view"));
		} catch (Exception e) {
			fail("Los test no se han ejecutado correctamente");
			e.printStackTrace();
		}
	}

	@Test
	// Contraseña incorrecta
	public void changePasswordTest2() {

		Agent c = citizenDAO.getAgent("juan", "1234", "Person");

		try {
			mockMvc.perform(post("/changeInfo").param("password", "password").param("newPassword", "new")
					.sessionAttr("agent", c)).andExpect(view().name("errorContrasena"));
		} catch (Exception e) {
			fail("Los test no se han ejecutado correctamente");
			e.printStackTrace();
		}
	}

	@Test
	public void changeEmailTest1() throws Exception {

		Agent c = citizenDAO.getAgent("juan", "1234", "Person");

		// Cambio de email
		mockMvc.perform(post("/changeEmail").param("email", "juanNuevo@gmail.com").sessionAttr("agent", c))
				.andExpect(status().isOk()).andExpect(view().name("view"));

		assertEquals("juanNuevo@gmail.com", c.getEmail());

		// Cambio de email de nuevo por el original
		mockMvc.perform(post("/changeEmail").param("email", "juan@gmail.com").sessionAttr("agent", c))
				.andExpect(status().isOk()).andExpect(view().name("view"));

		assertEquals("juan@gmail.com", c.getEmail());

	}

	@Test
	public void changeEmailTest2() throws Exception {

		Agent c = citizenDAO.getAgent("juan", "1234", "Person");

		// Cambio de email
		mockMvc.perform(post("/changeEmail").param("email", "juanNuevogmailcom").sessionAttr("agent", c))
				.andExpect(status().isOk()).andExpect(
						model().attribute("resultado", "El email no es valido, no actualizado a: juanNuevogmailcom"));

		assertEquals("juan@gmail.com", c.getEmail()); // El email sigue siendo el antiguo

	}

	@Test
	public void changeInfoTest() {
		try {
			Agent c = citizenDAO.getAgent("juan", "1234", "Person");
			mockMvc.perform(get("/changeInfo").sessionAttr("agent", c)).andExpect(view().name("changeInfo"));
		} catch (Exception e) {
			fail("Los test no se han ejecutado correctamente");
			e.printStackTrace();
		}
	}
}