package br.com.treinamento.ultracar.Treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.Situacao;

@Entity
@Table(name = "TB_PERMISSAO_ACESSO")
public class PermissaoAcesso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_PERMISSAO_ACESSO", nullable = false)
	private Long id;
	
	@Column(name = "EN_SITUACAO", nullable = false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	@JoinColumn(name = "ID_USUARIO")
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
}
