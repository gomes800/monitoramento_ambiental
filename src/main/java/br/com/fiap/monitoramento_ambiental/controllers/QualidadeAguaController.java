package br.com.fiap.monitoramento_ambiental.controllers;

import br.com.fiap.monitoramento_ambiental.models.QualidadeAgua;
import br.com.fiap.monitoramento_ambiental.models.QualidadeAr;
import br.com.fiap.monitoramento_ambiental.services.QualidadeAguaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qualidade_agua")
public class QualidadeAguaController {

    @Autowired
    private QualidadeAguaService service;

    @GetMapping
    public List<QualidadeAgua> getAllQualidadeAgua() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QualidadeAgua> getQualidadeAguaById(@PathVariable Long id) {
        QualidadeAgua qualidadeAgua = service.findById(id);
        if (qualidadeAgua != null) {
            return ResponseEntity.ok(qualidadeAgua);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public QualidadeAgua createQualidadeAgua(@RequestBody QualidadeAgua qualidadeAgua) {
        return service.save(qualidadeAgua);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QualidadeAgua> updateQualidadeAgua(@PathVariable Long id, @RequestBody QualidadeAgua qualidadeAgua) {

        QualidadeAgua existingQualidadeAgua = service.findById(id);

        if (existingQualidadeAgua != null) {
            existingQualidadeAgua.setLocalizacao(qualidadeAgua.getLocalizacao());
            existingQualidadeAgua.setNivelPoluicao(qualidadeAgua.getNivelPoluicao());
            existingQualidadeAgua.setDataHora(qualidadeAgua.getDataHora());

            QualidadeAgua updatedQualidadeAgua = service.save(existingQualidadeAgua);
            return ResponseEntity.ok(updatedQualidadeAgua);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteQualidadeAgua(@PathVariable Long id) {
        service.deleteById(id);
    }
}
