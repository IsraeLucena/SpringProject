package br.com.card.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CreateUsuarioDTO implements Serializable {
	
	public String nome;
	public String cpf;
	public Date nascimento;

}
