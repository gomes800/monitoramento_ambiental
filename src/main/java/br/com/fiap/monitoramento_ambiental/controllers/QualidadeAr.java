package br.com.fiap.monitoramento_ambiental.controllers;

import br.com.fiap.monitoramento_ambiental.services.QualidadeArService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qualidade_ar")
public class QualidadeAr {

    @Autowired
    private QualidadeArService service;

    @GetMapping
    public List<br.com.fiap.monitoramento_ambiental.models.QualidadeAr> getAllQualidadeAr() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<br.com.fiap.monitoramento_ambiental.models.QualidadeAr> getQualidadeArById(@PathVariable Long id) {
        br.com.fiap.monitoramento_ambiental.models.QualidadeAr qualidadeAr = service.findById(id);

        if (qualidadeAr == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(qualidadeAr);
    }

    @PostMapping
    public br.com.fiap.monitoramento_ambiental.models.QualidadeAr createQualidadeAr(@RequestBody br.com.fiap.monitoramento_ambiental.models.QualidadeAr qualidadeAr) {
        return service.save(qualidadeAr);
    }

    @PutMapping("/{id}")
    public ResponseEntity<br.com.fiap.monitoramento_ambiental.models.QualidadeAr> updateQualidadeAr(@PathVariable Long id, @RequestBody br.com.fiap.monitoramento_ambiental.models.QualidadeAr qualidadeAr) {

        br.com.fiap.monitoramento_ambiental.models.QualidadeAr existingQualidadeAr = service.findById(id);

        if (existingQualidadeAr != null) {
            existingQualidadeAr.setLocalizacao(qualidadeAr.getLocalizacao());
            existingQualidadeAr.setStatus(qualidadeAr.isStatus());
            existingQualidadeAr.setDataHora(qualidadeAr.getDataHora());

            br.com.fiap.monitoramento_ambiental.models.QualidadeAr updatedQualidadeAr = service.save(existingQualidadeAr);
            return ResponseEntity.ok(updatedQualidadeAr);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteQualidadeAr(@PathVariable Long id) {
        service.deleteById(id);
    }


}
