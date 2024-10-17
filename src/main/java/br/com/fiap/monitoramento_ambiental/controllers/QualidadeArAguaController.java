package br.com.fiap.monitoramento_ambiental.controllers;

import br.com.fiap.monitoramento_ambiental.models.QualidadeArAgua;
import br.com.fiap.monitoramento_ambiental.services.QualidadeArAguaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qualidade")
public class QualidadeArAguaController {

    @Autowired
    private QualidadeArAguaService service;

    @GetMapping
    public List<QualidadeArAgua> getAllQualidade() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public QualidadeArAgua getQualidadeById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public QualidadeArAgua createQualidade(@RequestBody QualidadeArAgua qualidadeArAgua) {
        return service.save(qualidadeArAgua);
    }

    @PutMapping("/{id}")
    public QualidadeArAgua updateQualidade(@PathVariable Long id, @RequestBody QualidadeArAgua qualidadeArAgua) {
        QualidadeArAgua existingQualidade = service.findById(id);
        if (existingQualidade != null) {
            qualidadeArAgua.setId(id);
            return service.save(qualidadeArAgua);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteQualidade(@PathVariable Long id) {
        service.deleteById(id);
    }
}



