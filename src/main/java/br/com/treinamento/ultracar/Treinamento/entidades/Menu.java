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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_MENU")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_sequence")
	@SequenceGenerator(name = "menu_sequence", sequenceName = "menu_id_sequence", allocationSize = 1)
	@Column(name = "ID_MENU", nullable = false)
	private Long id;
	
	@Column(name = "DS_DESCRICAO", length = 45, nullable = false)
	@Size(min = 5, max = 45)
	private String descricao;
	
	@Column(name = "DS_URL", length = 150, nullable = false)
	@Size(min = 5, max = 150)
	private String url;
	
	@Column(name = "DS_ICONE", length = 45)
	private String icone;
	
	@Column(name = "DS_INDICE", length = 45)
	private String indice;
	
	@NotNull
	@JoinColumn(name = "ID_PERMISSAO_ACESSO", foreignKey = @ForeignKey(name = "fk_menu_permissao_acesso"), nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private PermissaoAcesso permissaoAcesso;
	
	@JoinColumn(name = "ID_MENU_PAI", foreignKey = @ForeignKey(name = "fk_menu_menu"))
	@OneToOne(fetch = FetchType.LAZY)
	private Menu menuPai;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public PermissaoAcesso getPermissaoAcesso() {
		return permissaoAcesso;
	}

	public void setPermissaoAcesso(PermissaoAcesso permissaoAcesso) {
		this.permissaoAcesso = permissaoAcesso;
	}

	public Menu getMenuPai() {
		return menuPai;
	}

	public void setMenuPai(Menu menuPai) {
		this.menuPai = menuPai;
	}
	
}
