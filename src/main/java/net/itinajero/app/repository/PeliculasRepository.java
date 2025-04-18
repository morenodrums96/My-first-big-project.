package net.itinajero.app.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import net.itinajero.app.model.Pelicula;

@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula, Integer> {
	
	List<Pelicula> findBy();
	
	List<Pelicula> findByEstatus(String estatus);
	
	List<Pelicula> findByfechaEstreno(Date fecha);
	
	
	
}
