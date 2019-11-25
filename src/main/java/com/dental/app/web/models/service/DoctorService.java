package com.dental.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.app.web.models.dao.IDoctor;
import com.dental.app.web.models.entities.Doctor;

@Service
public class DoctorService implements IDoctorService{
	@Autowired //esta anotacion es la inyeccion de dependencia
	private IDoctor dao;

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
