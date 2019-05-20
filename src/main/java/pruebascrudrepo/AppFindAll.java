package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Recuperar todos los registros [metodo findAll del repositorio]
		Iterable<Noticia> it =repo.findAll();//findAll Para recurar todas nuestras entidades 
											 //Este metodo nos regresa un objeto que interpreta la interfaz interable
											//y esta interfaz esta envolviendo objetos de tipo noticias
											//Todos los objetos que implementa la interfaz interable
											//Pueden ser recorridos por una sentencia for each 
		
		for(Noticia n: it)
		{
			System.out.println(n);
		}
		
		context.close();
	}

}
