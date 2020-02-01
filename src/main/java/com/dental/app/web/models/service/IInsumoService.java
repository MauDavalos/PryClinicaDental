package com.dental.app.web.models.service;

import java.util.List;

import com.dental.app.web.models.entities.Insumo;
import com.dental.app.web.reporting.LlaveValor2;

public interface IInsumoService {
	
	public void save(Insumo insumo);

	public Insumo findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Insumo> findAll();
	
	public List<LlaveValor2> InsumosMensuales();

}
