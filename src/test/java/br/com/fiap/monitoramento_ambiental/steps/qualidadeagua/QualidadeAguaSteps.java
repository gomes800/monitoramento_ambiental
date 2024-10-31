package br.com.fiap.monitoramento_ambiental.steps.qualidadeagua;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class QualidadeAguaSteps {
    private Response response;
    private Long qualidadeAguaId;

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Given("que eu tenho um registro com localização {string}, nível de poluição {string} e data e hora {string}")
    public void givenRegistroComInformacoesValidas(String localizacao, String nivelPoluicao, String dataHora) {
        String novaQualidadeAguaJson = String.format("""
            {
                "localizacao": "%s",
                "nivelPoluicao": "%s",
                "dataHora": "%s"
            }
            """, localizacao, nivelPoluicao, dataHora);

        response = given()
                .contentType(ContentType.JSON)
                .body(novaQualidadeAguaJson)
                .when().post("/qualidade_agua");

        qualidadeAguaId = response.jsonPath().getLong("id"); // Supondo que o ID do registro é retornado na resposta
    }

    @When("eu envio uma requisição para criar esse registro")
    public void whenEnvioRequisicaoParaCriar() {
        // A requisição já foi enviada no método above.
    }

    @Then("o sistema deve retornar uma resposta com status {int}")
    public void thenVerificaStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("o sistema deve registrar o registro com essas informações")
    public void thenVerificaRegistroCriado() {
        response.then()
                .body("localizacao", equalTo("Lagoa Rodrigo de Freitas"))
                .body("nivelPoluicao", equalTo("Baixo"));
    }

    @Given("que eu tenho um registro sem localização")
    public void givenRegistroSemLocalizacao() {
        String novaQualidadeAguaJson = """
            {
                "nivelPoluicao": "Baixo",
                "dataHora": "2024-10-31T10:00:00Z"
            }
            """;

        response = given()
                .contentType(ContentType.JSON)
                .body(novaQualidadeAguaJson)
                .when().post("/qualidade_agua");
    }

    @Given("que existe um registro de qualidade da água com ID {int}")
    public void que_existe_um_registro_de_qualidade_da_agua_com_id(Integer id) {
        response = given()
                .when().get("/qualidade_agua/" + id);

        if (response.statusCode() != 200) {
            throw new IllegalStateException("O registro com ID " + id + " não existe.");
        }
    }


    @Then("o sistema deve exibir uma mensagem de erro informando os campos obrigatórios")
    public void o_sistema_deve_exibir_uma_mensagem_de_erro_informando_os_campos_obrigatórios() {
        String expectedMessage = "A localização é obrigatória."; // Ajuste conforme a sua mensagem de erro
        response.then()
                .statusCode(400) // Verifica se o status é 400 para erro de validação
                .body("message", equalTo(expectedMessage)); // Verifica se a mensagem de erro está correta
    }

    @When("eu envio uma requisição para buscar o registro com ID {int}")
    public void whenEnvioRequisicaoParaBuscarRegistro(int id) {
        response = given()
                .when().get("/qualidade_agua/" + id);
    }

    @Then("as informações do registro devem ser retornadas")
    public void thenVerificaInformacoesDoRegistro() {
        // Supondo que você já tenha feito a requisição e salvo a resposta
        response.then()
                .statusCode(200) // Certifique-se de que o status é 200
                .body("id", equalTo(1)) // Valide o ID
                .body("localizacao", notNullValue()) // Verifique se a localização não é nula
                .body("nivelPoluicao", notNullValue()) // Verifique se o nível de poluição não é nulo
                .body("dataHora", notNullValue()); // Verifique se a dataHora não é nula
    }


    @Given("não existe um registro com ID {int}")
    public void givenRegistroInexistente(int id) {
        // Este passo deve garantir que o registro não existe antes de fazer a requisição
        // Você pode querer verificar isso usando uma lógica adicional, dependendo do seu backend
    }

    @When("eu envio uma requisição para atualizar o registro com ID {int}")
    public void whenEnvioRequisicaoParaAtualizarRegistro(int id) {
        String updateQualidadeAguaJson = """
            {
                "localizacao": "Praia de Copacabana",
                "nivelPoluicao": "Médio",
                "dataHora": "2024-10-31T12:00:00Z"
            }
            """;

        response = given()
                .contentType(ContentType.JSON)
                .body(updateQualidadeAguaJson)
                .when().put("/qualidade_agua/" + id);
    }

    @Then("o sistema deve atualizar o registro com as novas informações")
    public void thenVerificaRegistroAtualizado() {
        response.then()
                .body("localizacao", equalTo("Praia de Copacabana"))
                .body("nivelPoluicao", equalTo("Médio"));
    }

    @Given("eu envio uma requisição para buscar o registro com ID {int} inexistente")
    public void whenEnvioRequisicaoParaBuscarRegistroInexistente(int id) {
        response = given()
                .when().get("/qualidade_agua/" + id);
    }

    @Then("o sistema deve exibir uma mensagem informando que o registro não foi encontrado")
    public void thenVerificaMensagemRegistroNaoEncontrado() {
        response.then()
                .statusCode(404)
                .body("message", equalTo("Registro não encontrado")); // Supondo que a mensagem de erro é retornada na resposta
    }

}
