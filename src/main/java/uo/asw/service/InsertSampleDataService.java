package uo.asw.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.entities.Agent;

@Service
public class InsertSampleDataService {
	@Autowired
	private AgentsService agentsService;

	@PostConstruct
	public void init() {
		Agent agent1 = new Agent("juan", "1234", "Person");
		Agent agent2 = new Agent("pedro", "1234", "Entity");
		Agent agent3 = new Agent("raul", "1234", "Sensor");
		agentsService.addAgent(agent1);
		agentsService.addAgent(agent2);
		agentsService.addAgent(agent3);
	}
}