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



@Entity()
@Table(name = "PACIENTE")

public class Paciente extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="GRUPOSANGUINEO")
	@Size(max=5)
	@NotEmpty
	private String gruposanguineo;
	
	
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
	
	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
	private List<Cita> citas;
	
	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
	private List<Tratamiento> tratamientos;
	
	

}
