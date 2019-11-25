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

import com.dental.app.web.models.entities.Prescripcion;
import com.dental.app.web.models.service.IPrescripcionService;

@Controller
@RequestMapping(value="/prescripcion")
public class PrescripcionController {
	
	@Autowired
	private IPrescripcionService service; 
	
	@GetMapping(value="/create")
	public String create(Model model) {
		
		Prescripcion prescripcion = new Prescripcion();
		model.addAttribute("prescripcion", prescripcion);
		model.addAttribute("title", "Registro de nueva prescripcion");
		
		return "prescripcion/form";
	}
	

	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		
		Prescripcion prescripcion = service.findById(id);
		model.addAttribute("prescripcion", prescripcion);
		
		return "prescripcion/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		
		Prescripcion prescripcion = service.findById(id);
		model.addAttribute("prescripcion", prescripcion);
		model.addAttribute("title", "Actualizando el registro de " + prescripcion.getNombreComercial());
		
		return "prescripcion/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		
		try {
			
			service.delete(id);
			flash.addFlashAttribute("success", "El registro se eliminó exitosamente");
			
		}catch(Exception ex) {
			
			flash.addFlashAttribute("error", "El registro no se eliminó");
			
		}
		
		return  "redirect:/prescripcion/list";
	
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		
		List<Prescripcion> list = service.findAll();
		model.addAttribute("title", "Listado de prescripciones");
		model.addAttribute("list", list);
		
		return "prescripcion/list";
	}
	
	@PostMapping(value="/save")
	public String save(Prescripcion prescripcion, Model model, RedirectAttributes flash) {
		
		try {
			service.save(prescripcion);
			flash.addFlashAttribute("success", "Registro guardado con éxito");
			
		}
		catch(Exception ex){
			
			flash.addFlashAttribute("error", "no se pudo guardar");
			
		}
		
		return "redirect:/prescripcion/list";
	}

}
