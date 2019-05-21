package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Detalles;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.DetallesRepository;
import net.itinajero.app.repository.PeliculasRepository;
import net.itinajero.app.service.IDetalleServices;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@Autowired
	private PeliculasRepository repo;
	
	@Autowired
	private DetallesRepository repo1;
	
	@Autowired
	private IDetalleServices serviceDetalle;
	
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula> lista = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {

		
		
		int id = (int) repo.count() + 1;
		pelicula.setId(id);

		Detalles dts = new Detalles();
		int idd = (int) repo1.count() + 1;
		dts.setId(idd);
		pelicula.setDetalles(dts);
		
		
		return "peliculas/formPelicula";
	}
	
	
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {
	
		if (result.hasErrors()) {
			//System.out.println("Existieron errores");
			return "peliculas/formPelicula";
		}
		
		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart,request);
			pelicula.setImagen(nombreImagen);
		}

		
		serviceDetalle.insertar(pelicula.getDetalles());
		System.out.println("Antes pelicula :"+pelicula);
		servicePeliculas.insertar(pelicula);	
		System.out.println("Despues pelicula :"+pelicula);
		attributes.addFlashAttribute("mensaje", "El registro fue guardado");
		return "redirect:/peliculas/index";
	}	
	
	@GetMapping(value = "/edit/{id}")
	public String editar (@PathVariable("id") int idPelicula, Model model ) {
		Pelicula peli = servicePeliculas.buscarPorId(idPelicula);
		model.addAttribute("pelicula", peli);
		return "peliculas/formPelicula";
	}
	
	@ModelAttribute("generos")
	public List<String>getGeneros(){
		return servicePeliculas.buscarGeneros();
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar (@PathVariable("id") int idPelicula,RedirectAttributes atribu) {
		Pelicula peli = servicePeliculas.buscarPorId(idPelicula);
		servicePeliculas.eliminar(idPelicula);
		
		serviceDetalle.eliminar(peli.getDetalles().getId());
		
		atribu.addFlashAttribute("mensaje","La pelicula fue eliminada");
		
		return "redirect:/peliculas/index";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
