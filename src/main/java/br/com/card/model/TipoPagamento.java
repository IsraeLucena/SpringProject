package br.com.card.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.card.dto.CreateTipoPagamentoDTO;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipo_pagamento")
public class TipoPagamento implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	public TipoPagamento() {
		
	}
	
	public TipoPagamento(CreateTipoPagamentoDTO dto) {
		this.nome = dto.nome;
	}

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

}
