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
public class QualidadeAr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localizacao;
    private NivelPoluicao nivelPoluicao;
    private Instant dataHora;

    public QualidadeAr(){}

    public QualidadeAr(Long id, String localizacao, NivelPoluicao nivelPoluicao, Instant dataHora) {
        this.id = id;
        this.localizacao = localizacao;
        this.nivelPoluicao = nivelPoluicao;
        this.dataHora = dataHora;
    }
}

