package com.dental.app.web.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.Calendar;
import javax.persistence.PrePersist;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;



@Entity()
@Table(name = "PACIENTE")

public class Paciente extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="GRUPOSANGUINEO")
	@Size(max=5)
	@NotEmpty
	private String gruposanguineo;
	
	//Bitácora
			@Column(name="CREADOPOR")
			@Size(max=35)
			private String creadoPor;

			@Column(name="CREADOEN")
			private Calendar creadoEn;

			@PrePersist
		    public void prePersist() {
		        creadoEn = Calendar.getInstance();
		        SecurityContext context = SecurityContextHolder.getContext();
		        creadoPor = context.getAuthentication().getName();
		    }
	/////////////////////////
	public Paciente() {
		super();
	}
	
	public Paciente(Integer id) {
		super();
		this.setIdpersona(id);
	}
	
	//////////////////////////

	public String getGruposanguineo() {
		return gruposanguineo;
	}

	public void setGruposanguineo(String gruposanguineo) {
		this.gruposanguineo = gruposanguineo;
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

	
	////////////////
	
	public String getCreadoPor() {
		return creadoPor;
	}
	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}
	public Calendar getCreadoEn() {
		return creadoEn;
	}
	public void setCreadoEn(Calendar creadoEn) {
		this.creadoEn = creadoEn;
	}


	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
	private List<Cita> citas;
	
	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
	private List<Receta> recetas;
	
	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}


	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
	private List<Tratamiento> tratamientos;
	
	


}
