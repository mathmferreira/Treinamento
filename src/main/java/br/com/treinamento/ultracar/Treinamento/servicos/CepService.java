package br.com.treinamento.ultracar.Treinamento.servicos;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.treinamento.ultracar.Treinamento.entidades.Cep;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.CepDTO;
import br.com.treinamento.ultracar.Treinamento.repositorios.CepRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CepService {

	@Autowired
	private CepRepository repositorio;
	
	public Cep salvarCep(CepDTO cepDTO) {
		Cep cep = Cep.builder().build();
		BeanUtils.copyProperties(cepDTO, cep);
		return this.repositorio.save(cep);
	}
	
	public Cep findOne(Long id) {
		return this.repositorio.getOne(id);
	}
	
	public Cep findByNumero(Integer numero) {
		return this.repositorio.findByNumero(numero);
	}
	
}
