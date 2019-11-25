package com.dental.app.web.models.service;

import java.util.List;

import com.dental.app.web.models.entities.TipoTratamiento;


public interface ITipoTratamientoService {
	
	public void save(TipoTratamiento tipoTratamiento);

	public TipoTratamiento findById(Integer id);
	
	public void delete(Integer id);
	
	public List<TipoTratamiento> findAll();

}
