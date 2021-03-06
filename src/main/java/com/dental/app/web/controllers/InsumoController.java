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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dental.app.web.models.entities.Insumo;
import com.dental.app.web.models.service.IInsumoService;
import com.dental.app.web.reporting.LlaveValor2;

@Controller
@RequestMapping(value="/insumo")
public class InsumoController {
	
	@Autowired
	private IInsumoService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		
		Insumo insumo = new Insumo();
		model.addAttribute("insumo", insumo);
		model.addAttribute("title", "Registro de nuevo insumo");
		
		return "insumo/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		
		Insumo insumo = service.findById(id);
		model.addAttribute("insumo", insumo);
		
		return "insumo/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		
		Insumo insumo = service.findById(id);
		
		model.addAttribute("title", "Actualizando el registro de " + insumo.getNombreMedicina());
		model.addAttribute("insumo", insumo);
		return "insumo/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		
		try {
			
			service.delete(id);
			flash.addFlashAttribute("success", "El registro se eliminó exitosamente");
			
		}catch(Exception ex) {
			
			flash.addFlashAttribute("error", "El registro no se eliminó");
			
		}
		
		return  "redirect:/insumo/list";
	
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		
		List<Insumo> list = service.findAll();
		model.addAttribute("title", "Listado de tipo de insumos");
		model.addAttribute("list", list);
		
		return "insumo/list";
	}
	
	@PostMapping(value="/save")
	public String save(@Valid Insumo insumo,BindingResult result, Model model,
			RedirectAttributes flash) {
		
		try {
			if(result.hasErrors())
			{
				if(insumo.getIdinsumo() == null) {
					model.addAttribute("tittle","Registro de un nuevo Paciente");					
				}
				else {
					model.addAttribute("tittle","Actualizando el registro de " 
							+ insumo.getNombreMedicina());
				}
				
				return"insumo/form";
			}
			service.save(insumo);
			flash.addFlashAttribute("success", "Registro guardado con éxito");
			
		}
		catch(Exception ex){
			
			flash.addFlashAttribute("error", "no se pudo guardar");
			
		}
		
		return "redirect:/insumo/list";
	}
	
	
	///reportes
	
	@GetMapping(value = "/report")
	public String report(Model model) {		
		model.addAttribute("title", "Insumos por mes");
		return "insumo/report";
	}

	@GetMapping(value = "/loadData", produces="application/json")
	public @ResponseBody List<LlaveValor2> loadData() {	
		List<LlaveValor2> lista = service.InsumosMensuales();
		return lista;
	}


	

}
