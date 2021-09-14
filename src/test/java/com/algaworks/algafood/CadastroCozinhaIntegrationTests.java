package com.algaworks.algafood;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadastroCozinhaIntegrationTests {

    @LocalServerPort
    private int port;

    @Test
    public void deveRetornarStatus200_QuandoConsultarCozinhas() {
        RestAssured.given().basePath("/cozinhas").port(port).accept(ContentType.JSON).when().get().then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveConter4Cozinhas_QuandoConsultarCozinhas() {
        RestAssured.given().basePath("/cozinhas").port(port).accept(ContentType.JSON).when().get().then().body("",
                Matchers.hasSize(4));
    }

    @Test
    public void deveConterCozinhaIndianaETailandesa_QuandoConsultarCozinhas() {
        RestAssured.given().basePath("/cozinhas").port(port).accept(ContentType.JSON).when().get().then().body("nome",
                Matchers.hasItems("Indiana", "Tailandesa"));
    }

}
