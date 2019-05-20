package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.HorariosRepository;

@Service
public class HorarioServicesJPA implements IHorarioServices {
	
	@Autowired
	private HorariosRepository HorarioRepo;
	
	public List<Horario> BuscarPorIdPelicula(int idPelicula, Date fecha) {
		return HorarioRepo.findByPelicula_idAndFechaOrderByHora(idPelicula, fecha);
		
	}

	public void insert(Horario horario) {
		HorarioRepo.save(horario);
		
	}

	@Override
	public List<Horario> buscarPorFecha(Date fecha) {
		// TODO Auto-generated method stub
		return HorarioRepo.findByfecha(fecha);
	}

	
}
