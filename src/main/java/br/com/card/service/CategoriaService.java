package br.com.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.card.dto.CreateCategoriaDTO;
import br.com.card.model.Categoria;
import br.com.card.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Object create(CreateCategoriaDTO dto) {
		Categoria categoria = new Categoria(dto);
		
		categoriaRepository.save(categoria);
		
		return categoria;
	}

}
