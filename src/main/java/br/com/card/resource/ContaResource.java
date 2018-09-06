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

import br.com.card.dto.CreateContaDTO;
import br.com.card.model.Conta;
import br.com.card.repository.ContaRepository;
import br.com.card.service.ContaService;

@RestController
@RequestMapping(value = "/api/conta")
public class ContaResource {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ContaService contaService;
	
	@RequestMapping(value = "/find-all", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok(contaRepository.findAll());
	}
	
	@RequestMapping(value = "/find-by-id", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<?> listById(@RequestParam(value = "idConta", required = true) Long idConta) {
		return ResponseEntity.ok(contaRepository.findOne(idConta));
	}
	
	@RequestMapping(value = "/create", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody CreateContaDTO dto) {
		return ResponseEntity.ok(contaService.create(dto));
	}
	
	@RequestMapping(value = "/delete", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.DELETE)
	@Transactional
	public ResponseEntity<?> delete(@RequestParam(value = "idConta", required = true) Long idConta) {
		contaRepository.delete(idConta);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/update", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Conta conta) {
		return ResponseEntity.ok(contaService.update(conta));
	}

}
