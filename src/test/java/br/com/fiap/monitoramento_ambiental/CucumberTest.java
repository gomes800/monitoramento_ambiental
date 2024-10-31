package br.com.fiap.monitoramento_ambiental;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src\\test\\resources\\features\\qualidadeagua"
        },
        glue = {
                "br.com.fiap.monitoramento_ambiental.steps.qualidadeagua"
        },
        plugin = {"pretty", "json:target/cucumber-report.json"}
)

public class CucumberTest {
}
