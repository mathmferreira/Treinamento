package br.com.treinamento.ultracar.Treinamento.restcontroladores;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.ultracar.Treinamento.entidades.Endereco;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.EnderecoDTO;
import br.com.treinamento.ultracar.Treinamento.servicos.EnderecoService;

@RestController
@RequestMapping(value = "/api/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService service;
	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Endereco> save(@RequestBody EnderecoDTO enderecoDTO) {
		return new ResponseEntity<>(this.service.salvarEndereco(enderecoDTO), HttpStatus.CREATED);
	}
	
}
