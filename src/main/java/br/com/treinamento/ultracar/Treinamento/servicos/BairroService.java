package br.com.treinamento.ultracar.Treinamento.servicos;

import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.treinamento.ultracar.Treinamento.entidades.Bairro;
import br.com.treinamento.ultracar.Treinamento.entidades.Cidade;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.BairroDTO;
import br.com.treinamento.ultracar.Treinamento.repositorios.BairroRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BairroService {

	@Autowired
	private BairroRepository repositorio;
	
	public Bairro checkAndSave(Bairro bairro) {
		if (this.repositorio.exists(Example.of(bairro, ExampleMatcher.matchingAny().withIgnoreCase()))) {
			return this.repositorio.findByNomeCidade(bairro.getNome(), bairro.getCidade().getId());
		} else {
			return this.repositorio.save(bairro);
		}
	}
	
	public Bairro salvarBairro(BairroDTO bairroDTO) {
		Bairro bairro = Bairro.builder().build();
		BeanUtils.copyProperties(bairroDTO, bairro);
		return this.repositorio.save(bairro);
	}
	
	public Set<Bairro> findByCidade(Cidade cidade) {
		return this.repositorio.findByCidade(cidade);
	}
	
}
