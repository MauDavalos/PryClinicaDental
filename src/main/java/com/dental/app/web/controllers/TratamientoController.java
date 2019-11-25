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

import com.dental.app.web.models.entities.Tratamiento;
import com.dental.app.web.models.service.ITratamientoService;

@Controller
@RequestMapping(value="/tratamiento")
public class TratamientoController {
	
	@Autowired
	private ITratamientoService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		
		Tratamiento tratamiento = new Tratamiento();
		model.addAttribute("tratamiento", tratamiento);
		model.addAttribute("title", "Registro de nuevo tratamiento");
		
		return "tratamiento/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		
		Tratamiento tratamiento = service.findById(id);
		model.addAttribute("tratamiento", tratamiento);
		
		return "tratamiento/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		
		Tratamiento tratamiento = service.findById(id);
		model.addAttribute("tratamiento", tratamiento);
		model.addAttribute("title", "Actualizando el registro de tratamiento " + tratamiento.getIdtratamiento());
		
		return "tratamiento/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		
		try {
			
			service.delete(id);
			flash.addFlashAttribute("success", "El registro se eliminó exitosamente");
			
		}catch(Exception ex) {
			
			flash.addFlashAttribute("error", "El registro no se eliminó");
			
		}
		
		return  "redirect:/tratamiento/list";
	
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		
		List<Tratamiento> list = service.findAll();
		model.addAttribute("title", "Listado de tratamientos");
		model.addAttribute("list", list);
		
		return "tratamiento/list";
	}
	
	@PostMapping(value="/save")
	public String save(Tratamiento tratamiento, Model model, RedirectAttributes flash) {
		
		try {
			service.save(tratamiento);
			flash.addFlashAttribute("success", "Registro guardado con éxito");
			
		}
		catch(Exception ex){
			
			flash.addFlashAttribute("error", "no se pudo guardar");
			
		}
		
		return "redirect:/tratamiento/list";
	}


}
