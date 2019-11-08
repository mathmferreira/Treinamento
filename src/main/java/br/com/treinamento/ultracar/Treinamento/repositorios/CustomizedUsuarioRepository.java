package br.com.treinamento.ultracar.Treinamento.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.treinamento.ultracar.Treinamento.entidades.Usuario;

public interface CustomizedUsuarioRepository {

	public Page<Usuario> findByFilter(Usuario usuario, Pageable pageable);
	
}
