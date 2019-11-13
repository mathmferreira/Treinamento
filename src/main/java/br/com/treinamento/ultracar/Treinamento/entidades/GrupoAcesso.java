package br.com.treinamento.ultracar.Treinamento.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "TB_GRUPO_ACESSO")
@SuppressWarnings("serial")
public class GrupoAcesso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo_acesso_sequence")
	@SequenceGenerator(name = "grupo_acesso_sequence", sequenceName = "grupo_acesso_id_sequence", allocationSize = 1)
	@Column(name = "ID_GRUPO_ACESSO", nullable = false)
	private Long id;
	
	@Column(name = "DS_DESCRICAO", length = 45, nullable = false)
	@Size(min = 5, max = 45)
	private String descricao;
	
	@NotNull
	@JoinColumn(name = "ID_USUARIO", nullable = false, foreignKey = @ForeignKey(name = "fk_grupo_acesso_usuario"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoAcesso")
	private Set<PermissaoAcesso> permissoesAcesso = new HashSet<>();

}
