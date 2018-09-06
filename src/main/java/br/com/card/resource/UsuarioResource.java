package br.com.card.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.card.model.Usuario;
import br.com.card.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/find-all", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
	@RequestMapping(value = "/find-by-id", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<?> listById(@RequestParam(value = "idUsuario", required = true) Long idUsuario) {
		Usuario usuario = usuarioRepository.findOne(idUsuario);
		return ResponseEntity.ok(usuario);
	}

}
