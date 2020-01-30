package com.dental.app.web.controllers;

import java.security.Principal;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dental.app.web.models.service.UsuarioService;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@Autowired
	private UsuarioService service;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@GetMapping(value="/")
	public String home(Model model) {
		model.addAttribute("framework", "Spring Boot");
		model.addAttribute("title", "Certificación II");				
		model.addAttribute("description", "Ejercicio práctico de la implementación de aplicaciones web con el lenguaje Java utlizando el patrón de diseño MVC y el framework Spring Boot");
		return "home";
	}
	
	@GetMapping(value="/login")
	public String login(@RequestParam(value="error", required=false) String error
			, Model model, Principal principal, RedirectAttributes flash) {
		
		if(principal!= null) {
			flash.addFlashAttribute("info", "El usuario tiene una sesión activa");
			return "redirect:/";
		}
		
		if(error!= null) {
			model.addAttribute("error", "Usuario o contrasena incorrectas");
		}
		
		return "login";
	}
	

}
