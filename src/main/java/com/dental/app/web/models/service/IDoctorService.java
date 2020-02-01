package com.dental.app.web.models.service;

import java.util.List;

import com.dental.app.web.models.entities.Doctor;
import com.dental.app.web.reporting.LlaveValor;

public interface IDoctorService {
	

	public void save(Doctor doctor);

	public Doctor findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Doctor> findAll();
	


}
