package uo.asw.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private double latitud;

	@NotNull
	private double longitud;

	@OneToOne (cascade = {CascadeType.ALL})
	private Incidencia incidencia;

	public Location() {
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
	
	public Incidencia getIncidencia() {
		return incidencia;
	}

	public Location setIncidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
		return this;
	}
	
	@Override
	public String toString() {
		return latitud + "$" + longitud;
	}
}