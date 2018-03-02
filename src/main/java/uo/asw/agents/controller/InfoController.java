package uo.asw.agents.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;


public interface InfoController {
	
	String showInfo(HttpSession session, String login, String password,
			String kind, Model model);
	
	String changeInfo();
	
	String changePassword(HttpSession session, String password, String newPassword,
			Model model);

	String changeEmail(HttpSession session, String email, Model model);

	String showView(Model model);

}
