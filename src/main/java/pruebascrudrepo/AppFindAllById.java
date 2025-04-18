package pruebascrudrepo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppFindAllById {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		//Recuperarvarios registros por id [metodo findAllById]del repositorio
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(2);			// List es tambien interable
		ids.add(3);
		ids.add(8);
		
		Iterable<Noticia> it =repo.findAllById(ids);
		
		for(Noticia n: it)
		{
			System.out.println(n);
		}
		context.close();
	}

}
