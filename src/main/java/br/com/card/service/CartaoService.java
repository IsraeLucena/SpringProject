package br.com.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.card.CardException;
import br.com.card.dto.CreateCartaoDTO;
import br.com.card.model.Cartao;
import br.com.card.repository.CartaoRepository;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	public Cartao create(CreateCartaoDTO dto) {
		Cartao cartao = new Cartao(dto);
		cartaoRepository.save(cartao);
		
		return cartao;
	}

	public Cartao update(Cartao update) {
		Cartao cartao = cartaoRepository.findOne(update.getId());
		if (cartao != null) {
			cartao.setDiaFechamento(update.getDiaFechamento());
			cartao.setDiaPagamento(update.getDiaPagamento());
			cartao.setLimite(update.getLimite());
			cartao.setNome(update.getNome());
			
			cartaoRepository.save(cartao);
		} else {
			throw new CardException("Cartão não encontrado!");
		}
		return cartao;
	}

}
