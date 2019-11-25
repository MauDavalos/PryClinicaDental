package com.dental.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.app.web.models.dao.ITipoTratamiento;
import com.dental.app.web.models.entities.TipoTratamiento;

@Service
public class TipoTratamientoService implements ITipoTratamientoService{
	@Autowired //esta anotacion es la inyeccion de dependencia
	private ITipoTratamiento dao;

	@Override
	public void save(TipoTratamiento tipoTratamiento) {
		dao.save(tipoTratamiento);
		
	}

	@Override
	public TipoTratamiento findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<TipoTratamiento> findAll() {
		return (List<TipoTratamiento>) dao.findAll();
	}

}
