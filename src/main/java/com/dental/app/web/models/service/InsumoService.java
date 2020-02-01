package com.dental.app.web.models.service;

import java.util.List;
import java.util.stream.Collectors;
import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.app.web.models.dao.IInsumo;
import com.dental.app.web.models.entities.Insumo;
import com.dental.app.web.reporting.LlaveValor2;

@Service
public class InsumoService implements IInsumoService{
	
	@Autowired //esta anotacion es la inyeccion de dependencia
	private IInsumo dao;
	
	@PersistenceContext
	private EntityManager em; //Es la instancia de persistencia con la BDD

	@Override
	public void save(Insumo insumo) {
		dao.save(insumo);
		
	}

	@Override
	public Insumo findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Insumo> findAll() {
		return (List<Insumo>) dao.findAll();
	}
	
	
	///reportes
	
	@Override	
	public List<LlaveValor2> InsumosMensuales() {		
		StoredProcedureQuery consulta = em.createStoredProcedureQuery("InsumosMensuales");
		consulta.execute();
		List<Object[]> datos = consulta.getResultList();
		return datos.stream()
				.map(r -> new LlaveValor2((BigInteger)r[0], (String)r[1],(String)r[2]))
				.collect(Collectors.toList());		
	}
	

}
