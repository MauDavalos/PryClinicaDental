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

import com.dental.app.web.models.entities.TipoTratamiento;
import com.dental.app.web.models.service.ITipoTratamientoService;

@Controller
@RequestMapping(value="/tipotratamiento")
public class TipoTratamientoController {
	
	@Autowired
	private ITipoTratamientoService service; 
	
	@GetMapping(value="/create")
	public String create(Model model) {
		
		TipoTratamiento tipoTratamiento = new TipoTratamiento();
		model.addAttribute("tipoEnfermedad", tipoTratamiento);
		model.addAttribute("title", "Registro de nuevo tipo de tratamiento");
		
		return "tipotratamiento/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		
		TipoTratamiento tipoTratamiento = service.findById(id);
		model.addAttribute("tipoTratamiento", tipoTratamiento);
		
		return "tipotratamiento/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		
		TipoTratamiento tipoTratamiento = service.findById(id);
		model.addAttribute("tipoTratamiento", tipoTratamiento);
		model.addAttribute("title", "Actualizando el registro de " + tipoTratamiento.getDescripcion());
		
		return "tipotratamiento/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		
		try {
			
			service.delete(id);
			flash.addFlashAttribute("success", "El registro se eliminó exitosamente");
			
		}catch(Exception ex) {
			
			flash.addFlashAttribute("error", "El registro no se eliminó");
			
		}
		
		return  "redirect:/tipotratamiento/list";
	
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		
		List<TipoTratamiento> list = service.findAll();
		model.addAttribute("title", "Listado de tipo de tratamientos");
		model.addAttribute("list", list);
		
		return "tipotratamiento/list";
	}
	
	@PostMapping(value="/save")
	public String save(TipoTratamiento tipoTratamiento, Model model, RedirectAttributes flash) {
		
		try {
			service.save(tipoTratamiento);
			flash.addFlashAttribute("success", "Registro guardado con éxito");
			
		}
		catch(Exception ex){
			
			flash.addFlashAttribute("error", "no se pudo guardar");
			
		}
		
		return "redirect:/tipotratamiento/list";
	}


}
