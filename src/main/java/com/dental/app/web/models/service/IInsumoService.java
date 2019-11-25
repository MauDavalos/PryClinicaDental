package com.dental.app.web.models.service;

import java.util.List;

import com.dental.app.web.models.entities.Insumo;

public interface IInsumoService {
	
	public void save(Insumo insumo);

	public Insumo findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Insumo> findAll();

}
