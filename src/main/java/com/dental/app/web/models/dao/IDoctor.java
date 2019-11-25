package com.dental.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.dental.app.web.models.entities.Doctor;

public interface IDoctor extends CrudRepository<Doctor, Integer>{

}


