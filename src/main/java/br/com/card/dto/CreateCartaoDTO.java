package br.com.card.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CreateCartaoDTO implements Serializable {

	public String nome;
	public int diaFechamento;
	public int diaPagamento;
	public double limite;
	
}
