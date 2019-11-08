package br.com.treinamento.ultracar.Treinamento.repositorios.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.treinamento.ultracar.Treinamento.entidades.Menu;
import br.com.treinamento.ultracar.Treinamento.repositorios.CustomizedMenuRepository;

public class CustomizedMenuRepositoryImpl implements CustomizedMenuRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Menu> findByFilter(Menu menu, Pageable pageable) {
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> parameters = new HashMap<>();
		return null;
	}

}
