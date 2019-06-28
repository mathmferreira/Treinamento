package br.com.treinamento.ultracar.Treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Operacao;
import br.com.treinamento.ultracar.Treinamento.entidades.Usuario;
import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.Crud;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

	@Query("Select op From Operacao op Where op.tipoOperacao = :tipoOperacao")
	public List<Operacao> findByTipo(Crud tipoOperacao);
	
	@Query("Select op From Operacao op Where op.descricao = :descricao")
	public List<Operacao> findByDescricao(String descricao);
	
	@Query("Select op From Operacao op "
		 + "Inner Join op.permissoesAcesso pa "
		 + "Inner Join pa.usuario u "
		 + "Where u = :usuario")
	public List<Operacao> findByUsuario(Usuario usuario);
	
}
