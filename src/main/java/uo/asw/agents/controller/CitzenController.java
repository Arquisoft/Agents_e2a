package uo.asw.agents.controller;

import org.springframework.http.ResponseEntity;

import uo.asw.agents.util.CitizenMin;

import java.util.Map;


public interface CitzenController {

	public ResponseEntity<CitizenMin> getCitzen(Map<String, Object> payload);
}
