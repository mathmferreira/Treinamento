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

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
	@SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_id_sequence", allocationSize = 1)
	@Column(name = "ID_USUARIO", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name = "DS_LOGIN", length = 45, nullable = false, unique = true)
	@Size(min = 5, max = 45)
	private String login;
	
	@NotBlank
	@Column(name = "DS_SENHA", length = 45, nullable = false)
	@Size(min = 5, max = 45)
	private String senha;
	
	@NotBlank
	@Column(name = "DS_EMAIL", length = 45)
	@Size(min = 3, max = 45)
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<PermissaoAcesso> permissoesAcesso = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<GrupoAcesso> gruposAcesso = new HashSet<>();
	
	@Transient
	private String token;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Set<PermissaoAcesso> getPermissoesAcesso() {
		return permissoesAcesso;
	}

	public void setPermissoesAcesso(Set<PermissaoAcesso> permissoesAcesso) {
		this.permissoesAcesso = permissoesAcesso;
	}

	public Set<GrupoAcesso> getGruposAcesso() {
		return gruposAcesso;
	}

	public void setGruposAcesso(Set<GrupoAcesso> gruposAcesso) {
		this.gruposAcesso = gruposAcesso;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
