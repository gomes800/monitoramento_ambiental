package br.com.fiap.monitoramento_ambiental.controllers;

import br.com.fiap.monitoramento_ambiental.models.Irrigacao;
import br.com.fiap.monitoramento_ambiental.services.IrrigacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Irrigacao> getIrrigacaoById(@PathVariable Long id) {
        Irrigacao irrigacao = service.findById(id);

        if (irrigacao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(irrigacao);
    }

    @PostMapping
    public Irrigacao createIrrigacao(@RequestBody Irrigacao irrigacao) {
        return service.save(irrigacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Irrigacao> updateIrrigacao(@PathVariable Long id, @RequestBody Irrigacao irrigacao) {

        Irrigacao existingIrrigacao = service.findById(id);

        if (existingIrrigacao != null) {
            existingIrrigacao.setLocalizacao(irrigacao.getLocalizacao());
            existingIrrigacao.setStatus(irrigacao.isStatus());
            existingIrrigacao.setDataHora(irrigacao.getDataHora());

            Irrigacao updatedIrrigacao = service.save(existingIrrigacao);
            return ResponseEntity.ok(updatedIrrigacao);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteIrrigacao(@PathVariable Long id) {
        service.deleteById(id);
    }


}
