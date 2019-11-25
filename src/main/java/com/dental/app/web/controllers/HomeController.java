package com.dental.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@GetMapping(value="/")
	public String home(Model model) {
		model.addAttribute("title", "SGFM");
		model.addAttribute("description", "Sistema Ficha Medica");
		return "home";
	}
	

}
