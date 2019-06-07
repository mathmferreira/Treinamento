package br.com.treinamento.ultracar.Treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.Crud;

@Entity
@Table(name = "TB_OPERACAO")
public class Operacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operacao_sequence")
	@SequenceGenerator(name = "operacao_sequence", sequenceName = "operacao_id_sequence", allocationSize = 1)
	@Column(name = "ID_OPERACAO", nullable = false)
	private Long id;
	
	@Column(name = "DS_DESCRICAO", length = 45, nullable = false)
	@Size(max = 45)
	@NotBlank
	private String descricao;
	
	@Column(name = "EN_OPERACAO", length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Crud operacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Crud getOperacao() {
		return operacao;
	}

	public void setOperacao(Crud operacao) {
		this.operacao = operacao;
	}
	
}
