package br.com.treinamento.ultracar.Treinamento.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Bairro;
import br.com.treinamento.ultracar.Treinamento.entidades.Cidade;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

	@Query("Select b From Bairro b Where b.nome = :nome")
	public Bairro findByNome(String nome);
	
	@Query("Select b From Bairro b Where b.cidade = ?1")
	public Set<Bairro> findByCidade(Cidade cidade);
	
	@Query("Select b From Bairro "
		 + "Inner Join b.cidade c "
		 + "Where b.nome =: nome "
		 + "And c.id = :idCidade")
	public Bairro findByNomeCidade(String nome, Long idCidade);
	
}
