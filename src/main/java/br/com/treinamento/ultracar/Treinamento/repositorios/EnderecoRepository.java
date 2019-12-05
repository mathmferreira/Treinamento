package br.com.treinamento.ultracar.Treinamento.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	@Query("Select e From Endereco e "
		 + "Inner Join Fetch e.bairros b "
		 + "Inner Join Fetch b.cidade c "
		 + "Inner Join Fetch c.estado uf "
		 + "Where Lower(e.logradouro) Like Lower(concat('%', concat(:logradouro, '%'))) "
		 + "And Lower(b.nome) Like Lower(concat('%', concat(:nomeBairro, '%'))) "
		 + "And Lower(c.nome) Like Lower(concat('%', concat(:nomeCidade, '%'))) "
		 + "And Lower(uf.sigla) Like Lower(concat('%', concat(:siglaUF, '%')))")
	public Endereco findByLogradouroBairroCidadeEstado(String logradouro, String nomeBairro, String nomeCidade, String siglaUF);

	@Nullable
	@Query("Select e From Endereco e "
		 + "Inner Join Fetch e.bairros b "
		 + "Inner Join Fetch b.cidade c "
		 + "Inner Join Fetch c.estado uf "
		 + "Where Lower(e.logradouro) Like Lower(concat('%', concat(:logradouro, '%'))) ")
	public Set<Endereco> findByLogradouro(String logradouro);
	
}
