package br.com.fiap.monitoramento_ambiental.models;

import br.com.fiap.monitoramento_ambiental.models.enums.NivelPoluicao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class QualidadeAgua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localizacao;
    private String nivelPoluicao;
    private Instant dataHora;

    public QualidadeAgua(){}

    public QualidadeAgua(Long id, String localizacao, String nivelPoluicao, Instant dataHora) {
        this.id = id;
        this.localizacao = localizacao;
        this.nivelPoluicao = nivelPoluicao;
        this.dataHora = dataHora;
    }
}
