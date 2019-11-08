package br.com.treinamento.ultracar.Treinamento.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.treinamento.ultracar.Treinamento.entidades.Menu;

public interface CustomizedMenuRepository {

	public Page<Menu> findByFilter(Menu menu, Pageable pageable);
	
}
