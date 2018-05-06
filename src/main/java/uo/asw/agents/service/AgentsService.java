package uo.asw.agents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.agents.entities.Agent;
import uo.asw.repository.AgentsRepository;

@Service
public class AgentsService extends AbstractService {

	@Autowired
	private AgentsRepository agentsRepository;

	public Agent findAgent(String usuario, String password, String kind) {

		return agentsRepository.findAgent(usuario, encripta(usuario, password, kind), kind);
	}
}