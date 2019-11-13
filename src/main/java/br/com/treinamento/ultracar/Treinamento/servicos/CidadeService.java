package br.com.treinamento.ultracar.Treinamento.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.treinamento.ultracar.Treinamento.entidades.Cidade;
import br.com.treinamento.ultracar.Treinamento.repositorios.CidadeRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CidadeService {

	@Autowired
	private CidadeRepository repositorio;
	
	public Cidade salvarCidade(Cidade cidade) {
		return this.repositorio.save(cidade);
	}
	
}
