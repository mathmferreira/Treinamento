package br.com.treinamento.ultracar.Treinamento.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "TB_BAIRRO")
@SuppressWarnings("serial")
public class Bairro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bairro_sequence")
	@SequenceGenerator(name = "bairro_sequence", sequenceName = "bairro_id_sequence", allocationSize = 1)
	@Column(name = "ID_BAIRRO", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name = "DS_NOME", length = 100, nullable = false)
	@Size(max = 100)
	private String nome;
	
	@NotNull
	@JoinColumn(name = "ID_CIDADE", nullable = false, foreignKey = @ForeignKey(name = "fk_bairro_cidade"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Cidade cidade;
	
	@Builder.Default
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bairros")
	private Set<Endereco> enderecos = new HashSet<>();

}
