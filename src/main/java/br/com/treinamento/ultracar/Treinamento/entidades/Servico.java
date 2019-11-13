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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "TB_SERVICO")
@SuppressWarnings("serial")
public class Servico implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "servico_sequence", sequenceName = "servico_id_sequence", allocationSize = 1)
	@Column(name = "ID_SERVICO", nullable = false)
	private Long id;
	
	@NotNull
	@JoinColumn(name = "ID_ENDERECO", nullable = false, foreignKey = @ForeignKey(name = "fk_servico_endereco"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Endereco endereco;
	
	@NotNull
	@JoinColumn(name = "ID_SOLICITANTE", nullable = false, foreignKey = @ForeignKey(name = "fk_servico_solicitante"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Solicitante solicitante;
	
	@Builder.Default
	@JoinTable(name = "TB_SERVICO_OPERACAO", joinColumns = {
	@JoinColumn(name = "ID_SERVICO", foreignKey = @ForeignKey(name = "fk_servico_operacao_servico"))}, inverseJoinColumns = {
	@JoinColumn(name = "ID_OPERACAO", foreignKey = @ForeignKey(name = "fk_servico_operacao_operacao"))})
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Operacao> operacoes = new HashSet<>();

}
