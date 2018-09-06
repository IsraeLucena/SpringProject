package br.com.card.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.card.dto.CreateUsuarioDTO;
import br.com.card.model.Cartao;
import br.com.card.model.Usuario;
import br.com.card.repository.UsuarioRepository;
import br.com.card.service.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
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
	
	@RequestMapping(value = "/create", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody CreateUsuarioDTO dto) {
		return ResponseEntity.ok(usuarioService.create(dto));
	}
	
	@RequestMapping(value = "/delete", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.DELETE)
	@Transactional
	public ResponseEntity<?> delete(@RequestParam(value = "idUsuario", required = true) Long idUsuario) {
		usuarioRepository.delete(idUsuario);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/update", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(usuarioService.update(usuario));
	}

}
