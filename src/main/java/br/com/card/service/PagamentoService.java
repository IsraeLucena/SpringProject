package br.com.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.card.CardException;
import br.com.card.dto.CreatePagamentoDTO;
import br.com.card.model.Pagamento;
import br.com.card.repository.CartaoRepository;
import br.com.card.repository.CategoriaRepository;
import br.com.card.repository.ContaRepository;
import br.com.card.repository.PagamentoRepository;
import br.com.card.repository.TipoPagamentoRepository;
import br.com.card.repository.UsuarioRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private TipoPagamentoRepository tipoPagamentoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Transactional
	public Pagamento create(CreatePagamentoDTO dto) {
		Pagamento pagamento = new Pagamento(dto);
		pagamento.setCategoria(categoriaRepository.findOne(dto.idCategoria));
		pagamento.setConta(contaRepository.findOne(dto.idConta));
		pagamento.setTipoPagamento(tipoPagamentoRepository.findOne(dto.idTipoPagamento));
		pagamento.setUsuario(usuarioRepository.findOne(dto.idUsuario));
		pagamento.setCartao(cartaoRepository.findOne(dto.idCartao));
		
		pagamentoRepository.save(pagamento);
		
		return pagamento;
	}

	@Transactional
	public Pagamento update(Pagamento update) {
		Pagamento pagamento = pagamentoRepository.findOne(update.getId());
		if (pagamento != null) {
			pagamento.setCartao(update.getCartao());
			pagamento.setCategoria(update.getCategoria());
			pagamento.setConta(update.getConta());
			pagamento.setDescricao(update.getDescricao());
			pagamento.setQtdParcelas(update.getQtdParcelas());
			pagamento.setTipoPagamento(update.getTipoPagamento());
			pagamento.setUsuario(update.getUsuario());
			pagamento.setValor(update.getValor());
			pagamento.setVencimento(update.getVencimento());
			
			pagamentoRepository.save(pagamento);
		} else {
			throw new CardException("Pagamento não encontrado!");
		}
		return pagamento;
	}

}
