package uo.asw.agents.controller;

import uo.asw.agents.entities.Agent;

public abstract class AbstractController {
	private static Agent agente;

	public Agent getAgente() {
		return agente;
	}

	public void setAgente(Agent agente) {
		AbstractController.agente = agente;
	}
}