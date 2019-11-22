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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "TB_COMPLEMENTO")
@SuppressWarnings("serial")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Complemento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complemento_sequence")
	@SequenceGenerator(name = "complemento_sequence", sequenceName = "complemento_id_sequence", allocationSize = 1)
	@Column(name = "ID_COMPLEMENTO", nullable = false)
	private Long id;

	@Column(name = "NM_NUMERO", nullable = false)
	private Integer numero;
	
	@Column(name = "DS_DESCRICAO", length = 255)
	private String descricao;
	
	@JsonManagedReference
	@JoinColumn(name = "ID_ENDERECO", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Endereco endereco;
	
}
