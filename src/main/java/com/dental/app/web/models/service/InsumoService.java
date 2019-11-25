package com.dental.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.app.web.models.dao.IInsumo;
import com.dental.app.web.models.entities.Insumo;

@Service
public class InsumoService implements IInsumoService{
	
	@Autowired //esta anotacion es la inyeccion de dependencia
	private IInsumo dao;

	@Override
	public void save(Insumo insumo) {
		dao.save(insumo);
		
	}

	@Override
	public Insumo findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Insumo> findAll() {
		return (List<Insumo>) dao.findAll();
	}

}
