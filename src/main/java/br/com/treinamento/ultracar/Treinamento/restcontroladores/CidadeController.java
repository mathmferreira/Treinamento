package br.com.treinamento.ultracar.Treinamento.restcontroladores;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.ultracar.Treinamento.entidades.Cidade;
import br.com.treinamento.ultracar.Treinamento.servicos.CidadeService;

@RestController
@RequestMapping(value = "/api/cidade")
public class CidadeController {

	@Autowired
	private CidadeService service;
	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Cidade> save(@RequestBody Cidade cidade) {
		return new ResponseEntity<>(this.service.salvarCidade(cidade), HttpStatus.CREATED);
	}
	
}
