package br.com.treinamento.ultracar.Treinamento.restcontroladores;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.ultracar.Treinamento.entidades.Estado;
import br.com.treinamento.ultracar.Treinamento.entidades.dto.EstadoDTO;
import br.com.treinamento.ultracar.Treinamento.servicos.EstadoService;

@RestController
@RequestMapping(value = "/api/estado")
public class EstadoController {

	@Autowired
	private EstadoService service;
	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Estado> save(@RequestBody EstadoDTO estadoDTO) {
		return new ResponseEntity<>(this.service.salvarEstado(estadoDTO), HttpStatus.CREATED);
	}
	
}
