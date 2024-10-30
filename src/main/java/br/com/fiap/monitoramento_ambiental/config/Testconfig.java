package br.com.fiap.monitoramento_ambiental.config;

import br.com.fiap.monitoramento_ambiental.models.DesastreNatural;
import br.com.fiap.monitoramento_ambiental.models.enums.NivelPoluicao;
import br.com.fiap.monitoramento_ambiental.repositories.DesastreNaturalRepository;
import br.com.fiap.monitoramento_ambiental.repositories.QualidadeArRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class Testconfig implements CommandLineRunner {
    @Autowired
    private DesastreNaturalRepository desastreNaturalRepository;

    @Autowired
    private QualidadeArRepository qualidadeArRepository;

    public void run(String... args) throws Exception {
        System.out.println("Inicializando dados...");
        DesastreNatural desastre = new DesastreNatural(null, "Terremoto", "São Paulo", "Alto", Instant.parse("2019-06-20T19:53:07Z"));

        desastreNaturalRepository.save(desastre);

        br.com.fiap.monitoramento_ambiental.models.QualidadeAr qualidadeAr = new br.com.fiap.monitoramento_ambiental.models.QualidadeAr(null, "Magé", NivelPoluicao.Baixo, Instant.parse("2024-10-20T19:53:07Z"));

        this.qualidadeArRepository.save(qualidadeAr);
    }
}