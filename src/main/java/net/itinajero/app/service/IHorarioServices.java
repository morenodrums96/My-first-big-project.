package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;

public interface IHorarioServices {

	List<Horario> BuscarPorIdPelicula(int idhorario, Date fecha);
	void insert(Horario horario);
	List<Horario> buscarPorFecha(Date fecha);

}
