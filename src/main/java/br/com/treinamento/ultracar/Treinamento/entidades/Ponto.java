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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "TB_PONTO")
@SuppressWarnings("serial")
public class Ponto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ponto_sequence")
	@SequenceGenerator(name = "ponto_sequence", sequenceName = "ponto_id_sequence", allocationSize = 1)
	@Column(name = "ID_PONTO", nullable = false)
	private Long id;
	
	@NotNull
	@JoinColumn(name = "ID_ENDERECO", nullable = false, foreignKey = @ForeignKey(name = "fk_ponto_endereco"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Endereco endereco;

}
