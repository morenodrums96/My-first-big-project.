package net.itinajero.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.itinajero.app.model.Detalles;
import net.itinajero.app.model.Pelicula;

@Repository
public interface DetallesRepository extends JpaRepository<Detalles, Integer> {

	List<Detalles> findBy();
}
