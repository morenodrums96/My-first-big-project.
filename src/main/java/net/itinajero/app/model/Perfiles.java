package net.itinajero.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERFIL")
public class Perfiles {

	@Id
	private int id;
	private String cuenta;
	private String perfil; 
	
	public Perfiles() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Perfiles [id=" + id + ", cuenta=" + cuenta + ", perfil=" + perfil + "]";
	}
	
	
}
