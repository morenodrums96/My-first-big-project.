package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import net.itinajero.app.model.Pelicula;

public interface IPeliculasService {
	void insertar(Pelicula pelicula); 
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
	List<String> buscarGeneros();
	void eliminar(int idPelicula);
	List<Pelicula> BuscarPorIdEstatus(String estatus);
	List<Pelicula> buscarPorFecha(Date fecha);
	
}
