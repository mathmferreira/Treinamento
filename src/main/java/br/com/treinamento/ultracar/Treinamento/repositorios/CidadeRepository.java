package br.com.treinamento.ultracar.Treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Cidade;
import br.com.treinamento.ultracar.Treinamento.entidades.Estado;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	@Query("Select c From Cidade c Where Lower(c.nome) Like Lower(concat('%', concat(?1, '%')))")
	public List<Cidade> findByNome(String nome);
	
	@Query("Select c From Cidade c Where c.estado = :estado")
	public List<Cidade> findByEstado(Estado estado);
	
	@Query("Select c From Cidade "
		 + "Inner Join c.estado e "
		 + "Where e.id = :idEstado")
	public Cidade findByNomeEstado(String nome, Long idEstado);
	
}
