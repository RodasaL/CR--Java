package com.sample;

public class intrusos {
	Divisao divisao;
	boolean detetado;
	
	public intrusos(Divisao divisao, boolean detetado) {
		super();
		this.divisao = divisao;
		this.detetado = detetado;
	}
	
	public Divisao getDivisao() {
		return divisao;
	}
	public void setDivisao(Divisao divisao) {
		this.divisao = divisao;
	}
	public boolean isDetetado() {
		return detetado;
	}
	public void setDetetado(boolean detetado) {
		this.detetado = detetado;
	}
	
}