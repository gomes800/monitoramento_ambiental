package br.com.fiap.monitoramento_ambiental;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DesastreNaturalApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void testGetAllDesastres_StatusCodeAndResponseBody() {
        given()
                .when().get("/desastres")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", greaterThan(0));
    }

    @Test
    public void testGetDesastreById_ValidId_StatusCodeAndResponseBody() {
        given()
                .when().get("/desastres/1")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(1))
                .body("tipo", notNullValue())
                .body("localizacao", notNullValue())
                .body("severidade", notNullValue());
    }

    @Test
    public void testGetDesastreById_InvalidId_StatusCode() {
        given()
                .when().get("/desastres/-1")
                .then()
                .statusCode(404);
    }

    @Test
    public void testCreateDesastre_StatusCodeAndResponseBody() {
        String novoDesastreJson = """
            {
                "tipo": "Tempestade",
                "localizacao": "Rio de Janeiro",
                "severidade": "Alta",
                "dataHora": "2024-11-15T10:00:00Z"
            }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(novoDesastreJson)
                .when().post("/desastres")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("tipo", equalTo("Tempestade"))
                .body("localizacao", equalTo("Rio de Janeiro"))
                .body("severidade", equalTo("Alta"));
    }

    @Test
    public void testUpdateDesastre_StatusCodeAndResponseBody() {
        String updateDesastreJson = """
            {
                "tipo": "Incêndio",
                "localizacao": "São Paulo",
                "severidade": "Média",
                "dataHora": "2024-10-31T12:00:00Z"
            }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(updateDesastreJson)
                .when().put("/desastres/1")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("tipo", equalTo("Incêndio"))
                .body("localizacao", equalTo("São Paulo"))
                .body("severidade", equalTo("Média"));
    }

    @Test
    public void testGetDesastreResponseSchema() {
        given()
                .when().get("/desastres/1")
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/desastreSchema.json"));
    }

    @Test
    public void testDeleteDesastre_StatusCode() {
        given()
                .when().delete("/desastres/2")
                .then()
                .statusCode(200);
    }

}
