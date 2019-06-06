package br.com.treinamento.ultracar.Treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_OPERACAO")
public class Operacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_OPERACAO", nullable = false)
	private Long id;
	
	@Column(name = "DS_DESCRICAO", length = 45)
	@Size(max = 45)
	@NotBlank
	private String descricao;
	
	@Column(name = "LG_INCLUIR", nullable = false)
	@NotNull
	private boolean incluir;
	
	@Column(name = "LG_ALTERAR", nullable = false)
	@NotNull
	private boolean alterar;
	
	@Column(name = "LG_EXCLUIR", nullable = false)
	@NotNull
	private boolean excluir;
	
	@Column(name = "LG_VISUALIZAR", nullable = false)
	@NotNull
	private boolean visualizar;

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

	public boolean isIncluir() {
		return incluir;
	}

	public void setIncluir(boolean incluir) {
		this.incluir = incluir;
	}

	public boolean isAlterar() {
		return alterar;
	}

	public void setAlterar(boolean alterar) {
		this.alterar = alterar;
	}

	public boolean isExcluir() {
		return excluir;
	}

	public void setExcluir(boolean excluir) {
		this.excluir = excluir;
	}

	public boolean isVisualizar() {
		return visualizar;
	}

	public void setVisualizar(boolean visualizar) {
		this.visualizar = visualizar;
	}
	
}
