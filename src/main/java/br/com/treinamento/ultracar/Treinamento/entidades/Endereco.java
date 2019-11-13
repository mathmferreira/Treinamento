package br.com.treinamento.ultracar.Treinamento.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.TipoLocal;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "TB_ENDERECO")
@SuppressWarnings("serial")
public class Endereco implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_sequence")
	@SequenceGenerator(name = "endereco_sequence", sequenceName = "endereco_id_sequence", allocationSize = 1)
	@Column(name = "ID_ENDERECO", nullable = false)
	private Long id;
	
	@NotNull
	@Column(name = "EN_TIPO_LOCAL", length = 15, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoLocal tipoLocal;
	
	@Column(name = "DS_LOGRADOURO", length = 128, nullable = false)
	@Size(min = 5, max = 128)
	private String logradouro;

	@Builder.Default
	@JoinTable(name = "TB_ENDERECO_NUMERO", joinColumns = {
	@JoinColumn(name = "ID_ENDERECO", nullable = false, foreignKey = @ForeignKey(name = "fk_endereco_endereco_numero")) }, inverseJoinColumns = {
	@JoinColumn(name = "ID_NUMERO", nullable = false, foreignKey = @ForeignKey(name = "fk_numero_endereco_numero")) })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Numero> numeros = new HashSet<>();

	@Builder.Default
	@JoinTable(name = "TB_ENDERECO_COMPLEMENTO", joinColumns = {
	@JoinColumn(name = "ID_ENDERECO") }, inverseJoinColumns = {
	@JoinColumn(name = "ID_COMPLEMENTO") })
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Complemento> complementos = new HashSet<>();
	
	@Builder.Default
	@JoinTable(name = "TB_ENDERECO_BAIRRO", joinColumns = {
	@JoinColumn(name = "ID_ENDERECO", foreignKey = @ForeignKey(name = "fk_endereco_endereco_bairro")) }, inverseJoinColumns = {
	@JoinColumn(name = "ID_BAIRROID_ENDERECO", foreignKey = @ForeignKey(name = "fk_bairro_endereco_bairro")) })
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Bairro> bairros = new HashSet<>();
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "endereco")
	private Set<Cep> ceps = new HashSet<>();

}
