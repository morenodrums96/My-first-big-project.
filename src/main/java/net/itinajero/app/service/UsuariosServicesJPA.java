package net.itinajero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Usuario;
import net.itinajero.app.repository.UsuarioReposirtory;

@Service
public class UsuariosServicesJPA implements IUsuarioServices {

	@Autowired
	private UsuarioReposirtory repousuario;
	
	@Override
	public void inser(Usuario usuario) {
		// TODO Auto-generated method stub
		repousuario.save(usuario);
	}

	
	
}
