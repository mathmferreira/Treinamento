package br.com.treinamento.ultracar.Treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.Complemento;

@Repository
public interface ComplementoRepository extends JpaRepository<Complemento, Long> {

}
