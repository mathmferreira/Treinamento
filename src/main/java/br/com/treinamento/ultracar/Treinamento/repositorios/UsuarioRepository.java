package br.com.treinamento.ultracar.Treinamento.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Nullable
	@Query("Select u From Usuario u Where u.login = :login")
	public Usuario findByLogin(String login);
	
	@Query("Select u From Usuario u")
	public Page<Usuario> findAll(Pageable pageable); 
	
}
