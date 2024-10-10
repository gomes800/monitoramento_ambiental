package br.com.fiap.monitoramento_ambiental.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

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
    private LocalDateTime dataHora;

    public void setId(Long id) {
    }
}
