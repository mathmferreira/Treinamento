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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_GRUPO_ACESSO")
public class GrupoAcesso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo_acesso_sequence")
	@SequenceGenerator(name = "grupo_acesso_sequence", sequenceName = "grupo_acesso_id_sequence", allocationSize = 1)
	@Column(name = "ID_GRUPO_ACESSO", nullable = false)
	private Long id;
	
	@Column(name = "DS_DESCRICAO", length = 45, nullable = false)
	@Size(min = 5, max = 45)
	@NotBlank
	private String descricao;
	
	@JoinColumn(name = "ID_USUARIO", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
