package br.com.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.card.CardException;
import br.com.card.dto.CreateContaDTO;
import br.com.card.model.Conta;
import br.com.card.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;

	public Object create(CreateContaDTO dto) {
		Conta conta = new Conta(dto);
		
		contaRepository.save(conta);
		
		return conta;
	}

	public Conta update(Conta update) {
		Conta conta = contaRepository.findOne(update.getId());
		if (conta != null) {
			conta.setNome(update.getNome());
			conta.setSaldo(update.getSaldo());
			
			contaRepository.save(conta);
		} else {
			throw new CardException("Conta não encontrada!");
		}
		return conta;
	}

}
