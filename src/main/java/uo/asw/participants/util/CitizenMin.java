package uo.asw.participants.util;

import java.util.Date;

public class CitizenMin {

	private String firstName;
	private String lastName;
	private int edad;
	private Long id;
	private String email;
	
	
	
	public CitizenMin(String firstName, String lastName, Date fechaNacimiento, Long id,
			String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.edad = DateUtil.getYears(fechaNacimiento);
		this.id = id;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
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
		return "CitizenMin [firstName=" + firstName + ", lastName=" + lastName
				+ ", edad=" + edad + ", id=" + id + ", email=" + email + "]";
	}
	
	
	
	
	
	
	
}
