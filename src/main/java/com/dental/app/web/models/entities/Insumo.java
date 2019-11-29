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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity()
@Table(name = "INSUMO")

public class Insumo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDINSUMO")
	private Integer idinsumo;
	
	@Column(name="NOMBREMEDICINA")
	@Size(max=200)
	@NotEmpty
	private String nombreMedicina;
	
	@Column(name="CANTIDADMEDICINA")
	@Size(max=150)
	@NotEmpty
	private String cantidadMedicina;
	
	@Column(name="MATERIAL")
	@Size(max=200)
	@NotEmpty
	private String material;
	
	@Column(name="OBSERVACIONES")
	@Size(max=255)
	@NotEmpty
	private String observaciones;
	
	@Column(name="COSTO",precision=8, scale=2)
	private Double costo;
	
	/////////////////////
	
	public Insumo() {
		super();
	}
	
	public Insumo(Integer id) {
		super();
		this.setIdinsumo(id);
	}
	
	
	
	/////////////////////////
	
	@JoinColumn(name= "IDCITA", referencedColumnName = "IDCITA")
	@ManyToOne
	private Cita cita;
	
	///////////////////

	public Integer getIdinsumo() {
		return idinsumo;
	}

		

	public void setIdinsumo(Integer idinsumo) {
		this.idinsumo = idinsumo;
	}



	public String getNombreMedicina() {
		return nombreMedicina;
	}



	public void setNombreMedicina(String nombreMedicina) {
		this.nombreMedicina = nombreMedicina;
	}



	public String getCantidadMedicina() {
		return cantidadMedicina;
	}



	public void setCantidadMedicina(String cantidadMedicina) {
		this.cantidadMedicina = cantidadMedicina;
	}



	public String getMaterial() {
		return material;
	}



	public void setMaterial(String material) {
		this.material = material;
	}



	public String getObservaciones() {
		return observaciones;
	}



	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}



	public Double getCosto() {
		return costo;
	}



	public void setCosto(Double costo) {
		this.costo = costo;
	}



	public Cita getCita() {
		return cita;
	}



	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	

}
