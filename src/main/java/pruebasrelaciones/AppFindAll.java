package pruebasrelaciones;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.PeliculasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		//Recupera todas las entidades de tipo pelicula
		PeliculasRepository repo =context.getBean("peliculasRepository", PeliculasRepository.class);
		List<Pelicula>lista= repo.findAll();
		
		for(Pelicula p : lista)
		{
			System.out.println(p);
		}
		
		context.close(); 
	}

	}


