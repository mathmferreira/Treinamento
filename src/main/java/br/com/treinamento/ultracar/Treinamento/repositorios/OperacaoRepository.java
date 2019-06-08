package br.com.treinamento.ultracar.Treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Operacao;
import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.Crud;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

	@Query("Select op From Operacao op Where op.tipoOperacao = :tipoOperacao")
	public List<Operacao> findOperacaoByTipo(Crud tipoOperacao);
	
	@Query("Select op From Operacao op Where op.descricao = :descricao")
	public List<Operacao> findOperacaoByDescricao(String descricao);
	
}
