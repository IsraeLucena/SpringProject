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

import br.com.card.dto.CreateCategoriaDTO;
import br.com.card.repository.CategoriaRepository;
import br.com.card.service.CategoriaService;

@RestController
@RequestMapping(value = "/api/categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository caegoriaRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value = "/find-all", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok(caegoriaRepository.findAll());
	}
	
	@RequestMapping(value = "/find-by-id", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<?> listById(@RequestParam(value = "idCategoria", required = true) Long idCategoria) {
		return ResponseEntity.ok(caegoriaRepository.findOne(idCategoria));
	}
	
	@RequestMapping(value = "/create", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody CreateCategoriaDTO dto) {
		return ResponseEntity.ok(categoriaService.create(dto));
	}

}
