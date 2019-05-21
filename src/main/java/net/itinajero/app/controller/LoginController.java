package net.itinajero.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
	@GetMapping(value = "/index")
	public String entrar(Authentication authentication){
		System.out.println("usarname:"+authentication.getName());
		for(GrantedAuthority rol: authentication.getAuthorities())
			System.out.println("rol:"+rol.getAuthority());
		
		return "admin";
	}
	
	@GetMapping(value="/logout")
		public String logout(HttpServletRequest request){
		SecurityContextLogoutHandler logoutHandler =
		new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
	return "redirect:/formLogin";
	}

}
