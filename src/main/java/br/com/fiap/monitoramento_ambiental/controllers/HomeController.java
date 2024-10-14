package br.com.fiap.monitoramento_ambiental.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Aplicacao de monitoramento ambiental esta rodando!";
    }
}
