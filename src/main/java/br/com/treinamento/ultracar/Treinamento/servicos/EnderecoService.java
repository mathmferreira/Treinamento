package br.com.treinamento.ultracar.Treinamento.servicos;

import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.treinamento.ultracar.Treinamento.entidades.Endereco;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.EnderecoDTO;
import br.com.treinamento.ultracar.Treinamento.repositorios.EnderecoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EnderecoService {

	@Autowired
	private EnderecoRepository repositorio;
	
	public Endereco checkAndSave(Endereco endereco) {
		Example<Endereco> filtro = Example.of(endereco, ExampleMatcher.matchingAll().withIgnoreCase());
		if (this.repositorio.exists(filtro)) {
			return this.repositorio.findAll(filtro).stream().findFirst().orElse(null);
		} else {
			return this.repositorio.save(endereco);
		}
	}
	
	public Endereco salvarEndereco(EnderecoDTO endDTO) {
		Endereco endereco = Endereco.builder().build();
		BeanUtils.copyProperties(endDTO, endereco);
		return this.repositorio.save(endereco);
	}
	
	public Set<Endereco> findByLogradouro(String logradouro) {
		return this.repositorio.findByLogradouro(logradouro);
	}
	
	public Endereco findByLogradouroBairroCidadeEstado(String logradouro, String nomeBairro, String nomeCidade, String siglaUF) {
		return this.repositorio.findByLogradouroBairroCidadeEstado(logradouro, nomeBairro, nomeCidade, siglaUF);
	}
	
}
