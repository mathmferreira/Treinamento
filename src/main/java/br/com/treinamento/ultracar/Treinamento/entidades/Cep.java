package br.com.treinamento.ultracar.Treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "TB_CEP")
@SuppressWarnings("serial")
public class Cep implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cep_sequence")
	@SequenceGenerator(name = "cep_sequence", sequenceName = "cep_id_sequence", allocationSize = 1)
	@Column(name = "ID_CEP", nullable = false)
	private Long id;
	
	@Column(name = "NM_NUMERO", nullable = false)
	private Integer numero;
	
	@JoinColumn(name = "ID_ENDERECO")
	@ManyToOne(fetch = FetchType.LAZY)
	private Endereco endereco;
	
}
