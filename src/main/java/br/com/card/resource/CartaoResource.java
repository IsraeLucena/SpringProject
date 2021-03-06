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

import br.com.card.dto.CreateCartaoDTO;
import br.com.card.dto.CreatePagamentoDTO;
import br.com.card.model.Cartao;
import br.com.card.repository.CartaoRepository;
import br.com.card.service.CartaoService;

@RestController
@RequestMapping(value = "/api/cartao")
public class CartaoResource {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private CartaoService cartaoService;
	
	@RequestMapping(value = "/find-all", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok(cartaoRepository.findAll());
	}
	
	@RequestMapping(value = "/find-by-id", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@Transactional
	public ResponseEntity<?> listById(@RequestParam(value = "idCartao", required = true) Long idCartao) {
		return ResponseEntity.ok(cartaoRepository.findOne(idCartao));
	}
	
	@RequestMapping(value = "/create", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody CreateCartaoDTO dto) {
		return ResponseEntity.ok(cartaoService.create(dto));
	}
	
	@RequestMapping(value = "/delete", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.DELETE)
	@Transactional
	public ResponseEntity<?> delete(@RequestParam(value = "idCartao", required = true) Long idCartao) {
		cartaoRepository.delete(idCartao);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/update", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Cartao cartao) {
		return ResponseEntity.ok(cartaoService.update(cartao));
	}

}
