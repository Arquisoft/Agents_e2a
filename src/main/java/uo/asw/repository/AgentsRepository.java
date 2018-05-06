package uo.asw.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import uo.asw.agents.entities.Agent;

public interface AgentsRepository extends CrudRepository<Agent, Long> {

	@Query ("SELECT a FROM Agent a where a.nombreUsuario=?1 and a.password=?2 and a.kind=?3")
	Agent findAgent(String nombreUsuario, String password, String kind);
}