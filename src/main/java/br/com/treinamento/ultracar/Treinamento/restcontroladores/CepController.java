package br.com.treinamento.ultracar.Treinamento.restcontroladores;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.ultracar.Treinamento.entidades.Cep;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.CepDTO;
import br.com.treinamento.ultracar.Treinamento.servicos.CepService;

@RestController
@RequestMapping(value = "/api/cep")
public class CepController {

	@Autowired
	private CepService service;
	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Cep> save(@RequestBody CepDTO cepDTO) {
		return new ResponseEntity<>(this.service.salvarCep(cepDTO), HttpStatus.CREATED);
	}
	
}
