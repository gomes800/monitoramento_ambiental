package br.com.fiap.monitoramento_ambiental.steps.desastrenatural;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class DesastreNaturalSteps {
    private Response response;
    private Long desastreNaturalId;

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Given("que eu tenho um registro de desastre natural com tipo {string}, localização {string}, severidade {string} e data e hora {string}")
    public void givenRegistroComInformacoesValidas(String tipo, String localizacao, String severidade, String dataHora) {
        String novoDesastreNaturalJson = String.format("""
            {
                "tipo": "%s",
                "localizacao": "%s",
                "severidade": "%s",
                "dataHora": "%s"
            }
            """, tipo, localizacao, severidade, dataHora);

        response = given()
                .contentType(ContentType.JSON)
                .body(novoDesastreNaturalJson)
                .when().post("/desastre_natural");

        desastreNaturalId = response.jsonPath().getLong("id"); // Supondo que o ID do registro é retornado na resposta
    }

    @When("eu envio uma requisição para criar esse registro de desastre natural")
    public void whenEnvioRequisicaoParaCriar() {
        // A requisição já foi enviada no método acima.
    }

    @Then("o sistema deve retornar uma resposta com status de desastre natural {int}")
    public void thenVerificaStatusCodeDesastreNatural(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("o sistema deve registrar o registro de desastre natural com essas informações")
    public void thenVerificaRegistroCriado() {
        response.then()
                .body("tipo", notNullValue())
                .body("localizacao", notNullValue())
                .body("severidade", notNullValue());
    }

    @Given("que eu tenho um registro de desastre natural sem localização")
    public void givenRegistroSemLocalizacao() {
        String novoDesastreNaturalJson = """
            {
                "tipo": "Terremoto",
                "severidade": "Alto",
                "dataHora": "2024-10-31T10:00:00Z"
            }
            """;

        response = given()
                .contentType(ContentType.JSON)
                .body(novoDesastreNaturalJson)
                .when().post("/desastre_natural");
    }

    @Given("que existe um registro de desastre natural com ID {int}")
    public void que_existe_um_registro_de_desastre_natural_com_id(Integer id) {
        response = given()
                .when().get("/desastre_natural/" + id);

        if (response.statusCode() != 200) {
            throw new IllegalStateException("O registro com ID " + id + " não existe.");
        }
    }

    @Then("o sistema deve exibir uma mensagem de erro informando os campos obrigatórios para desastre natural")
    public void o_sistema_deve_exibir_uma_mensagem_de_erro_informando_os_campos_obrigatórios_para_desastre_natural() {
        String expectedMessage = "A localização é obrigatória."; // Ajuste conforme a sua mensagem de erro
        response.then()
                .statusCode(400) // Verifica se o status é 400 para erro de validação
                .body("message", equalTo(expectedMessage)); // Verifica se a mensagem de erro está correta
    }

    @When("eu envio uma requisição para buscar o registro de desastre natural com ID {int}")
    public void whenEnvioRequisicaoParaBuscarRegistro(int id) {
        response = given()
                .when().get("/desastre_natural/" + id);
    }

    @Then("as informações do registro de desastre natural devem ser retornadas")
    public void thenVerificaInformacoesDoRegistro() {
        response.then()
                .statusCode(200) // Certifique-se de que o status é 200
                .body("id", equalTo(desastreNaturalId)) // Valide o ID
                .body("tipo", notNullValue()) // Verifique se o tipo não é nulo
                .body("localizacao", notNullValue()) // Verifique se a localização não é nula
                .body("severidade", notNullValue()) // Verifique se a severidade não é nula
                .body("dataHora", notNullValue()); // Verifique se a dataHora não é nula
    }

    @When("eu envio uma requisição para atualizar o registro de desastre natural com ID {int}")
    public void whenEnvioRequisicaoParaAtualizarRegistro(int id) {
        String updateDesastreNaturalJson = """
            {
                "tipo": "Inundação",
                "localizacao": "Praia de Copacabana",
                "severidade": "Médio",
                "dataHora": "2024-10-31T12:00:00Z"
            }
            """;

        response = given()
                .contentType(ContentType.JSON)
                .body(updateDesastreNaturalJson)
                .when().put("/desastre_natural/" + id);
    }

    @Then("o sistema deve atualizar o registro de desastre natural com as novas informações")
    public void thenVerificaRegistroAtualizado() {
        response.then()
                .body("tipo", equalTo("Inundação"))
                .body("localizacao", equalTo("Praia de Copacabana"))
                .body("severidade", equalTo("Médio"));
    }

    @Given("eu envio uma requisição para buscar o registro de desastre natural com ID {int} inexistente")
    public void whenEnvioRequisicaoParaBuscarRegistroInexistente(int id) {
        response = given()
                .when().get("/desastre_natural/" + id);
    }

    @Then("o sistema deve exibir uma mensagem informando que o registro de desastre natural não foi encontrado")
    public void thenVerificaMensagemRegistroNaoEncontrado() {
        response.then()
                .statusCode(404)
                .body("message", equalTo("Registro não encontrado")); // Supondo que a mensagem de erro é retornada na resposta
    }
}
