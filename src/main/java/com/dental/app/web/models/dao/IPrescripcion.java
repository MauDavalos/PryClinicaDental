package com.dental.app.web.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.dental.app.web.models.entities.Prescripcion;


public interface IPrescripcion extends CrudRepository<Prescripcion, Integer>{

}
