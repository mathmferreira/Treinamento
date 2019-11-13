package br.com.treinamento.ultracar.Treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Cep;

@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {

}
