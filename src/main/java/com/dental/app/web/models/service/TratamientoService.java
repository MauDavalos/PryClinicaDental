package com.dental.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.app.web.models.dao.ITratamiento;
import com.dental.app.web.models.entities.Tratamiento;

@Service
public class TratamientoService implements ITratamientoService{
	@Autowired //esta anotacion es la inyeccion de dependencia
	private ITratamiento dao;

	@Override
	public void save(Tratamiento tratamiento) {
		dao.save(tratamiento);
		
	}

	@Override
	public Tratamiento findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Tratamiento> findAll() {
		return (List<Tratamiento>) dao.findAll();
	}

}
