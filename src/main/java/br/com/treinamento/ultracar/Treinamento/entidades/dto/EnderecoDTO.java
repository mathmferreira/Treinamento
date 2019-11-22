package br.com.treinamento.ultracar.Treinamento.entidades.dto;

import java.io.Serializable;
import java.util.Set;

import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.TipoLocal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("serial")
public class EnderecoDTO implements Serializable {

	private Long id;
	
	private TipoLocal tipoLocal;
	
	private String logradouro;

	private Set<NumeroDTO> numeros;
	
	private Set<BairroDTO> bairros;
	
	private Set<CepDTO> ceps;
	
}
