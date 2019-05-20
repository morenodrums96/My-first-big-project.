package net.itinajero.app.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.HorariosRepository;
import net.itinajero.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculasService{
	
	@Autowired
	private PeliculasRepository peliculasRepo;
	
	private HorariosRepository horariosRepo;
	

	public void insertar(Pelicula pelicula) {
		peliculasRepo.save(pelicula);
		
	}


	public List<Pelicula> buscarTodas() {
		return peliculasRepo.findAll();
	}


	public Pelicula buscarPorId(int idPelicula) {
		Optional<Pelicula> optional = peliculasRepo.findById(idPelicula);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	
	public List<String> buscarGeneros() {
		// Nota: Esta lista podria ser obtenida de una BD
				List<String> generos = new LinkedList<String>();
				generos.add("Accion");
				generos.add("Aventura");
				generos.add("Clasicas");
				generos.add("Comedia Romantica");
				generos.add("Drama");
				generos.add("Terror");
				generos.add("Infantil");
				generos.add("Accion y Aventura");
				generos.add("Romantica");
				generos.add("Ciencia Ficcion");
						
				return generos;
	}


	public void eliminar(int idPelicula) {
		peliculasRepo.deleteById(idPelicula);
		
	}


	public List<Pelicula> BuscarPorIdEstatus(String estatus) {
		
		return  peliculasRepo.findByEstatus(estatus);
	}


	public List<Pelicula> buscarPorFecha(Date fecha) {		
		List<Pelicula> peliculas = null;
		// Buscamos en la tabla de horarios, [agrupando por idPelicula]
		System.out.println("Fecha :"+ fecha);
		List<Horario> horarios = horariosRepo.findByfecha(fecha);
		peliculas = new LinkedList<>();

		// Formamos la lista final de Peliculas que regresaremos.
		for (Horario h : horarios) {
			// Solo nos interesa de cada registro de horario, el registro de pelicula.
			peliculas.add(h.getPelicula());
		}		
		return peliculas;
	}


	

}
