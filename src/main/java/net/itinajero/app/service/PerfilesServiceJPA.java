package net.itinajero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Perfiles;
import net.itinajero.app.repository.PerfilesRepository;

@Service
public class PerfilesServiceJPA implements IPerfilesServices {

	@Autowired
	private PerfilesRepository repoperfil;
	
	@Override
	public void insert(Perfiles perfiles) {
		// TODO Auto-generated method stub
		repoperfil.save(perfiles);
	}

}
