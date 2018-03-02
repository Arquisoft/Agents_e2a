package uo.asw.agents;

import uo.asw.agents.util.AgentMin;

public interface GetAgent {
	
	AgentMin getAgentsInfo(String login, String password, String kind);

}
