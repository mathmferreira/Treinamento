package br.com.treinamento.ultracar.Treinamento.entidades.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.treinamento.ultracar.Treinamento.entidades.Bairro;
import br.com.treinamento.ultracar.Treinamento.entidades.Cep;
import br.com.treinamento.ultracar.Treinamento.entidades.Complemento;
import br.com.treinamento.ultracar.Treinamento.entidades.Numero;
import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.TipoLocal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("serial")
public class EnderecoDTO implements Serializable {

	private Long id;
	
	private Bairro bairro;
	
	private TipoLocal tipoLocal;
	
	private String logradouro;

	@Builder.Default
	private Set<Numero> numeros = new HashSet<>();

	@Builder.Default
	private Set<Complemento> complementos = new HashSet<>();
	
	@Builder.Default
	private Set<Bairro> bairros = new HashSet<>();
	
	@Builder.Default
	private Set<Cep> ceps = new HashSet<>();
	
}
