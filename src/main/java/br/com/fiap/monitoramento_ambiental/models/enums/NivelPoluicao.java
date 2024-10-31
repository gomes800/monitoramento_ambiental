package br.com.fiap.monitoramento_ambiental.models.enums;

import br.com.fiap.monitoramento_ambiental.controllers.exceptions.NivelPoluicaoInvalidoException;

public enum NivelPoluicao {

    Baixo(0),
    Moderado(1),
    Alto(2);

    private int code;

    NivelPoluicao(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static NivelPoluicao valueOf(int code) {
        for (NivelPoluicao nivel : NivelPoluicao.values()) {
            if (nivel.getCode() + 1 == code) {
                return nivel;
            }
        }
        throw new NivelPoluicaoInvalidoException("Código inválido");
    }
}
