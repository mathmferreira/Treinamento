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
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "TB_COMPLEMENTO")
@SuppressWarnings("serial")
public class Complemento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complemento_sequence")
	@SequenceGenerator(name = "complemento_sequence", sequenceName = "complemento_id_sequence", allocationSize = 1)
	@Column(name = "ID_COMPLEMENTO", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name = "DS_DESCRICAO", length = 255, nullable = false)
	private String descricao;
	
	@Builder.Default
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "complementos")
	private Set<Endereco> enderecos = new HashSet<>();
	
}
