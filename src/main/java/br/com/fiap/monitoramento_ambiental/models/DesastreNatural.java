package br.com.fiap.monitoramento_ambiental.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Data
public class DesastreNatural {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String localizacao;
    private String severidade;
    private Instant dataHora;

    public DesastreNatural(){}

    public DesastreNatural(Long id, String tipo, String localizacao, String severidade, Instant dataHora) {
        this.id = id;
        this.tipo = tipo;
        this.localizacao = localizacao;
        this.severidade = severidade;
        this.dataHora = dataHora;
    }
}
