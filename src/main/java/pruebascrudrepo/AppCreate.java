package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

// Aplicacion para persistir (Crear) en la tabla Noticias un objeto de tipo Noticia
public class AppCreate {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		Noticia noticia = new Noticia();
		
		int id = (int) repo.count() + 1;
		
		noticia.setId(id);
		noticia.setTitulo("Carolina y la puerta secreta");
		noticia.setDetalle("El mes de Agosto se estrena la nueva entrega de Carolina y la puerta secreta");
	
		repo.save(noticia);
		context.close();

	}

}
