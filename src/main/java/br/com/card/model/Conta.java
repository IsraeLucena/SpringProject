package br.com.card.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.card.dto.CreateContaDTO;

@SuppressWarnings("serial")
@Entity
@Table(name = "conta")
public class Conta implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "saldo")
	private double saldo;
	
	public Conta() {
		
	}

	public Conta(CreateContaDTO dto) {
		this.nome = dto.nome;
		this.saldo = dto.saldo;
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

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
