package br.com.card.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CreatePagamentoDTO implements Serializable {
	
	public String descricao;
	public Date vencimento;
	public double valor;
	public int qtdParcelas;
	public Long idUsuario;
	public Long idCategoria;
	public Long idConta;
	public Long idTipoPagamento;
	public Long idCartao;
	
	public CreatePagamentoDTO() {
		
	}

}
