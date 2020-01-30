package com.dental.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.dental.app.web.models.entities.Usuario;


public interface IUsuario extends CrudRepository<Usuario, Integer>{

	public Usuario findByNombre(String nombre);
	
}
