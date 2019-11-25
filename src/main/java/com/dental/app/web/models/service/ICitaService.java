package com.dental.app.web.models.service;

import java.util.List;

import com.dental.app.web.models.entities.Cita;


public interface ICitaService {
	public void save(Cita cita);

	public Cita findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Cita> findAll();

}
