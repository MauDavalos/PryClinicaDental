package com.dental.app.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dental.app.web.models.entities.Doctor;
import com.dental.app.web.models.entities.Rol;
import com.dental.app.web.models.entities.Usuario;
import com.dental.app.web.models.service.IDoctorService;
import com.dental.app.web.models.service.UsuarioService;
import com.dental.app.web.reporting.LlaveValor;


@Controller
@RequestMapping(value="/doctor") //Las rutas se componen por el Mapping del Controlador + el Get Mapping del metodo
public class DoctorController {
	
	@Autowired //Para crear inyeccion de dependencias entre el controlador y el servicio
	private IDoctorService service;
	
	@Autowired
	private UsuarioService srvUser;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);  //El model reemplaza al ViewBag
		model.addAttribute("title", "Registrar doctor");
		return "doctor/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Doctor doctor = service.findById(id);
		model.addAttribute("doctor", doctor);
		model.addAttribute("title", "Detalles de doctor");
		return "doctor/card";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			service.delete(id);
			flash.addFlashAttribute("message", "El registro se eliminó exitosamente");
		}catch(Exception ex) {
			flash.addFlashAttribute("message", "El registro no pudo eliminarse"); //El model sirve para la misma vista no si se cambia de vista
			ex.getStackTrace();
		}
		return "redirect:/doctor/list";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Doctor doctor = service.findById(id);
		model.addAttribute("doctor", doctor);
		model.addAttribute("title", "Actualizar doctor");
		return "doctor/form";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Doctor> list = service.findAll();
		model.addAttribute("list", list);
		model.addAttribute("title", "Lista de doctors");
		return "doctor/list";
	}
	
	@PostMapping(value="save")
	public String save(@Valid Doctor doctor, BindingResult result, Model model, RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				if(doctor.getIdpersona() == null) {
					model.addAttribute("title","Registrar doctor");					
				}
				else {
					model.addAttribute("title","Actualizar doctor");
				}				
				return"doctor/form";
			}
			Usuario u = new Usuario();
			u.setNombre(doctor.getUser().getNombre());
			u.setContrasenia(passwordEncoder.encode(doctor.getUser().getContrasenia()));
			u.getRoles().add(new Rol("ROLE_USER"));
			System.out.println("*************** " + u.getNombre() + " **************");
			System.out.println("*************** " + u.getContrasenia() + " **************");
			System.out.println("*************** " + u.getRoles().get(0).getNombre() + " **************");
			srvUser.save(u);
			
			System.out.println("*************** ID DE USUARIO: " + u.getIdusuario() + " **************");
			
			doctor.setUser(u);
			service.save(doctor); //El service ya sabe si es nuevo o un antiguo y lo actualiza
			flash.addFlashAttribute("message", "Registro guardado con éxito");
			
			System.out.print("*************** ID DE CLIENTE: " + doctor.getIdpersona() + " **************");
			
		}catch(Exception ex) {
			System.out.println("*************** EXCEPCION: " + ex.getMessage() + "***************");
			flash.addFlashAttribute("error", "No se pudo guardar");
		}
		return "redirect:/doctor/list";
	}
	
	/*@GetMapping(value="/findByApellido/{filtro}")
	public String findByApellido(@PathVariable(value="filtro") String filtro, Model model) {
		List<Doctor> lista = service.findByApellidos(filtro);
		model.addAttribute("title", "Listado de pacientes encontrados");
		model.addAttribute("lista", lista);
		return "doctor/list";		
	} */
	
	



	
	
}
