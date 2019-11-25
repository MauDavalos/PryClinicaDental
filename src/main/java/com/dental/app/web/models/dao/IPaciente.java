package com.dental.app.web.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.dental.app.web.models.entities.Paciente;

public interface IPaciente extends CrudRepository<Paciente, Integer>{

}
