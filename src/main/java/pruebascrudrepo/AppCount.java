package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.itinajero.app.repository.NoticiasRepository;

public class AppCount {

	public static void main(String[] args) {
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		// Contar los numeros de registros en la tabal[metodo count () del repositorio]
		//Conunt saber el numero de entidades de una tabla
		long num = repo.count();
		System.out.println("Se encontraron: "+ num + " registros");
		context.close();
	}

}
