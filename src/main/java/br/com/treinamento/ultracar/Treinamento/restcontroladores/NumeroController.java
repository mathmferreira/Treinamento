package br.com.treinamento.ultracar.Treinamento.restcontroladores;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.ultracar.Treinamento.entidades.Numero;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.NumeroDTO;
import br.com.treinamento.ultracar.Treinamento.servicos.NumeroService;

@RestController
@RequestMapping(value = "/api/numero")
public class NumeroController {

	@Autowired
	private NumeroService service;
	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Numero> save(@RequestBody NumeroDTO numeroDTO) {
		return new ResponseEntity<>(this.service.salvarNumero(numeroDTO), HttpStatus.CREATED);
	}
	
}
