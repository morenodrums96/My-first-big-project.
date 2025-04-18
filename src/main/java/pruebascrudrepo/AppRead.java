package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppRead {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// Operacion Crud-Read[metodo findById del repositorio]
		Optional<Noticia> noticia= repo.findById(1);//Para evitar la exception de null en caso de que no se encuentre en registro
		System.out.println(noticia.get());
		
		context.close();
	}

}
