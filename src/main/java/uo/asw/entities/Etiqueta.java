package uo.asw.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Etiqueta {

	@Id
	@GeneratedValue
	Long id;

	@ManyToOne (cascade = {CascadeType.ALL})
	private Incidencia incidencia;

	private String valor;

	public Etiqueta() {
	}

	public Incidencia getIncidencia() {
		return incidencia;
	}

	public Etiqueta setIncidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
		return this;
	}

	public String getNombre() {
		return valor;
	}

	public Etiqueta setNombre(String nombre) {
		this.valor = nombre;
		return this;
	}
	
	@Override
	public String toString() {
		return valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Etiqueta other = (Etiqueta) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}