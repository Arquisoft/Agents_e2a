package uo.asw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import uo.asw.entities.Agent;
import uo.asw.repositories.AgentsRepository;

@Service
public class AgentsService {

	@Autowired
	private AgentsRepository agentsRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Agent findAgent(String usuario, String password, String kind) {
		System.err.println(bCryptPasswordEncoder.encode(password));
		return agentsRepository.findAgent(usuario, bCryptPasswordEncoder.encode(password), kind);
	}

	public void addAgent(Agent agent) {
		agentsRepository.save(agent);
	}
	
	public void eliminar(Agent agent) {
		agentsRepository.delete(agent);
	}
}