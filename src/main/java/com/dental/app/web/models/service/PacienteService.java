package com.dental.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.app.web.models.dao.IPaciente;
import com.dental.app.web.models.entities.Paciente;

@Service
public class PacienteService implements IPacienteService{
	
	@Autowired //esta anotacion es la inyeccion de dependencia
	private IPaciente dao;

	@Override
	public void save(Paciente paciente) {
		dao.save(paciente);
		
	}

	@Override
	public Paciente findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Paciente> findAll() {
		return (List<Paciente>) dao.findAll();
	}

}
