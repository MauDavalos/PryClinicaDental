package com.dental.app.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dental.app.web.models.entities.Prescripcion;
import com.dental.app.web.models.entities.Receta;
import com.dental.app.web.models.entities.Usuario;
import com.dental.app.web.models.service.IRecetaService;
import com.dental.app.web.models.service.PacienteService;
import com.dental.app.web.models.service.DoctorService;

import com.dental.app.web.models.service.PrescripcionService;
import com.dental.app.web.models.service.UsuarioService;
import com.dental.app.web.models.entities.Paciente;
import com.dental.app.web.models.entities.Doctor;


@Controller
@RequestMapping(value="/receta")
@SessionAttributes({"detalles"})
public class RecetaController {
	
	@Autowired
	private IRecetaService service; 
	
	@Autowired
	private UsuarioService srvUsuario; 
	
	@Autowired
	private PacienteService srvPaciente;
	
	@Autowired
	private DoctorService srvDoctor;
	
	@Autowired
	private PrescripcionService srvPrescripcion;
	

	
	@GetMapping(value="/create")
	public String create(Model model) {
		Receta receta = new Receta();
		//receta.setDoctorid(idDoctor);
		//receta.setPacienteid(idPaciente);
			
		//Paciente paciente = srvPaciente.findById(idPaciente);

		//Doctor doctor = srvDoctor.findById(idDoctor);
		
		//List<Usuario> medicos = srvMedico.findAll();
		
		List<Paciente> pacientes = srvPaciente.findAll();
		
		List<Prescripcion> tipos = srvPrescripcion.findAll();
				
		model.addAttribute("title", "Nuevo registro ");
		model.addAttribute("receta", receta);
		model.addAttribute("tipos", tipos);
		model.addAttribute("pacientes", pacientes);
		
		
		model.addAttribute("detalles", new ArrayList<Prescripcion>());
		//model.addAttribute("medicos", medicos);
		//model.addAttribute("tipos", tipos);		
		return "receta/form";
	}
	
	

	

	


	
	
	
	@GetMapping(value="/list")
	public String list(Model model, Authentication authentication) {
		
		List<Receta> list = service.findAll();
		model.addAttribute("title", "Listado de recetas");
		model.addAttribute("list", list);
		
		return "receta/list";
	}
	
	
	
	@PostMapping(value="save")
	public String save(@Valid Receta receta, BindingResult result, Model model, RedirectAttributes mensaje,
			@SessionAttribute(value="detalles") List<Prescripcion> prescripcion, SessionStatus session) {
		
		try {
			if(result.hasErrors()) {
				System.out.println("--------------> Errores: " + result.getAllErrors().get(0).getDefaultMessage());
				return "receta/form";
			}

			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			Usuario usuario = srvUsuario.findByUsername(userDetail.getUsername());
			Doctor doctor = usuario.getDoctor(); /// acorde con hernan
			
			//Paciente p = srvPaciente.findById(receta.getPaciente().getIdpersona());
			
			System.out.println("--------------> Doctor: " + usuario.getNombre());
			
			receta.setPrescripciones(prescripcion);
			receta.setDoctor(doctor);
			service.save(receta);
			session.setComplete();
		}catch(Exception ex) {
			//flash.addFlashAttribute("error", "No se pudo guardar");
			System.out.println("--------------> Excepcion: " + ex.getMessage());
		}
		return "redirect:/receta/list";
	}
	
	

	
	@PostMapping(value="/addDetail", produces="application/json")
	public @ResponseBody List<Prescripcion> addDetail(@RequestBody Prescripcion detail, 
			@SessionAttribute(value="detalles") List<Prescripcion> detalles) {		
		detalles.add(detail);		
		return detalles;		
	}

}
