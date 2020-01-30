package com.dental.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dental.app.web.models.dao.IReceta;
import com.dental.app.web.models.entities.Prescripcion;
import com.dental.app.web.models.entities.Receta;

@Service
public class RecetaService implements IRecetaService{
	@Autowired //esta anotacion es la inyeccion de dependencia
	private IReceta dao;

	@Override
	public void save(Receta receta) {
		dao.save(receta);
		
	}

	@Override
	public Receta findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Receta> findAll() {
		return (List<Receta>) dao.findAll();
	}

}
