package com.dental.app.web.models.service;

import java.util.List;

import com.dental.app.web.models.entities.Paciente;

public interface IPacienteService {
	
	public void save(Paciente paciente);

	public Paciente findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Paciente> findAll();

}
