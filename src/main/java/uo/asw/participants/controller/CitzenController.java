package uo.asw.participants.controller;

import org.springframework.http.ResponseEntity;

import uo.asw.participants.util.CitizenMin;

import java.util.Map;


public interface CitzenController {

	public ResponseEntity<CitizenMin> getCitzen(Map<String, Object> payload);
}
