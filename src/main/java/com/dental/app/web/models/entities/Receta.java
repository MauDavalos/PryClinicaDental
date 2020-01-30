package com.dental.app.web.models.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity()
@Table(name = "RECETA")
public class Receta implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDRECETA")
	private Integer idreceta;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Calendar fecha;
	
	
	
	@Transient
	private int doctorid;
	
	@Transient
	private int pacienteid;
	
	
	
	
	
	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public int getPacienteid() {
		return pacienteid;
	}

	public void setPacienteid(int pacienteid) {
		this.pacienteid = pacienteid;
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

	public List<Prescripcion> getPrescripciones() {
		return prescripciones;
	}

	public void setPrescripciones(List<Prescripcion> prescripciones) {
		this.prescripciones = prescripciones;
	}

	public Receta() {
		super();
	}
	
	public Receta(Integer id) {
		super();
		this.setIdreceta(id);
	}

	public Integer getIdreceta() {
		return idreceta;
	}

	public void setIdreceta(Integer idreceta) {
		this.idreceta = idreceta;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	/////////////////////////////
	
	
	@JoinColumn(name= "IDPACIENTE", referencedColumnName = "IDPERSONA")
	@ManyToOne
	private Paciente paciente;
	
	@JoinColumn(name= "IDDOCTOR", referencedColumnName = "IDPERSONA")
	@ManyToOne
	private Doctor doctor;
	
	
	/////////////////
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name= "IDRECETA")
	private List<Prescripcion> prescripciones;
	
	
	

}
