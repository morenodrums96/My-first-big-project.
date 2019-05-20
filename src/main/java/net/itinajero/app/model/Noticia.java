package net.itinajero.app.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="NOTICIAS")
public class Noticia {

	@Id
	private int id;
	private String titulo;
	private Date fecha;
	private String detalle;
	private String estatus;

	
	
	public Noticia(int id, String titulo, Date fecha, String detalle, String estatus) {
	
		this.id = id;
		this.titulo = titulo;
		this.fecha = fecha;
		this.detalle = detalle;
		this.estatus = estatus;
	}

	public Noticia(){

		this.fecha = new Date();
		this.estatus="Activa";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", detalle=" + detalle + ", estatus="
				+ estatus + "]";
	}
	
	
	
}