package uo.asw.repositories;

import org.springframework.data.repository.CrudRepository;

import uo.asw.dbManagement.model.Citizen;

public interface AgentsRepository extends CrudRepository<Citizen, Long> {
}