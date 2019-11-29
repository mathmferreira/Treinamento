package br.com.treinamento.ultracar.Treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	@Query("Select e From Estado e Where e.sigla = :sigla Limit 1")
	public Estado findBySigla(String sigla);
	
}
