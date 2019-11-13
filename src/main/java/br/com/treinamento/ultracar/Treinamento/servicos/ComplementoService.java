package br.com.treinamento.ultracar.Treinamento.servicos;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.treinamento.ultracar.Treinamento.entidades.Complemento;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.ComplementoDTO;
import br.com.treinamento.ultracar.Treinamento.repositorios.ComplementoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ComplementoService {

	@Autowired
	private ComplementoRepository repositorio;
	
	public Complemento salvarComplemento(ComplementoDTO complementoDTO) {
		Complemento complemento = Complemento.builder().build();
		BeanUtils.copyProperties(complementoDTO, complemento);
		return this.repositorio.save(complemento);
	}
	
}
