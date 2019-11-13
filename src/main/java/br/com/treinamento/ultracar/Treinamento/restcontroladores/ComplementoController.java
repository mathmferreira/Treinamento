package br.com.treinamento.ultracar.Treinamento.restcontroladores;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.ultracar.Treinamento.entidades.Complemento;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.ComplementoDTO;
import br.com.treinamento.ultracar.Treinamento.servicos.ComplementoService;

@RestController
@RequestMapping(value = "/api/complemento")
public class ComplementoController {

	@Autowired
	private ComplementoService service;
	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Complemento> save(@RequestBody ComplementoDTO complementoDTO) {
		return new ResponseEntity<>(this.service.salvarComplemento(complementoDTO), HttpStatus.CREATED);
	}
	
}
