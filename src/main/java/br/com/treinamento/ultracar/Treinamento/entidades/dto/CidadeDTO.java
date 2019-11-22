package br.com.treinamento.ultracar.Treinamento.entidades.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("serial")
public class CidadeDTO implements Serializable {

	private Long id;
	private String nome;
	private EstadoDTO estado;

}
