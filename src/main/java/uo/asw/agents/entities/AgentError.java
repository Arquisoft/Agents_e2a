package uo.asw.agents.entities;

public class AgentError implements AgentInterface {

	private String status;
	private String error;

	public AgentError(String status, String error) {
		this.setStatus(status);
		this.setError(error);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}