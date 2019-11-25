package com.dental.app.web.models.service;

import java.util.List;

import com.dental.app.web.models.entities.Prescripcion;

public interface IPrescripcionService {
	
	public void save(Prescripcion prescripcion);

	public Prescripcion findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Prescripcion> findAll();

}
