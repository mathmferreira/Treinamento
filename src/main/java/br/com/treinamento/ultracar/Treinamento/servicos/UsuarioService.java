package br.com.treinamento.ultracar.Treinamento.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.treinamento.ultracar.Treinamento.entidades.Usuario;
import br.com.treinamento.ultracar.Treinamento.repositorios.UsuarioRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;
	
	public void salvarUsuario(Usuario usuario) {
		this.repositorio.save(usuario);
	}
	
	public void deletarUsuario(Usuario usuario) {
		this.repositorio.deleteById(usuario.getId());
	}
	
	public void deletarUsuarios(List<Long> ids) {
		ids.stream().filter(this.repositorio::existsById).parallel().forEach(this.repositorio::deleteById);
	}
	
}