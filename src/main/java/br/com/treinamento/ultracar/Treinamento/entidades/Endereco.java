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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.TipoLocal;

@Entity
@Table(name = "ID_ENDERECO")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_sequence")
	@SequenceGenerator(name = "endereco_sequence", sequenceName = "endereco_id_sequence", allocationSize = 1)
	@Column(name = "ID_ENDERECO", nullable = false)
	private Long id;
	
	@NotNull
	@JoinColumn(name = "ID_BAIRRO", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Bairro bairro;
	
	@NotNull
	@Column(name = "EN_TIPO_LOCAL", length = 15, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoLocal tipoLocal;
	
	@Column(name = "DS_LOGRADOURO", length = 128, nullable = false)
	@Size(min = 5, max = 128)
	private String logradouro;

	@NotNull
	@Column(name = "NM_NUMERO", nullable = false)
	private Integer numero;
	
	@Column(name = "DS_COMPLEMENTO", length = 255)
	private String complemento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public TipoLocal getTipoLocal() {
		return tipoLocal;
	}

	public void setTipoLocal(TipoLocal tipoLocal) {
		this.tipoLocal = tipoLocal;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
