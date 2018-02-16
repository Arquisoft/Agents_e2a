package uo.asw.agents.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.agents.AgentsService;
import uo.asw.agents.util.AgentMin;
import uo.asw.dbManagement.CitizenDAO;
import uo.asw.dbManagement.model.Agent;

@Service
public class AgentsServiceImpl implements AgentsService {
    @Autowired
    private CitizenDAO citizenDAO;

    @Override
    public AgentMin getAgentsInfo(String login, String password, String kind) {
       Agent c = citizenDAO.getAgent(login, password, kind);
       if(c != null){
    	   return new AgentMin(c.getNombre(), c.getApellidos(),  c.getId(), c.getEmail(), c.getKind(), c.getKindCode());
       }
       return null;
    }

    @Override
    public Agent changeInfo(Agent updatedData) {
        return citizenDAO.updateInfo(updatedData);
    }
}