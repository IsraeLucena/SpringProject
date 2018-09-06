package br.com.card.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.card.dto.CreatePagamentoDTO;

@SuppressWarnings("serial")
@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "vencimento", nullable = false)
	private Date vencimento;
	
	@Column(name = "valor", nullable = false)
	private double valor;
	
	@Column(name = "numero_parcela", nullable = false)
	private int qtdParcelas;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_conta", nullable = false)
	private Conta conta;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_pagamento", nullable = false)
	private TipoPagamento tipoPagamento;
	
	@ManyToOne
	@JoinColumn(name = "id_cartao", nullable = true)
	private Cartao cartao;

	public Pagamento(CreatePagamentoDTO dto) {
		this.descricao = dto.descricao;
		this.vencimento = dto.vencimento;
		this.valor = dto.valor;
		this.qtdParcelas = dto.qtdParcelas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(int qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

}
