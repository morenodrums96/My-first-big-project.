package net.itinajero.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Noticia;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.service.IHorarioServices;
import net.itinajero.app.service.INoticiasService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IBannersService serviceBanners;
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IHorarioServices servicesHorarios;
		
	@Autowired
	private INoticiasService serviceNoticias;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") Date fecha, Model model) {
		try {
		List<Noticia> lista = serviceNoticias.BuscarPorIdEstatus("Activa");
		Date fechaSinHora = dateFormat.parse(dateFormat.format(fecha));
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Horario> horario  = servicesHorarios.buscarPorFecha(fechaSinHora);
		List<Pelicula> peliculas=null;
		peliculas = new LinkedList<>();
		for (Horario h : horario) {
			// Solo nos interesa de cada registro de horario, el registro de pelicula.
			peliculas.add(h.getPelicula());
		}		
		
		model.addAttribute("fechas", listaFechas);	
		//System.out.println("Peliculas a mostrar: "+);
		// Regresamos la fecha que selecciono el usuario con el mismo formato
		model.addAttribute("fechaBusqueda",dateFormat.format(fecha));			
		model.addAttribute("peliculas", peliculas);		
		model.addAttribute("banners", serviceBanners.buscarTodos()); 
		model.addAttribute("noticias", lista);
		
		} catch (ParseException e) {
			System.out.println("Error: HomeController.buscar" + e.getMessage());
		}
		return "home";
	}
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {

		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		
		List<Noticia> lista = serviceNoticias.BuscarPorIdEstatus("Activa");
		
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		
		
		model.addAttribute("banners", serviceBanners.buscarTodos()); 
		model.addAttribute("noticias", lista);
		return "home";
	}

	@RequestMapping(value = "/detail/{id}/{fecha}",method=RequestMethod.GET)		
	public String mostrarDetalle(Model model,@PathVariable("id") int idPelicula, @PathVariable("fecha") Date fecha) {
		List<Horario> horarios = servicesHorarios.BuscarPorIdPelicula(idPelicula, fecha);
		model.addAttribute("horarios",horarios);
		model.addAttribute("fechaBusqueda",dateFormat.format(fecha));
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		// TODO - Buscar en la base de datos los horarios.		
		return "detalle";
	}
	
	@RequestMapping(value="/formLogin",method=RequestMethod.GET)
	public String login() {
		return "formLogin";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	

	
}
