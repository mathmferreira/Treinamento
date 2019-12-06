package br.com.treinamento.ultracar.Treinamento.servicos;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.treinamento.ultracar.Treinamento.entidades.Estado;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.EstadoDTO;
import br.com.treinamento.ultracar.Treinamento.repositorios.EstadoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EstadoService {

	@Autowired
	private EstadoRepository repositorio;
	
	public Estado checkAndSave(Estado estado) {
		if (this.repositorio.exists(Example.of(estado, ExampleMatcher.matchingAll().withIgnoreCase()))) {
			return this.repositorio.findBySigla(estado.getSigla());
		} else {
			return this.repositorio.save(estado);
		}
	}

	public Estado salvarEstado(EstadoDTO estadoDTO) {
		Estado estado = Estado.builder().build();
		BeanUtils.copyProperties(estadoDTO, estado);
		return this.repositorio.save(estado);
	}
	
	public boolean exists(Example<Estado> example) {
		return this.repositorio.exists(example);
	}
	
	public Estado findBySigla(String sigla) {
		return this.repositorio.findBySigla(StringUtils.upperCase(sigla));
	}
	
}
