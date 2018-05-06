package uo.asw.agents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.agents.entities.Agent;
import uo.asw.repository.AgentsRepository;

@Service
public class AgentsService {

	@Autowired
	private AgentsRepository agentsRepository;

	public Agent findAgent(String usuario, String password, String kind) {

		return agentsRepository.findAgent(usuario, encripta(usuario, password, kind), kind);
	}

	public String encripta(String usuario, String password, String kind) {
		String pass = password + kind + usuario;
		return String.valueOf(pass.hashCode());
	}

	public void addAgent(Agent agent) {
		agentsRepository.save(agent);
	}

	public void eliminar(Agent agent) {
		agentsRepository.delete(agent);
	}
}