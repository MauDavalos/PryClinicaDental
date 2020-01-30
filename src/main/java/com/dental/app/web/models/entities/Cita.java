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
@Table(name = "CITA")

public class Cita implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDCITA")
	private Integer idcita;
	
	/*@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm")*/
	@Temporal(TemporalType.DATE)
	@Column(name="FECHAHORA")
	private Calendar fechaHora;
	

	@Column(name="PRECIO",precision=8, scale=2)
	private Double precio;
	
	@Column(name="GANANCIA",precision=8, scale=2)
	private Double ganancia;
	
	@Column(name="OBSERVACION")
	@Size(max=255)
	private String observacion;
	
	@Column(name="ESTADO")
	@Size(max=200)
	private String estado;
	//////////////
	
	public Cita() {
		super();
	}
	
	public Cita(Integer id) {
		super();
		this.setIdcita(id);
	}
	
	///////////////////

	public Integer getIdcita() {
		return idcita;
	}

	public void setIdcita(Integer idcita) {
		this.idcita = idcita;
	}
	
	public Calendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Calendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	
	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getGanancia() {
		return ganancia;
	}

	public void setGanancia(Double ganancia) {
		this.ganancia = ganancia;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public List<Insumo> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}

	


	/////////////////////////////


	@JoinColumn(name= "IDPACIENTE", referencedColumnName = "IDPERSONA")
	@ManyToOne
	private Paciente paciente;
	
	@JoinColumn(name= "IDDOCTOR", referencedColumnName = "IDPERSONA")
	@ManyToOne
	private Doctor doctor;
	
	////////////////
	
	@OneToMany(mappedBy = "cita", fetch = FetchType.LAZY)
	private List<Insumo> insumos;
	
	
	

}
