package pruebasjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppPaging {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		//Obtener todas las entidades por paginacion
		
//		Page<Noticia> page = repo.findAll(PageRequest.of(0, 5)); //Metodo pageable nos regresa un objeto que tendra objetos de tipo noticia
		
		Page<Noticia> page = repo.findAll(PageRequest.of(0, 2, Sort.by("id").ascending())); 
		
		for(Noticia n : page) {
			System.out.println(n);
			
		}
		
		context.close();

	}

}
