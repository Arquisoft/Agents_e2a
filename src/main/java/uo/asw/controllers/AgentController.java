package uo.asw.controllers;

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

import uo.asw.entities.Agent;
import uo.asw.entities.AgentError;
import uo.asw.entities.AgentInterface;
import uo.asw.service.AgentsService;

@Controller
public class AgentController {

	@Autowired
	private AgentsService agentsService;
	private Agent agente;

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
		agente = agentsService.findAgent(login, password, kind);
		if (agente != null) {
			session.setAttribute("agent", agente);
			return "view";
		}
		return "error";
	}

	@RequestMapping(value = { "/", "/portal" }, method = RequestMethod.GET)
	public String showView(Model model) {
		if (agente == null)
			return "log";
		return "view";
	}

	@RequestMapping(value = { "/logout" })
	public String showView() {
		agente = null;
		return "log";
	}

	/**
	 * Acceso a la página que modifica los datos del usuario
	 * 
	 * @return changeInfo html para modificar datos del usuario
	 */
	@RequestMapping(value = "/changeInfo", method = RequestMethod.GET)
	public String changeInfo() {
		return "changeInfo";
	}
	
	/**
	 * Cambia la contrasena de un usuario, siempre que e usuario este en sesion, la
	 * contrasena antigua se igual que la contrasena de parametro y la nueva
	 * contrasena no sea vacia
	 * 
	 * @param session
	 *            scope
	 * @param password
	 *            contrasena antigua
	 * @param newPassword
	 *            contrasena nueva
	 * @param model
	 * @return pagina siguiente
	 */
	@RequestMapping(value = "/changeInfo", method = RequestMethod.POST)
	public String changePassword(@RequestParam String password, @RequestParam String newPassword,
			Model model) {
		if (agente != null) {
			if (agente.getPassword().equals(agentsService.encripta(agente.getUsername(), password, agente.getKind())) && !newPassword.isEmpty()) {
				agente.setPassword(agentsService.encripta(agente.getUsername(), newPassword, agente.getKind()));
				agentsService.addAgent(agente);
				return "ok";
			}
		}
		return "error";
	}
}