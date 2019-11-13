package br.com.treinamento.ultracar.Treinamento.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.Situacao;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "TB_USUARIO")
@SuppressWarnings("serial")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
	@SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_id_sequence", allocationSize = 1)
	@Column(name = "ID_USUARIO", nullable = false)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 45)
	@Column(name = "DS_LOGIN", length = 45, nullable = false, unique = true)
	private String login;
	
	@NotBlank
	@Size(min = 5, max = 45)
	@Column(name = "DS_SENHA", length = 45, nullable = false)
	private String senha;
	
	@NotBlank
	@Size(min = 3, max = 45)
	@Column(name = "DS_EMAIL", length = 45)
	private String email;
	
	@NotNull
	@Column(name = "DT_ULTIMO_ACESSO", nullable = false)
	private Date ultimoAcesso;

	@NotNull
	@Column(name = "LG_ADMINISTRADOR", nullable = false)
	private boolean administrador;
	
	@NotNull
	@Column(name = "EN_SITUACAO", length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<PermissaoAcesso> permissoesAcesso = new HashSet<>();
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<GrupoAcesso> gruposAcesso = new HashSet<>();
	
	@Transient
	private String token;

}
