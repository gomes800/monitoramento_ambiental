package br.com.fiap.monitoramento_ambiental.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Irrigacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localizacao;
    private boolean status;
    private LocalDateTime dataHora;

    public void setId(Long id) {
    }

    public void setLocalizacao(String testeLocal) {
    }

    public void setStatus(boolean b) {
    }

    public void setDataHora(LocalDateTime now) {

    }
}
