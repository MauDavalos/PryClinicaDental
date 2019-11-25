package com.dental.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.app.web.models.dao.IPrescripcion;
import com.dental.app.web.models.entities.Prescripcion;

@Service
public class PrescripcionService implements IPrescripcionService{
	@Autowired //esta anotacion es la inyeccion de dependencia
	private IPrescripcion dao;

	@Override
	public void save(Prescripcion prescripcion) {
		dao.save(prescripcion);
		
	}

	@Override
	public Prescripcion findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Prescripcion> findAll() {
		return (List<Prescripcion>) dao.findAll();
	}

}
