package br.com.treinamento.ultracar.Treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Cep;

@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {
	
	@Query("Select c From Cep c "
		 + "Inner Join Fetch c.endereco e "
		 + "Inner Join Fetch e.bairros b "
		 + "Inner Join Fetch b.cidade cid "
		 + "Inner Join Fetch cid.estado e "
		 + "Where c.numero = :numero") 
	public Cep findByNumero(Integer numero);
	
}
