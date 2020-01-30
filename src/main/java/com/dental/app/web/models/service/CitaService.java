package com.dental.app.web.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.app.web.models.dao.ICita;
import com.dental.app.web.models.entities.Cita;
import com.dental.app.web.reporting.LlaveValor;

@Service
public class CitaService implements ICitaService{
	@Autowired 
	private ICita dao;

	@PersistenceContext
	private EntityManager em;
	
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

	@Override	
	public List<LlaveValor> ContarRango() {		
		StoredProcedureQuery consulta = em.createStoredProcedureQuery("Contar");
		consulta.execute();
		List<Object[]> datos = consulta.getResultList();
		return datos.stream()
				.map(r -> new LlaveValor((String)r[1], (BigInteger)r[0]))
				.collect(Collectors.toList());		
	}

}
