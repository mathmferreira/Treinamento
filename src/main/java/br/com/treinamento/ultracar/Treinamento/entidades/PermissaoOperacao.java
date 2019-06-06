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
import javax.persistence.Table;

@Entity
@Table(name = "TB_PERMISSAO_OPERACAO")
public class PermissaoOperacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_PERMISSAO_OPERACAO", nullable = false)
	private Long id;
	
	@JoinColumn(name = "ID_OPERACAO", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Operacao operacao;
	
	@JoinColumn(name = "ID_PERMISSAO_ACESSO", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private PermissaoAcesso permissaoAcesso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public PermissaoAcesso getPermissaoAcesso() {
		return permissaoAcesso;
	}

	public void setPermissaoAcesso(PermissaoAcesso permissaoAcesso) {
		this.permissaoAcesso = permissaoAcesso;
	}
	
}
