package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppUpdate {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Operacion CRUD - Update [metodo save del repositorio]
		//1. primero buscamos la entidad que vamos a modificar(findById)
		Optional<Noticia> optional = repo.findById(3);
		
		
		//2. modificamos la entidad y la guardamos
		
		if(optional.isPresent())
		{
			Noticia noticia = optional.get();
			noticia.setEstatus("Inactiva");
			repo.save(noticia);
		}
//		Para hacer una actualizacion tenemos el metodo 
//		save en este caso spring para saber si va arealizar
//		un insert oun update toma como referencia 
//		el valor del atrinuto ID en este caso si finById
//		detecta que el ID es diferente de o hace el Update
//		
		
		context.close();
	}

}
