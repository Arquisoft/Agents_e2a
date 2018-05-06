package uo.asw.agents.service;

public class AbstractService {
	
	public String encripta(String usuario, String password, String kind) {
		String pass = password + kind + usuario;
		return String.valueOf(pass.hashCode());
	}
}
