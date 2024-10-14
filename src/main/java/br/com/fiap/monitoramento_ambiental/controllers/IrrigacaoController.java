package br.com.fiap.monitoramento_ambiental.controllers;

import br.com.fiap.monitoramento_ambiental.models.Irrigacao;
import br.com.fiap.monitoramento_ambiental.services.IrrigacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/irrigacao")
public class IrrigacaoController {

    @Autowired
    private IrrigacaoService service;

    @GetMapping
    public List<Irrigacao> getAllIrrigacao() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Irrigacao getIrrigacaoById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Irrigacao createIrrigacao(@RequestBody Irrigacao irrigacao) {
        return service.save(irrigacao);
    }

    @PutMapping("/{id}")
    public Irrigacao updateIrrigacao(@PathVariable Long id, @RequestBody Irrigacao irrigacao) {
        Irrigacao existingIrrigacao = service.findById(id);
        if (existingIrrigacao != null) {
            irrigacao.setId(id);
            return service.save(irrigacao);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteIrrigacao(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/test")
    public Irrigacao createTestIrrigacao() {
        Irrigacao irrigacao = new Irrigacao();
        irrigacao.setLocalizacao("Teste Local");
        irrigacao.setStatus(true);
        irrigacao.setDataHora(LocalDateTime.now());
        return service.save(irrigacao);
    }

}