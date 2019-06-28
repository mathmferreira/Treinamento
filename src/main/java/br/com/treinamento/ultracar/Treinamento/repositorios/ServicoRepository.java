package br.com.treinamento.ultracar.Treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Servico;
import br.com.treinamento.ultracar.Treinamento.entidades.Solicitante;
import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.Crud;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

	@Async
	@Query("Select s From Servico s "
		 + "Inner Join s.operacao o "
		 + "o.tipoOperacao = :tipoOperacao")
	public List<Servico> findByTipoOperacao(Crud tipoOperacao);
	
	//gitpublic void updateBySolicitante(Long idSol);
	
}
