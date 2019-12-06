package br.com.treinamento.ultracar.Treinamento;

import org.apache.commons.lang3.StringUtils;
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
	public void testSearchUnknown() {
		Integer cep = 10000000;
		RestAssured.given().contentType(ContentType.JSON).get("/api/cep/{cep}", cep).then().statusCode(404);
	}
	
	@Test
	public void testSearchBlank() {
		String cep = StringUtils.EMPTY;
		RestAssured.given().contentType(ContentType.JSON).get("/api/cep/{cep}", cep).then().statusCode(404);
	}
	
	@Test
	public void testSearchInvalid() {
		Integer cep = 1654654645;
		RestAssured.given().contentType(ContentType.JSON).get("/api/cep/{cep}", cep).then().statusCode(404);
	}
	
	@Test
	public void testSearchString() {
		String cep = "josias";
		RestAssured.given().contentType(ContentType.JSON).get("/api/cep/{cep}", cep).then().statusCode(400);
	}
	
	@Test
	public void testSearchValid() {
		Integer cep = 30130002;
		RestAssured.given().contentType(ContentType.JSON).get("/api/cep/{cep}", cep).then().statusCode(200);
	}
	
	@Test
	public void testSearchValidCreate() {
		Integer cep = 31540530;
		RestAssured.given().contentType(ContentType.JSON).get("/api/cep/{cep}", cep).then().statusCode(200);
	}

}
