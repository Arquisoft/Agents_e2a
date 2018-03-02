package uo.asw.agents.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uo.asw.agents.GetAgent;
import uo.asw.agents.controller.AgentController;
import uo.asw.agents.util.AgentMin;

import java.util.Map;

@RestController
public class AgentControllerImpl implements AgentController {

	@Autowired
	private GetAgent getAgent;

	@Override
	@RequestMapping(value = "/info", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AgentMin> getAgent(@RequestBody Map<String, Object> payload) {
		String login = (String) payload.get("login");
		String password = (String) payload.get("password");
		String kind = (String) payload.get("kind");
		AgentMin c = getAgent.getAgentsInfo(login, password, kind);
		if (c == null) {
			return new ResponseEntity<AgentMin>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AgentMin>(c, HttpStatus.OK);
	}
}
