package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.itinajero.app.repository.NoticiasRepository;

public class AppExists {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// Metodo para verificar si una entidad existe en la base de datos (Metodo existsById) 
		int idnoticia=3;
		System.out.println(repo.existsById(idnoticia)); // Es de tipo bolean si regresa true si encontro el registro si regresa false no existe
		
		context.close();
	}

}
