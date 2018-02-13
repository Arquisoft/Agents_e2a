package uo.asw.agents;


import uo.asw.agents.util.CitizenMin;
import uo.asw.dbManagement.model.Citizen;

/**
 * Servicio de agentes
 * @since 0.0.1
 */
public interface AgentsService {
    CitizenMin getAgentsInfo(String login, String password);
    Citizen changeInfo(Citizen updatedData);
}
