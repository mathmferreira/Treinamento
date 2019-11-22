package br.com.treinamento.ultracar.Treinamento.entidades.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("serial")
public class BairroDTO implements Serializable {

	private Long id;
	
	private String nome;
	
	private CidadeDTO cidade;
	
	@JsonBackReference
	private Set<EnderecoDTO> enderecos;
	
}
