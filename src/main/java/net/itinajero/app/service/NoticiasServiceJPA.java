package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Noticia;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.NoticiasRepository;
@Service
public class NoticiasServiceJPA implements INoticiasService {
	
	@Autowired
	private NoticiasRepository NoticiasRepo;

	public void guardar(Noticia noticia) {
		NoticiasRepo.save(noticia);
		
	}

	public List<Noticia> buscarTodas() {
		return NoticiasRepo.findAll();
	}
	

	public List<Noticia> BuscarPorIdEstatus(String estatus) {
		// TODO Auto-generated method stub
		return NoticiasRepo.findByEstatusOrderByIdDesc(estatus);
	}

	public Noticia buscarPorId(int idnoticia) {
		Optional<Noticia> optional = NoticiasRepo.findById(idnoticia);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}


	
	

}
