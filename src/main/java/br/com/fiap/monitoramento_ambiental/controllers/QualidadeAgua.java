package br.com.fiap.monitoramento_ambiental.controllers;

import br.com.fiap.monitoramento_ambiental.services.QualidadeAguaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qualidade_agua")
public class QualidadeAgua {

    @Autowired
    private QualidadeAguaService service;

    @GetMapping
    public List<br.com.fiap.monitoramento_ambiental.models.QualidadeAgua> getAllQualidade() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public br.com.fiap.monitoramento_ambiental.models.QualidadeAgua getQualidadeById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public br.com.fiap.monitoramento_ambiental.models.QualidadeAgua createQualidade(@RequestBody br.com.fiap.monitoramento_ambiental.models.QualidadeAgua qualidadeAgua) {
        return service.save(qualidadeAgua);
    }

    @PutMapping("/{id}")
    public br.com.fiap.monitoramento_ambiental.models.QualidadeAgua updateQualidade(@PathVariable Long id, @RequestBody br.com.fiap.monitoramento_ambiental.models.QualidadeAgua qualidadeAgua) {
        br.com.fiap.monitoramento_ambiental.models.QualidadeAgua existingQualidade = service.findById(id);
        if (existingQualidade != null) {
            qualidadeAgua.setId(id);
            return service.save(qualidadeAgua);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteQualidade(@PathVariable Long id) {
        service.deleteById(id);
    }
}
