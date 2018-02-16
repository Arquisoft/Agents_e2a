package uo.asw.agents.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.agents.AgentsService;
import uo.asw.agents.util.CitizenMin;
import uo.asw.dbManagement.CitizenDAO;
import uo.asw.dbManagement.model.Citizen;

/**
 * Created by Irazusta on 15/02/2017.
 */
@Service
public class AgentsServiceImpl implements AgentsService {
    @Autowired
    private CitizenDAO citizenDAO;

    @Override
    public CitizenMin getAgentsInfo(String login, String password, String kind) {
       Citizen c = citizenDAO.getAgent(login, password, kind);
       if(c != null){
    	   return new CitizenMin(c.getNombre(), c.getApellidos(),  c.getId(), c.getEmail());
       }
       return null;
    }

    @Override
    public Citizen changeInfo(Citizen updatedData) {
        return citizenDAO.updateInfo(updatedData);
    }
}
