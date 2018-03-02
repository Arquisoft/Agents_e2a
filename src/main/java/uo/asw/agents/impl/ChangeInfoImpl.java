package uo.asw.agents.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.agents.ChangeInfo;
import uo.asw.dbManagement.AgentDAO;
import uo.asw.dbManagement.model.Agent;

@Service
public class ChangeInfoImpl implements ChangeInfo{
	
	@Autowired
	 private AgentDAO citizenDAO;

	@Override
	public Agent changeInfo(Agent updatedData) {
		return citizenDAO.updateInfo(updatedData);
	}

}
