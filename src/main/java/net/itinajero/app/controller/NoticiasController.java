package net.itinajero.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;
import net.itinajero.app.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@Autowired
	private NoticiasRepository repo;
	
	@Autowired
	private INoticiasService serviceNoticias;
	
	@GetMapping(value="/create")
	public String crear(@ModelAttribute Noticia noticia){
	
		int id = (int)repo.count()+1;
		noticia.setId(id);
		System.out.println("Este es el :"+id);
		return "noticias/formNoticia";
	}
	
	
	
	@PostMapping(value="/save")
	public String guardar(@ModelAttribute Noticia noticia,RedirectAttributes attributes){

		serviceNoticias.guardar(noticia);
		return "redirect:/";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar (@PathVariable("id") int idhorario, Model model ) {
		Noticia noti = serviceNoticias.buscarPorId(idhorario);
		model.addAttribute("noticia", noti);
		return "noticias/formNoticia";
	}
}
