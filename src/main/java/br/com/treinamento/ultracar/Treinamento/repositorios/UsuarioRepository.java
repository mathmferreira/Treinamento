package br.com.treinamento.ultracar.Treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Operacao;
import br.com.treinamento.ultracar.Treinamento.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("Select u From Usuario u Where u.login = :login")
	public Usuario findUsuarioByLogin(String login);
	
	@Query("Select operacoes From Usuario u "
		 + "Inner Join u.permissaoAcesso pa "
		 + "Inner Join pa.operacoes operacoes "
		 + "Where u = :usuario")
	public List<Operacao> findOperacaoByUsuario(Usuario usuario);
	
}
