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

import br.com.card.dto.CreateTipoPagamentoDTO;
import br.com.card.repository.TipoPagamentoRepository;
import br.com.card.service.TipoPagamentoService;

@RestController
@RequestMapping(value = "/api/tipo-pagamento")
public class TipoPagamentoResource {
	
	@Autowired
	private TipoPagamentoRepository tipoPagamentoRepository;
	
	@Autowired
	private TipoPagamentoService tipoPagamentoService;
	
	@RequestMapping(value = "/find-all", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok(tipoPagamentoRepository.findAll());
	}
	
	@RequestMapping(value = "/find-by-id", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<?> listById(@RequestParam(value = "idTipoPagamento", required = true) Long idTipoPagamento) {
		return ResponseEntity.ok(tipoPagamentoRepository.findOne(idTipoPagamento));
	}
	
	@RequestMapping(value = "/create", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody CreateTipoPagamentoDTO dto) {
		return ResponseEntity.ok(tipoPagamentoService.create(dto));
	}

}
