package com.dental.app.web.reporting;

import java.io.Serializable;
import java.math.BigInteger;

public class LlaveValor2 implements Serializable{

	private static final long serialVersionUID = 1L;

	private BigInteger llave;
	
	private String valorA;
	
	private String valorB;

	public LlaveValor2(BigInteger llave, String valorA, String valorB) {
		super();
		this.llave = llave;
		this.valorA = valorA;
		this.valorB = valorB;
	}

	public BigInteger getLlave() {
		return llave;
	}

	public void setLlave(BigInteger llave) {
		this.llave = llave;
	}

	public String getValorA() {
		return valorA;
	}

	public void setValorA(String valorA) {
		this.valorA = valorA;
	}

	public String getValorB() {
		return valorB;
	}

	public void setValorB(String valorB) {
		this.valorB = valorB;
	}

	
		
}
