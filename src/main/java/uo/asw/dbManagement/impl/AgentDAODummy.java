package uo.asw.dbManagement.impl;

import org.springframework.stereotype.Repository;

import uo.asw.dbManagement.AgentDAO;
import uo.asw.dbManagement.model.Agent;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @since 0.0.1
 */
@Repository
@Transactional
public class AgentDAODummy implements AgentDAO {
	private static Agent dummyAgent;

	@PersistenceContext
	private EntityManager entityManager;

	static {
		dummyAgent = new Agent("pass", "dummy", "Person", 1, "123456", "Clara", "Oswald", "clara@tardis.co.uk");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Agent getAgent(String login, String password, String kind) {
		List<Agent> agent = entityManager
				.createQuery("from Agent where nombreUsuario = ?1 and contraseña = ?2 and kind = ?3")
				.setParameter(1, login).setParameter(2, password).setParameter(3, kind).getResultList();
		if (agent.isEmpty())
			return null;
		return agent.get(0);
	}

	@Override
	public Agent updateInfo(Agent toUpdate) {
		entityManager.merge(toUpdate);
		dummyAgent = toUpdate;
		return dummyAgent;
	}
}