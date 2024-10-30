package br.com.fiap.monitoramento_ambiental.models;

import br.com.fiap.monitoramento_ambiental.services.IrrigacaoService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class Irrigacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localizacao;
    private boolean status;
    private Instant dataHora;

    public Irrigacao(){}

    public Irrigacao(Long id, String localizacao, boolean status, Instant dataHora) {
        this.id = id;
        this.localizacao = localizacao;
        this.status = status;
        this.dataHora = dataHora;
    }
}

