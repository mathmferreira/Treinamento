package br.com.treinamento.ultracar.Treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.treinamento.ultracar.Treinamento.entidades.GrupoAcesso;
import br.com.treinamento.ultracar.Treinamento.entidades.Usuario;

@Repository
public interface GrupoAcessoRepository extends JpaRepository<GrupoAcesso, Long> {

	@Query("Select usuarios From GrupoAcesso ga "
		 + "Inner Join ga.usuario usuarios "
		 + "Where ga = :grupoAcesso")
	public List<Usuario> findUsuarioByGrupoAcesso(GrupoAcesso grupoAcesso);
	
	@Query("Select ga From GrupoAcesso ga Where ga.descricao = :descricao")
	public List<GrupoAcesso> findGrupoAcessoByDescricao(String descricao);
	
}
