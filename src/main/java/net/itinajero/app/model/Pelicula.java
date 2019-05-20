package net.itinajero.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PELICULAS")
public class Pelicula {

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String titulo;
	private int duracion;
	private String clasificacion;
	private String genero;
	private String imagen = "cinema.png"; // imagen por default	
	private Date fechaEstreno;	
	private String estatus;
	
	//@Transient//Ignorar este atributo durante la persistencia
	@OneToOne
	@JoinColumn(name="ID_DETALLES")
	private Detalles detalles;
	
	@OneToMany(mappedBy="pelicula",fetch=FetchType.EAGER)//jpa significa que cada que chequemos un registro de tipo pelicula queremos que se haga una consulta de tipo horario para ver todos los horarios
	private List<Horario>horarios;

	public Pelicula() {
		
	}
	
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", clasificacion="
				+ clasificacion + ", genero=" + genero + ", imagen=" + imagen + ", fechaEstreno=" + fechaEstreno
				+ ", estatus=" + estatus + ", detalles=" + detalles +  "]";
	}

	
	public Pelicula(int id, String titulo, int duracion, String clasificacion, String genero, String imagen,
			Date fechaEstreno, String estatus, Detalles detalles, List<Horario> horarios) {
	
		this.id = id;
		this.titulo = titulo;
		this.duracion = duracion;
		this.clasificacion = clasificacion;
		this.genero = genero;
		this.imagen = imagen;
		this.fechaEstreno = fechaEstreno;
		this.estatus = estatus;
		this.detalles = detalles;
		this.horarios = horarios;
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

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Detalles getDetalles() {
		return detalles;
	}

	public void setDetalles(Detalles detalles) {
		this.detalles = detalles;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
}

	
	