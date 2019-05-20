package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.itinajero.app.model.Horario;



@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {
	
	public List<Horario> findByPelicula_idAndFechaOrderByHora(int idPelicula, Date fecha);
	
	
	List<Horario> findByfecha(Date fecha);

}
