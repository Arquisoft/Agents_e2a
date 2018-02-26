package uo.asw.agents.util;

import uo.asw.dbmanagement.model.Location;

public class AgentMin {

	private Long id;
	private String name;
	private String surname;
	private String email;
	private String kind;
	private Long kindCode;
	private Location location;

	public AgentMin(String name, String surname, Long id, String email, String kind, Long kindCode) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.email = email;
		this.kind = kind;
		this.kindCode = kindCode;
	}

	public AgentMin(String name, String surname, Long id, String email, String kind, Long kindCode,
			Location location) {
		this(name, surname, id, email, kind, kindCode);
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Long getKindCode() {
		return kindCode;
	}

	public void setKindCode(Long kindCode) {
		this.kindCode = kindCode;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CitizenMin [firstName=" + name + ", id=" + id + ", email=" + email + "]";
	}

}
