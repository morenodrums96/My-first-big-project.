package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.itinajero.app.repository.NoticiasRepository;

public class AppDelete {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		//Operacion Crud Delete [metodo deleteById del repositorio]
		int idnoticia=1;
		
		if(repo.existsById(idnoticia)) {//con el if ya nointenta la sentencia borrar por que no existe
			repo.deleteById(idnoticia);
		}
		
		
		
		context.close();
				
		context.close();
	}

}
