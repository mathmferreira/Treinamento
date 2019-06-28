package br.com.treinamento.ultracar.Treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Cidade;
import br.com.treinamento.ultracar.Treinamento.entidades.Ponto;

@Repository
public interface PontoRespository extends JpaRepository<Ponto, Long> {
	
	@Modifying
	@Query("Delete From Ponto p "
		 + "Inner Join p.endereco e "
		 + "Inner Join e.bairro b "
		 + "Inner Join b.cidade c "
		 + "Where c = :cidade")
	public void deleteByCidade(Cidade cidade);
	
}
