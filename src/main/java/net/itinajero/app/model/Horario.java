package net.itinajero.app.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="HORARIO")
public class Horario {


	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date fecha;
	private String hora; 
	private String sala;
	private double precio;

	@ManyToOne
	@JoinColumn(name="ID_PELICULAS")
	//@Transient
	private Pelicula pelicula;
	
	public Horario(){}
	
	@Override
	public String toString() {
		return "Horario [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", sala=" + sala + ", precio=" + precio
				+ ", pelicua=" + pelicula + "]";
	}



	public Horario(int id, Date fecha, String hora, String sala, double precio, Pelicula pelicua) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.sala = sala;
		this.precio = precio;
		this.pelicula = pelicua;
	}



	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	
	
	
	
	
	
}
