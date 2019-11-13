package br.com.treinamento.ultracar.Treinamento.servicos;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.treinamento.ultracar.Treinamento.entidades.Numero;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.NumeroDTO;
import br.com.treinamento.ultracar.Treinamento.repositorios.NumeroRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class NumeroService {

	@Autowired
	private NumeroRepository repositorio;
	
	public Numero salvarNumero(NumeroDTO numeroDTO) {
		Numero numero = Numero.builder().build();
		BeanUtils.copyProperties(numeroDTO, numero);
		return this.repositorio.save(numero);
	}
	
}
