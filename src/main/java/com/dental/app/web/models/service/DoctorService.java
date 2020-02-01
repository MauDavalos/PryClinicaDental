package com.dental.app.web.models.service;

import java.util.List;
import java.util.stream.Collectors;
import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.app.web.models.dao.IDoctor;
import com.dental.app.web.models.entities.Doctor;
import com.dental.app.web.reporting.LlaveValor;

@Service
public class DoctorService implements IDoctorService{
	@Autowired //esta anotacion es la inyeccion de dependencia
	private IDoctor dao;
	
	@PersistenceContext
	private EntityManager em; //Es la instancia de persistencia con la BDD


	@Override
	public void save(Doctor doctor) {
		dao.save(doctor);
		
	}

	@Override
	public Doctor findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Doctor> findAll() {
		return (List<Doctor>) dao.findAll();
	}
	
	
	
	

}
