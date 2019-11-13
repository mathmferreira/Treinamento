package br.com.treinamento.ultracar.Treinamento.servicos;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Endereco salvarEndereco(EnderecoDTO endDTO) {
		Endereco endereco = Endereco.builder().build();
		BeanUtils.copyProperties(endDTO, endereco);
		return this.repositorio.save(endereco);
	}
	
}
