package com.dental.app.web.models.service;

import java.util.List;

import com.dental.app.web.models.entities.Tratamiento;;

public interface ITratamientoService {
	
	public void save(Tratamiento prescripcion);

	public Tratamiento findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Tratamiento> findAll();

}
