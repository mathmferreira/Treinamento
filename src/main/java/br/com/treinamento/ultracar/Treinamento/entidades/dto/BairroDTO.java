package br.com.treinamento.ultracar.Treinamento.entidades.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.treinamento.ultracar.Treinamento.entidades.Cidade;
import br.com.treinamento.ultracar.Treinamento.entidades.Endereco;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("serial")
public class BairroDTO implements Serializable {

	private Long id;
	
	private String nome;
	
	private Cidade cidade;
	
	@Builder.Default
	private Set<Endereco> enderecos = new HashSet<>();
	
}
