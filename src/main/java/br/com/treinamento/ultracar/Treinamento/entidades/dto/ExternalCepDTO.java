package br.com.treinamento.ultracar.Treinamento.entidades.dto;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@SuppressWarnings("serial")
public class ExternalCepDTO implements Serializable {

	private String uf;
	private String cidade;
	private String bairro;
	private String tipoLogradouro;
	private String logradouro;
	
}
