package br.com.card.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "cartao")
public class Cartao implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "dia_fechamento", nullable = false)
	private int diaFechamento;
	
	@Column(name = "dia_pagamento", nullable = false)
	private int diaPagamento;
	
	@Column(name = "limite", nullable = false)
	private double limite;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDiaFechamento() {
		return diaFechamento;
	}

	public void setDiaFechamento(int diaFechamento) {
		this.diaFechamento = diaFechamento;
	}

	public int getDiaPagamento() {
		return diaPagamento;
	}

	public void setDiaPagamento(int diaPagamento) {
		this.diaPagamento = diaPagamento;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

}
