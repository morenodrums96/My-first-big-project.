package net.itinajero.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="DETALLES")
public class Detalles {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	private String director;
	private String actor;
	private String sinopsis;
	private String trailer;
	
	public Detalles() {
		
	}


	@Override
	public String toString() {
		return "Detalles [id=" + id + ", director=" + director + ", actor=" + actor + ", sinopsis=" + sinopsis
				+ ", trailer=" + trailer + "]";
	}


	public Detalles(int id, String director, String actor, String sinopsis, String trailer) {
	
		this.id = id;
		this.director = director;
		this.actor = actor;
		this.sinopsis = sinopsis;
		this.trailer = trailer;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getActor() {
		return actor;
	}


	public void setActor(String actor) {
		this.actor = actor;
	}


	public String getSinopsis() {
		return sinopsis;
	}


	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}


	public String getTrailer() {
		return trailer;
	}


	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}


	
	
}
