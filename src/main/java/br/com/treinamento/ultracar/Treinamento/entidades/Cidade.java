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
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "TB_CIDADE")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@SuppressWarnings("serial")
public class Cidade implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade_sequence")
	@SequenceGenerator(name = "cidade_sequence", sequenceName = "cidade_id_sequence", allocationSize = 1)
	@Column(name = "ID_CIDADE", nullable = false)
	private Long id;
	
	@Column(name = "DS_NOME", length = 38, nullable = false)
	@Size(min = 5, max = 38)
	private String nome;

	@NotNull
	@JoinColumn(name = "ID_ESTADO", nullable = false, foreignKey = @ForeignKey(name = "fk_cidade_estado"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Estado estado;

}
