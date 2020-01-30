package com.dental.app.web.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDUSUARIO")
    private Usuario user;
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Doctor() {
		super();
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
	
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	private List<Cita> citas;
	
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	private List<Tratamiento> tratamientos;


	

}
