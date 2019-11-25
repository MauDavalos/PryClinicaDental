package com.dental.app.web.models.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity()
@Table(name = "TRATAMIENTO")

public class Tratamiento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDTRATAMIENTO")
	private Integer idtratamiento;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="FECHAINICIO")
	private Calendar fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="FECHAFIN")
	private Calendar fechaFin;
	
	@Column(name="OBSERVACION")
	@Size(max=255)
	private String observacion;
	///////////
	
	public Tratamiento() {
		super();
	}
	
	public Tratamiento(Integer id) {
		super();
		this.setIdtratamiento(id);
	}
	
	////////////
	
	

	public Integer getIdtratamiento() {
		return idtratamiento;
	}

	public void setIdtratamiento(Integer idtratamiento) {
		this.idtratamiento = idtratamiento;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Calendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<TipoTratamiento> getTiposTratamiento() {
		return tiposTratamiento;
	}

	public void setTiposTratamiento(List<TipoTratamiento> tiposTratamiento) {
		this.tiposTratamiento = tiposTratamiento;
	}


	///////////////
	@JoinColumn(name= "IDPACIENTE", referencedColumnName = "IDPERSONA")
	@ManyToOne
	private Paciente paciente;
	
	
	@JoinColumn(name= "IDDOCTOR", referencedColumnName = "IDPERSONA")
	@ManyToOne
	private Doctor doctor;
	
	//////
	
	@OneToMany(mappedBy = "tratamiento", fetch = FetchType.LAZY)
	private List<TipoTratamiento> tiposTratamiento;

}
