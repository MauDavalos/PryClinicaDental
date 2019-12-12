package com.dental.app.web.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


import javax.validation.constraints.Size;


@Entity()
@Table(name = "PRESCRIPCION")

public class Prescripcion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDPRESCRIPCION")
	private Integer idprescripcion;
	
	@Column(name="NOMBREGENERICO")
	@Size(max=60)
	private String nombreGenerico;
	
	@Column(name="NOMBRECOMERCIAL")
	@Size(max=60)
	private String nombreComercial;
	
	@Column(name="COMPONENTEACTIVO")
	@Size(max=60)
	private String componenteActivo;
	
	@Column(name="DOSIS")
	@Size(max=200)
	private String dosis;
	
	@Column(name="INDICACIONES")
	@Size(max=255)
	private String indicaciones;
	
	////////////////
	
	public Prescripcion() {
		super();
	}
	
	public Prescripcion(Integer id) {
		super();
		this.setIdprescripcion(id);
	}
	//////////////
	
	@JoinColumn(name= "IDCITA", referencedColumnName = "IDCITA")
	@ManyToOne
	private Cita cita;
	
	/////////////////////

	public Integer getIdprescripcion() {
		return idprescripcion;
	}

	public void setIdprescripcion(Integer idprescripcion) {
		this.idprescripcion = idprescripcion;
	}

	

	public String getNombreGenerico() {
		return nombreGenerico;
	}

	public void setNombreGenerico(String nombreGenerico) {
		this.nombreGenerico = nombreGenerico;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getComponenteActivo() {
		return componenteActivo;
	}

	public void setComponenteActivo(String componenteActivo) {
		this.componenteActivo = componenteActivo;
	}

	public String getDosis() {
		return dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	public String getIndicaciones() {
		return indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	
	
	

}
