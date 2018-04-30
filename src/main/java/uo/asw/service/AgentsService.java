package uo.asw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.entities.Agent;
import uo.asw.repositories.AgentsRepository;

@Service
public class AgentsService {

	@Autowired
	private AgentsRepository agentsRepository;

	public Agent findAgent(String usuario, String password, String kind) {
		return agentsRepository.findAgent(usuario, password, kind);
	}

	public void addAgent(Agent agent) {
		agentsRepository.save(agent);
	}
}