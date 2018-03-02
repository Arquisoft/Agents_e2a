package uo.asw.agents.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.agents.GetAgent;
import uo.asw.agents.util.AgentMin;
import uo.asw.dbManagement.AgentDAO;
import uo.asw.dbManagement.model.Agent;

@Service
public class GetAgentImpl implements GetAgent{

	 @Autowired
	 private AgentDAO citizenDAO;
	
	@Override
	public AgentMin getAgentsInfo(String login, String password, String kind) {
		Agent c = citizenDAO.getAgent(login, password, kind);
	       if(c != null){
	    	   return new AgentMin(c.getNombre(), c.getApellidos(),  c.getId(), c.getEmail(), c.getKind(), c.getKindCode());
	       }
	       return null;
	}

}
