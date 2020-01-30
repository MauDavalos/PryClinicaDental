package com.dental.app.web.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity()
@Table(name = "DOCTOR")

public class Doctor extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="ESPECIALIDAD")
	@Size(max=100)
	private String especialidad;
	
	//////////////////////
	
	public Doctor() {
		super();
	}
	
	public Doctor(Integer id) {
		super();
		this.setIdpersona(id);
	}
	
	////////////////////////////////

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public List<Tratamiento> getTratamientos() {
		return tratamientos;
	}

	public void setTratamientos(List<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}
	
	
	/////////////////
	
	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}


	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	private List<Cita> citas;
	
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	private List<Receta> recetas;
	
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	private List<Tratamiento> tratamientos;


	

}
