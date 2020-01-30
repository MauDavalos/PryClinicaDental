package com.dental.app.web.models.service;

import java.util.List;

import com.dental.app.web.models.entities.Receta;;

public interface IRecetaService {
	
	public void save(Receta receta);

	public Receta findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Receta> findAll();

}
