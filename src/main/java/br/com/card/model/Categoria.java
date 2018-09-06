package br.com.card.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.card.dto.CreateCategoriaDTO;

@SuppressWarnings("serial")
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(nullable = false)
	private int ativo;
	
	public Categoria() {
		
	}

	public Categoria(CreateCategoriaDTO dto) {
		this.nome = dto.nome;
		this.tipo = dto.tipo;
		this.ativo = 1;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

}
