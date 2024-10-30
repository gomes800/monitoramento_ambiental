package br.com.fiap.monitoramento_ambiental.controllers;

import br.com.fiap.monitoramento_ambiental.models.QualidadeAr;
import br.com.fiap.monitoramento_ambiental.services.QualidadeArService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qualidade_ar")
public class QualidadeArController {

    @Autowired
    private QualidadeArService service;

    @GetMapping
    public List<QualidadeAr> getAllQualidadeAr() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QualidadeAr> getQualidadeArById(@PathVariable Long id) {
        QualidadeAr qualidadeAr = service.findById(id);

        if (qualidadeAr == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(qualidadeAr);
    }

    @PostMapping
    public QualidadeAr createQualidadeAr(@RequestBody QualidadeAr qualidadeAr) {
        return service.save(qualidadeAr);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QualidadeAr> updateQualidadeAr(@PathVariable Long id, @RequestBody QualidadeAr qualidadeAr) {

       QualidadeAr existingQualidadeAr = service.findById(id);

        if (existingQualidadeAr != null) {
            existingQualidadeAr.setLocalizacao(qualidadeAr.getLocalizacao());
            existingQualidadeAr.setNivelPoluicao(qualidadeAr.getNivelPoluicao());
            existingQualidadeAr.setDataHora(qualidadeAr.getDataHora());

            QualidadeAr updatedQualidadeAr = service.save(existingQualidadeAr);
            return ResponseEntity.ok(updatedQualidadeAr);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteQualidadeAr(@PathVariable Long id) {
        service.deleteById(id);
    }


}
