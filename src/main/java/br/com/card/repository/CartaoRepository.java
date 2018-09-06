package br.com.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.card.model.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

}
