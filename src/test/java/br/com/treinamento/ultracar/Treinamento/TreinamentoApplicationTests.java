package br.com.treinamento.ultracar.Treinamento;

import java.util.Date;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.treinamento.ultracar.Treinamento.entidades.Usuario;
import br.com.treinamento.ultracar.Treinamento.entidades.enumeradores.Situacao;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TreinamentoApplicationTests {

	private ObjectMapper mapper = new ObjectMapper();
	
	@LocalServerPort
	private int port;
	
	@Before
	public void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}
	
	@Test
	public void createUsuario() throws JsonProcessingException {
		Usuario usuario = Usuario.builder().build();
		usuario.setLogin("matheus");
		usuario.setSenha("mthm123");
		usuario.setEmail("mathmferreira@hotmail.com");
		usuario.setSituacao(Situacao.ATIVO);
		usuario.setAdministrador(true);
		usuario.setUltimoAcesso(new Date());
		usuario.setPermissoesAcesso(new HashSet<>());
		usuario.setGruposAcesso(new HashSet<>());
		RestAssured.given().contentType(ContentType.JSON).body(mapper.writeValueAsString(usuario))
				.post("/api/usuario/create").then().statusCode(201);
	}

}
