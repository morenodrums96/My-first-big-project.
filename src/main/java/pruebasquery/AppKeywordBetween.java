package pruebasquery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppKeywordBetween {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<Noticia> lista = null;
		
		try {
//			lista = repo.findByFechaBetween(format.parse("2015-01-01"),format.parse("2019-05-03"));
			lista = repo.findByIdBetween(1,10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Noticia n : lista)
			System.out.println(n);
		
		
		context.close();
	}

}
