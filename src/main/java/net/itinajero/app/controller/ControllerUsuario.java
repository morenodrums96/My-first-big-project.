package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Perfiles;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.repository.PerfilesRepository;
import net.itinajero.app.repository.UsuarioReposirtory;
import net.itinajero.app.service.IPerfilesServices;
import net.itinajero.app.service.IUsuarioServices;

@Controller
@RequestMapping("/usuario")
public class ControllerUsuario {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UsuarioReposirtory RepoUsuario;
	

	@Autowired
	private IUsuarioServices serviciousuario;
	
	
	@Autowired
	private IPerfilesServices servicioperfil;
		

		@GetMapping("/create")
		public String crear(@ModelAttribute Usuario usuario) {
			
			int id = (int) RepoUsuario.count()+1;
			usuario.setId(id);
			
	
			return "usuario/formUsuario";
		}
	
		@GetMapping("/index")
		public String index() {
			
			return "usuario/listaUsuario";
		}
		
		@PostMapping("/save")
		public String guardar(@ModelAttribute Usuario usuario,@RequestParam ("perfil") String perfil) {
			System.out.println("Usuario :"+usuario);
			System.out.println("perfil:"+ perfil);
			String tempass = encoder.encode(usuario.getPwd());
			usuario.setPwd(tempass);
			usuario.setActivo(1);
			serviciousuario.inser(usuario);
			Perfiles perfiles =new Perfiles();
			
			perfiles.setId(usuario.getId());
			perfiles.setCuenta(usuario.getCuenta());
			perfiles.setPerfil(perfil);
			servicioperfil.insert(perfiles);
			
			return "redirect:/usuario/index";
			
		}
	
		@GetMapping("/demo-bcrypt")
		public String pruebaBCrypt() {
		String paswword = "mari123";
		String encriptado = encoder.encode(paswword);
		System.out.println("Password encliptado:"+encriptado);
		return "usuario/demo";
	}
}
