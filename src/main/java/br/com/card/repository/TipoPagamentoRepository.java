package br.com.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.card.model.TipoPagamento;

@Repository
public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Long> {

}
