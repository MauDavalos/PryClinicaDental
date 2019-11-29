package com.dental.app.web.models.entities;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass // clase padre
public abstract class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDPERSONA")
	private Integer idpersona;
	
	@Column(name="NOMBRES")
	@Size(max=60)
	@Pattern(regexp = "[A-Za-z]+", message="El nombre solo puede tener letras")
	@NotEmpty
	private String nombres;
	
	@Column(name="APELLIDOS")
	@Size(max=60)
	@Pattern(regexp = "[A-Za-z]+")
	@NotEmpty
	private String apellidos;
	
	@Column(name="CEDULA")
	@Size(min=10, max=45)
	@Pattern(regexp = "[0-9]+")
	@NotEmpty
	private String cedula;
	
	@Column(name="TELEFONO")
	
	@Size(min=10,max=20, message="El numero de telefono es incorrecto")
	@Pattern(regexp = "[0-9+]+")
	@NotEmpty
	private String telefono;
	
	@Column(name="DIRECCION")
	@Size(max=255)
	@NotEmpty
	private String direccion;
		
	@Column(name="SEXO")
	@Size(max=1,message="Solo debes colocar una letra, M para masculino y F para Femenino")
	@Pattern(regexp = "[mMfF]+")
	@NotEmpty
	private String sexo;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@Column(name="NACIMIENTO")
	
	private Calendar nacimiento;
	
	/////////////////////////////////////
	
	public Persona() {
		super();
	}
	
	public Persona(Integer id) {
		super();
		this.idpersona = id;
	}
	
	////////////////////////////////

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Calendar getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Calendar nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return apellidos + " " + nombres;
	}
	
	

}
