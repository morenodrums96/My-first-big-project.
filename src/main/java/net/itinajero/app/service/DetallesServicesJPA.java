package net.itinajero.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Detalles;
import net.itinajero.app.repository.DetallesRepository;

@Service
public class DetallesServicesJPA implements IDetalleServices {

	
	
	@Autowired
	private DetallesRepository DetalleRepo;

	public void insertar(Detalles detalle) {
		DetalleRepo.save(detalle);
	}

	public void eliminar(int idDetalle) {
		DetalleRepo.deleteById(idDetalle);
		
	}

	

	
	


}
