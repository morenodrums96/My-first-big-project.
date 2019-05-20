package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Noticia;


//@Service
public class NoticiasServiceImpl  {
	
	
	
	// Constructor vacio. 
	public NoticiasServiceImpl() {
		
	}
	

	public void guardar(Noticia noticia) {
		System.out.println("Guadando el objeto " + noticia + " en la base de datos.");
	}


	public List<Noticia> buscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Noticia> BuscarPorIdEstatus(String estatus, int Idnoticia) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
