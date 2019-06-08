package br.com.treinamento.ultracar.Treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_SERVICO")
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

}
