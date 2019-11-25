package com.dental.app.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dental.app.web.models.entities.Cita;
import com.dental.app.web.models.service.ICitaService;


@Controller
@RequestMapping(value="/cita")
public class CitaController {
	
	@Autowired
	private ICitaService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		
		Cita cita = new Cita();
		model.addAttribute("cita", cita);
		model.addAttribute("title", "Registro de Cita");
		
		return "cita/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		
		Cita cita = service.findById(id);
		model.addAttribute("tipoE", cita);
		
		return "cita/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		
		Cita cita = service.findById(id);
		model.addAttribute("tipoE", cita);
		model.addAttribute("title", "Actualizando el registro de la cita de " + cita.getPaciente().getApellidos());
		
		return "cita/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		
		try {
			
			service.delete(id);
			flash.addFlashAttribute("success", "El registro se eliminó exitosamente");
			
		}catch(Exception ex) {
			
			flash.addFlashAttribute("error", "El registro no se eliminó");
			
		}
		
		return  "redirect:/cita/list";
	
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		
		List<Cita> list = service.findAll();
		model.addAttribute("title", "Listado de Citas");
		model.addAttribute("list", list);
		
		return "cita/list";
	}
	
	
	@PostMapping(value="/save")
	public String save(Cita cita, Model model, RedirectAttributes flash) {
		
		try {
			service.save(cita);
			flash.addFlashAttribute("success", "Registro guardado con éxito");
			
		}
		catch(Exception ex){
			
			flash.addFlashAttribute("error", "no se pudo guardar");
			
		}
		
		return "redirect:/cita/list";
	}

}
