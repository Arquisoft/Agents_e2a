package uo.asw.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/info", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AgentInterface> showInfo(@RequestBody Map<String, Object> payload) {
		String login = (String) payload.get("login");
		String password = (String) payload.get("password");
		String kind = (String) payload.get("kind");
		AgentError e;
		if (payload.get("login")==null || payload.get("password")==null || payload.get("kind")==null) {
			e = new AgentError ("406", "Los parámetros no son correctos");
			return new ResponseEntity<AgentInterface>(e, HttpStatus.BAD_REQUEST);
		}
		Agent a = agentsService.findAgent(login, password, kind);
		e = new AgentError ("404", "Usuario no encontrado");
		if (a != null)
			return new ResponseEntity<AgentInterface>(a, HttpStatus.OK);
		else
			return new ResponseEntity<AgentInterface>(e, HttpStatus.NOT_FOUND);
	}
}