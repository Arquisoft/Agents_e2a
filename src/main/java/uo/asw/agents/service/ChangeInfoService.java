package uo.asw.agents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.agents.entities.Agent;
import uo.asw.repository.AgentsRepository;

@Service
public class ChangeInfoService extends AbstractService {
	
	@Autowired
	private AgentsRepository agentsRepository;

	public void updateAgent(Agent agent) {
		agentsRepository.save(agent);
	}

	public void eliminar(Agent agent) {
		agentsRepository.delete(agent);
	}
}