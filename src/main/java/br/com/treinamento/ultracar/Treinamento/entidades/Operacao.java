package br.com.treinamento.ultracar.Treinamento.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.Crud;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "TB_OPERACAO")
@SuppressWarnings("serial")
public class Operacao implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operacao_sequence")
	@SequenceGenerator(name = "operacao_sequence", sequenceName = "operacao_id_sequence", allocationSize = 1)
	@Column(name = "ID_OPERACAO", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name = "DS_DESCRICAO", length = 45, nullable = false)
	@Size(max = 45)
	private String descricao;
	
	@NotNull
	@Column(name = "EN_TIPO_OPERACAO", length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	private Crud tipoOperacao;
	
	@Builder.Default
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "operacoes")
	private Set<PermissaoAcesso> permissoesAcesso = new HashSet<>();
	
	@Builder.Default
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "operacoes")
	private Set<Servico> servicos = new HashSet<>();

}
