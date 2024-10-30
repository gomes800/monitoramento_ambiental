package br.com.fiap.monitoramento_ambiental.controllers.exceptions;

public class NivelPoluicaoInvalidoException extends RuntimeException{

    public NivelPoluicaoInvalidoException(String msg) {
        super(msg);
    }
}
