package uo.asw.agents.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import uo.asw.agents.entities.Agent;
import uo.asw.agents.entities.AgentError;
import uo.asw.agents.entities.AgentInterface;
import uo.asw.agents.service.AgentsService;

@Controller
public class AgentController extends AbstractController {

	@Autowired
	private AgentsService agentsService;
	

	@RequestMapping(value = "/info", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AgentInterface> showInfo(@RequestBody Map<String, Object> payload) {
		String login = (String) payload.get("login");
		String password = (String) payload.get("password");
		String kind = (String) payload.get("kind");
		AgentError e;
		if (payload.get("login") == null || payload.get("password") == null || payload.get("kind") == null) {
			e = new AgentError("406", "Los parámetros no son correctos");
			return new ResponseEntity<AgentInterface>(e, HttpStatus.NOT_ACCEPTABLE);
		}
		Agent a = agentsService.findAgent(login, password, kind);
		e = new AgentError("404", "Usuario no encontrado");
		if (a != null)
			return new ResponseEntity<AgentInterface>(a, HttpStatus.OK);
		else
			return new ResponseEntity<AgentInterface>(e, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String showInfo(HttpSession session, @RequestParam String login, @RequestParam String password,
			@RequestParam String kind, Model model) throws Exception {
		setAgente(agentsService.findAgent(login, password, kind));
		if (getAgente() != null) {
			session.setAttribute("agent", getAgente());
			return "view";
		}
		return "error";
	}

	@RequestMapping(value = { "/", "/portal" }, method = RequestMethod.GET)
	public String showView(Model model) {
		if (getAgente() == null)
			return "log";
		return "view";
	}

	@RequestMapping(value = { "/logout" })
	public String showView() {
		setAgente(null);
		return "log";
	}
}