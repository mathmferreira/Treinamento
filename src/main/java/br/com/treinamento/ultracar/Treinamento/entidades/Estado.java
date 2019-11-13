package br.com.treinamento.ultracar.Treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "TB_ESTADO")
@SuppressWarnings("serial")
public class Estado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado_sequence")
	@SequenceGenerator(name = "estado_sequence", sequenceName = "estado_id_sequence", allocationSize = 1)
	@Column(name = "ID_ESTADO", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name = "DS_SIGLA", length = 2, nullable = false)
	private String sigla;

}
