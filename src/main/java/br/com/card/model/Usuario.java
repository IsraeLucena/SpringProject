package br.com.card.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.card.dto.CreateUsuarioDTO;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "nascimento", nullable = false)
	private Date nascimento;
	
	public Usuario() {
		
	}
	
	public Usuario(CreateUsuarioDTO dto) {
		this.nome = dto.nome;
		this.cpf = dto.cpf;
		this.nascimento = dto.nascimento;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

}
