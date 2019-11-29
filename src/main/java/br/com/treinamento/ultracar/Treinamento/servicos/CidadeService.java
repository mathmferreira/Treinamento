package br.com.treinamento.ultracar.Treinamento.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
	
	public Cidade checkAndSave(Cidade cidade) {
		if (this.repositorio.exists(Example.of(cidade, ExampleMatcher.matchingAny().withIgnoreCase()))) {
			return this.repositorio.findByNomeEstado(cidade.getNome(), cidade.getEstado().getId());
		} else {
			return this.repositorio.save(cidade);
		}
	}
	
	public Cidade salvarCidade(Cidade cidade) {
		return this.repositorio.save(cidade);
	}
	
	public Cidade findByNome(String nome) {
		return this.repositorio.findByNome(nome).stream().findFirst().orElse(Cidade.builder().build());
	}
	
	public Cidade findByNomeEstado(String nome, Long idEstado) {
		return this.repositorio.findByNomeEstado(nome, idEstado);
	}
	
	public boolean exists(Example<Cidade> example) {
		return this.repositorio.exists(example);
	}
	
}
