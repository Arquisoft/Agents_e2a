package uo.asw.repositories;

import org.springframework.data.repository.CrudRepository;

import uo.asw.dbManagement.model.Agent;

public interface AgentsRepository extends CrudRepository<Agent, Long> {
}