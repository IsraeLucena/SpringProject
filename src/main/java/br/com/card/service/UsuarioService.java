package br.com.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.card.CardException;
import br.com.card.dto.CreateUsuarioDTO;
import br.com.card.model.Usuario;
import br.com.card.repository.UsuarioRepository;
import br.com.card.util.Util;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario create(CreateUsuarioDTO dto) {
		if (!Util.isCPF(dto.cpf)) {
			throw new CardException("CPF invalido!");
		}
		
		Usuario usuario = new Usuario(dto);
		
		usuarioRepository.save(usuario);
		
		return usuario;
	}
	
}
