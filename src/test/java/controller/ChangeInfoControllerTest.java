package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.asw.agents.controller.ChangeInfoController;

public class ChangeInfoControllerTest {

	@Test
	public void test1() {
		ChangeInfoController c = new ChangeInfoController();
		assertEquals("changeInfo", c.changeInfo());
	}
	
	@Test
	public void test2() {
		ChangeInfoController c = new ChangeInfoController();
		c.setAgente(null);
		assertEquals("error", c.changePassword("", "", null));
	}
}
