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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ID_ENDERECO")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_ENDERECO", nullable = false)
	private Long id;
	
	@JoinColumn(name = "ID_BAIRRO", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private Bairro bairro;
	
	@Column(name = "DS_TIPO_LOCAL", length = 15, nullable = false)
	@Size(max = 15)
	@NotBlank
	private String tipoLocal;
	
	@Column(name = "DS_LOGRADOURO", length = 128, nullable = false)
	@Size(max = 128)
	@NotBlank
	private String logradouro;
	
	@Column(name = "NR_NUMERO", nullable = false)
	@NotNull
	private Integer numero;
	
	@Column(name = "DS_COMPLEMENTO", length = 255)
	@Size(max = 255)
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

	public String getTipoLocal() {
		return tipoLocal;
	}

	public void setTipoLocal(String tipoLocal) {
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
