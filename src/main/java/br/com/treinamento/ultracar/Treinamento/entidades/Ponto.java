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

@Entity
@Table(name = "TB_PONTO")
public class Ponto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ponto_sequence")
	@SequenceGenerator(name = "ponto_sequence", sequenceName = "ponto_id_sequence", allocationSize = 1)
	@Column(name = "ID_PONTO", nullable = false)
	private Long id;
	
	@JoinColumn(name = "ID_ENDERECO", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Endereco endereco;

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
	
}
