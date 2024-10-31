package br.com.fiap.monitoramento_ambiental.config;

import br.com.fiap.monitoramento_ambiental.models.QualidadeAgua;
import br.com.fiap.monitoramento_ambiental.repositories.QualidadeAguaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class Testconfig implements CommandLineRunner {

    @Autowired
    private QualidadeAguaRepository qualidadeAguaRepository;

    public void run(String... args) throws Exception {
        System.out.println("Inicializando dados...");

        QualidadeAgua qualidadeAgua1 = new QualidadeAgua(null, "Macaé", "Alto", Instant.parse("2024-10-25T15:00:07Z"));
        QualidadeAgua qualidadeAgua2 = new QualidadeAgua(null, "Três rios", "Baixo", Instant.parse("2024-11-25T15:00:07Z"));

        this.qualidadeAguaRepository.save(qualidadeAgua1);
        this.qualidadeAguaRepository.save(qualidadeAgua2);
    }
}