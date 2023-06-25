package com.sample;

public class animal {
	Divisao divisao;
	public String nome;
	
	public animal(Divisao divisao, String nome) {
		super();
		this.divisao = divisao;
		this.nome = nome;
	}
	public Divisao getDivisao() {
		return divisao;
	}
	public void setDivisao(Divisao divisao) {
		this.divisao = divisao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}