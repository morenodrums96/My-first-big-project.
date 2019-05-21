package net.itinajero.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.itinajero.app.model.Usuario;

public interface UsuarioReposirtory extends JpaRepository<Usuario, Integer> {

	
}
