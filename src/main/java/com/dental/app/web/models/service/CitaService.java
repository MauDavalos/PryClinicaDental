package com.dental.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.app.web.models.dao.ICita;
import com.dental.app.web.models.entities.Cita;

@Service
public class CitaService implements ICitaService{
	@Autowired 
	private ICita dao;

	@Override
	public void save(Cita cita) {
		dao.save(cita);
		
	}

	@Override
	public Cita findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Cita> findAll() {
		return (List<Cita>) dao.findAll();
	}

}
