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
@Table(name = "TIPOTRATAMIENTO")

public class TipoTratamiento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDTIPOTRATAMIENTO")
	private Integer idtipotratamiento;
	
	@Column(name="DESCRIPCION")
	@Size(max=255)
	private String descripcion;
	
	/////////////////////////
	
	public TipoTratamiento() {
		super();
	}

	public TipoTratamiento(Integer id) {
		super();
		this.setIdtipotratamiento(id);
	}
	
	////////////
	
	public Integer getIdtipotratamiento() {
		return idtipotratamiento;
	}

	public void setIdtipotratamiento(Integer idtipotratamiento) {
		this.idtipotratamiento = idtipotratamiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	
	
	/////////////////
	

	@JoinColumn(name= "IDTRATAMIENTO", referencedColumnName = "IDTRATAMIENTO")
	@ManyToOne
	private Tratamiento tratamiento;

}
