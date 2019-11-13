package br.com.treinamento.ultracar.Treinamento.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "TB_NUMERO")
@SuppressWarnings("serial")
public class Numero implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "numero_sequence")
	@SequenceGenerator(name = "numero_sequence", sequenceName = "numero_id_sequence", allocationSize = 1)
	@Column(name = "ID_NUMERO", nullable = false)
	private Long id;
	
	@Column(name = "NM_NUMERACAO", nullable = false)
	private Integer numeracao;
	
	@Builder.Default
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "numeros")
	private Set<Endereco> enderecos = new HashSet<>();
	
}
