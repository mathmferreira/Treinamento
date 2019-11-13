package br.com.treinamento.ultracar.Treinamento.restcontroladores;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.ultracar.Treinamento.entidades.Bairro;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.BairroDTO;
import br.com.treinamento.ultracar.Treinamento.servicos.BairroService;

@RestController
@RequestMapping(value = "/api/bairro")
public class BairroController {

	@Autowired
	private BairroService service;
	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Bairro> save(@RequestBody BairroDTO bairroDTO) {
		return new ResponseEntity<>(this.service.salvarBairro(bairroDTO), HttpStatus.CREATED);
	}
	
}
