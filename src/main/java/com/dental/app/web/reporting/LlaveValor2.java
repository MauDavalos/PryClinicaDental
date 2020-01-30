package com.dental.app.web.reporting;

import java.io.Serializable;
import java.math.BigDecimal;

public class LlaveValor2 implements Serializable{

	private static final long serialVersionUID = 1L;

	private String llave;

	private Double valor;

	public LlaveValor2() {		
	}



	public LlaveValor2(String llave, Double valor) {
		super();
		this.llave = llave;
		this.valor = valor;
	}



	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}

	public Double  getValor() {
		return valor;
	}

	public void setValor(Double  valor) {
		this.valor = valor;
	}







}