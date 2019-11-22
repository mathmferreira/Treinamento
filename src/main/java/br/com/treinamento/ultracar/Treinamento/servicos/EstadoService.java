package br.com.treinamento.ultracar.Treinamento.servicos;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

	public Estado salvarEstado(EstadoDTO estadoDTO) {
		Estado estado = Estado.builder().build();
		BeanUtils.copyProperties(estadoDTO, estado);
		return this.repositorio.save(estado);
	}
	
}
