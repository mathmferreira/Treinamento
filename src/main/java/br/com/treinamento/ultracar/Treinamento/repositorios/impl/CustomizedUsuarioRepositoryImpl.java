package br.com.treinamento.ultracar.Treinamento.repositorios.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;

import br.com.treinamento.ultracar.Treinamento.entidades.Usuario;
import br.com.treinamento.ultracar.Treinamento.repositorios.CustomizedUsuarioRepository;

public class CustomizedUsuarioRepositoryImpl implements CustomizedUsuarioRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Usuario> findByFilter(Usuario usuario, Pageable pageable) {
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> parameters = new HashMap<>();
		jpql.append("Select usuario From Usuario usuario ");
		jpql.append("Inner Join Fetch usuario.permissoesAcesso permissao ");
		jpql.append("Where 1=1 ");
		
		if (StringUtils.isNotBlank(usuario.getLogin())) {
			jpql.append("And usuario.login = :login ");
			parameters.put("login", usuario.getLogin());
		}
		
		if (!CollectionUtils.isEmpty(usuario.getPermissoesAcesso())) {
			jpql.append("And permissao.id In = (:ids) ");
			parameters.put("ids", usuario.getPermissoesAcesso()
					.parallelStream()
					.filter(p -> Objects.nonNull(p.getId()))
					.map(p -> String.valueOf(p.getId()))
					.collect(Collectors.joining(", ")));
			
		}
		
		TypedQuery<Usuario> query = this.manager.createQuery(jpql.toString(), Usuario.class);
		
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		query.setFirstResult(pageable.getPageNumber());
		query.setMaxResults(pageable.getPageSize());
		
		return new PageImpl<>(query.getResultList());
	}

}
