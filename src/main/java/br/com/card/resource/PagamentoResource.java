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

import br.com.card.dto.CreatePagamentoDTO;
import br.com.card.model.Pagamento;
import br.com.card.repository.PagamentoRepository;
import br.com.card.service.PagamentoService;

@RestController
@RequestMapping(value = "/api/pagamento")
public class PagamentoResource {
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@RequestMapping(value = "/find-all", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok(pagamentoRepository.findAll());
	}
	
	@RequestMapping(value = "/find-by-id", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<?> listById(@RequestParam(value = "idPagamento", required = true) Long idPagamento) {
		return ResponseEntity.ok(pagamentoRepository.findOne(idPagamento));
	}
	
	@RequestMapping(value = "/create", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody CreatePagamentoDTO dto) {
		return ResponseEntity.ok(pagamentoService.create(dto));
	}
	
	@RequestMapping(value = "/delete", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.DELETE)
	@Transactional
	public ResponseEntity<?> delete(@RequestParam(value = "idPagamento", required = true) Long idPagamento) {
		pagamentoRepository.delete(idPagamento);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "update", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Pagamento pagamento) {
		return ResponseEntity.ok(pagamentoService.update(pagamento));
	}

}
