package com.dental.app.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dental.app.web.models.entities.Paciente;
import com.dental.app.web.models.service.IPacienteService;

@Controller
@RequestMapping(value="/paciente")
public class PacienteController {
	
	@Autowired
	private IPacienteService service; 
	
	@GetMapping(value="/create")
	public String create(Model model) {
		
		Paciente paciente = new Paciente();
		model.addAttribute("paciente", paciente);
		model.addAttribute("title", "Registro de nuevo paciente");
		
		return "paciente/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		
		Paciente paciente = service.findById(id);
		model.addAttribute("paciente", paciente);
		
		return "paciente/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		
		Paciente paciente = service.findById(id);
		model.addAttribute("paciente", paciente);
		model.addAttribute("title", "Actualizando el registro de " + paciente.getNombres() + " " 
		+  paciente.getApellidos());
		
		return "paciente/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		
		try {
			
			service.delete(id);
			flash.addFlashAttribute("success", "El registro se eliminó exitosamente");
			
		}catch(Exception ex) {
			
			flash.addFlashAttribute("error", "El registro no se eliminó");
			
		}
		
		return  "redirect:/paciente/list";
	
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		
		List<Paciente> list = service.findAll();
		model.addAttribute("title", "Listado de pacientes");
		model.addAttribute("list", list);
		
		return "paciente/list";
	}
	
	@PostMapping(value="/save")
	public String save(@Valid Paciente paciente,BindingResult result, Model model,
			RedirectAttributes flash) {
		
		try {
			if(result.hasErrors())
			{
				if(paciente.getIdpersona() == null) {
					model.addAttribute("tittle","Registro de un nuevo Paciente");					
				}
				else {
					model.addAttribute("tittle","Actualizando el registro de " 
							+ paciente.getNombres());
				}
				
				return"paciente/form";
			}
			service.save(paciente);
			flash.addFlashAttribute("success", "Registro guardado con éxito");
			
		}
		catch(Exception ex){
			
			flash.addFlashAttribute("error", "El registro no se pudo guardar");
			
		}
		
		return "redirect:/paciente/list";
	}

}
