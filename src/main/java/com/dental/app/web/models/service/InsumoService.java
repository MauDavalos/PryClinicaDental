package com.dental.app.web.models.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.app.web.models.dao.IInsumo;
import com.dental.app.web.models.entities.Insumo;
import com.dental.app.web.reporting.LlaveValor;
import com.dental.app.web.reporting.LlaveValor2;

@Service
public class InsumoService implements IInsumoService{
	
	@Autowired //esta anotacion es la inyeccion de dependencia
	private IInsumo dao;

	@PersistenceContext
	private EntityManager em;
	
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
	@Override	
	public List<LlaveValor2> ContarInsumo(){		
		StoredProcedureQuery consulta = em.createStoredProcedureQuery("Insumo");
		consulta.execute();
		List<Object[]> datos = consulta.getResultList();
		return datos.stream()
				.map(r -> new LlaveValor2((String)r[1], (Double)r[0]))
				.collect(Collectors.toList());		
	}
}
