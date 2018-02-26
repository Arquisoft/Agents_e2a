package uo.asw.agents;

import uo.asw.agents.util.AgentMin;
import uo.asw.dbmanagement.model.Agent;

/**
 * Servicio de agentes
 * 
 * @since 0.0.1
 */
public interface AgentsService {
	AgentMin getAgentsInfo(String login, String password, String kind);

	Agent changeInfo(Agent updatedData);
}