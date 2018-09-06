package br.com.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.card.dto.CreateTipoPagamentoDTO;
import br.com.card.model.TipoPagamento;
import br.com.card.repository.TipoPagamentoRepository;

@Service
public class TipoPagamentoService {

	@Autowired
	private TipoPagamentoRepository tipoPagamentoRepository;

	public TipoPagamento create(CreateTipoPagamentoDTO dto) {
		TipoPagamento tipoPagamento = new TipoPagamento(dto);
		
		tipoPagamentoRepository.save(tipoPagamento);
		
		return tipoPagamento;
	}
	
}
