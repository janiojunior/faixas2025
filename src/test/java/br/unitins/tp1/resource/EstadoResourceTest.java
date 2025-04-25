package br.unitins.tp1.resource;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.EstadoDTO;
import br.unitins.tp1.dto.EstadoResponseDTO;
import br.unitins.tp1.service.EstadoService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@QuarkusTest
public class EstadoResourceTest {

    @Inject
    EstadoService estadoService;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/estados")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        EstadoDTO estado = new EstadoDTO(
            "Rio Grande do Sul 2", 
            "RS", 
            2);

        given()
            .contentType(ContentType.JSON)
            .body(estado)
            .when().post("/estados")
            .then()
                .statusCode(201)
                .body(
                    "id", notNullValue(),
                    "nome", is("Rio Grande do Sul 2"),
                    "sigla", is("RS") 
                );
    }

    static Long id = null; 

    @Test
    void testAlterar() {
        EstadoDTO estado = new EstadoDTO(
            "Rio Grande do Sul 3", 
            "RS", 
            2);
       
        id =  estadoService.create(estado).id();

        EstadoDTO estadoAlterado = new EstadoDTO(
            "Rio Grande do Sul - Alterado", 
            "RR", 
            1);

        given()
            .contentType(ContentType.JSON)
            .body(estadoAlterado)
            .when().put("/estados/" + id)
            .then()
                .statusCode(204);

        EstadoResponseDTO response = estadoService.findById(id);
        assertThat(response.nome(), is("Rio Grande do Sul - Alterado"));
        assertThat(response.sigla(), is("RR"));
    }

    @Test
    void testApagar() {
        given()
        .when().delete("/estados/" + id)
        .then()
            .statusCode(204);

        EstadoResponseDTO response = estadoService.findById(id);
        assertNull(response);
        
    }

}
