package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Noticia;
import net.itinajero.app.model.Pelicula;


public interface INoticiasService {

	void guardar(Noticia noticia);
	List<Noticia> buscarTodas();
	List<Noticia> BuscarPorIdEstatus(String estatus);
	Noticia buscarPorId(int idnoticia);
	
}
