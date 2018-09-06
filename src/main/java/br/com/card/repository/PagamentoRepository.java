package br.com.card.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.card.model.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Serializable> {

}
