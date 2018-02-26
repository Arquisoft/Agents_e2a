package uo.asw.dbmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private double latitud;

	@NotNull
	private double longitud;

	@OneToOne
	private Agent agent;

	Location() {
	}

	public Location(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public Long getId() {
		return id;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agent == null) ? 0 : agent.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (agent == null) {
			if (other.agent != null)
				return false;
		} else if (!agent.equals(other.agent))
			return false;
		return !(Double.doubleToLongBits(latitud) != Double.doubleToLongBits(other.latitud)
				|| (Double.doubleToLongBits(longitud) != Double.doubleToLongBits(other.longitud)));
	}

	@Override
	public String toString() {
		return "Location [latitud=" + latitud + ", longitud=" + longitud + ", citizen=" + agent + "]";
	}
}