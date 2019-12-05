package br.com.treinamento.ultracar.Treinamento;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CepRestTests {

	@LocalServerPort
	private int port;

	@Before
	public void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}
	
	@Test
	public void testSearchMethod() {
		String cep = String.valueOf(new Random().nextInt((99999999)));
		RestAssured.given().contentType(ContentType.JSON).get("/api/cep/{cep}", cep).then().statusCode(200);
		System.out.println("Finalizado: " + cep);
	}

}
