package br.com.treinamento.ultracar.Treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Ponto;

@Repository
public interface PontoRespository extends JpaRepository<Ponto, Long> {
	
}
