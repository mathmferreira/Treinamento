package br.com.treinamento.ultracar.Treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.PermissaoAcesso;
import br.com.treinamento.ultracar.Treinamento.entidades.Usuario;
import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.Situacao;

@Repository
public interface PermissaoAcessoRepository extends JpaRepository<PermissaoAcesso, Long> {

	@Query("Select pa From PermissaoAcesso pa "
		 + "Inner Join pa.usuario u "
		 + "Where u = :usuario")
	public List<PermissaoAcesso> findPermissaoAcessoByUsuario(Usuario usuario);
	
	@Query("Select pa From PermissaoAcesso pa Where pa.situacao = :situacao")
	public List<PermissaoAcesso> findPermissaoAcessoBySituacao(Situacao situacao);
	
}
