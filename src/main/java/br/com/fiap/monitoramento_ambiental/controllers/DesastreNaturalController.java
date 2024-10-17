package br.com.fiap.monitoramento_ambiental.controllers;

import br.com.fiap.monitoramento_ambiental.models.DesastreNatural;
import br.com.fiap.monitoramento_ambiental.services.DesastreNaturalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desastres")
public class DesastreNaturalController {

    @Autowired
    private DesastreNaturalService service;

    @GetMapping
    public List<DesastreNatural> getAllDesastres() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DesastreNatural getDesastreById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public DesastreNatural createDesastre(@RequestBody DesastreNatural desastreNatural) {
        return service.save(desastreNatural);
    }

    @PutMapping("/{id}")
    public DesastreNatural updateDesastre(@PathVariable Long id, @RequestBody DesastreNatural desastreNatural) {
        DesastreNatural existingDesastre = service.findById(id);
        if (existingDesastre != null) {
            desastreNatural.setId(id);
            return service.save(desastreNatural);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDesastre(@PathVariable Long id) {
        service.deleteById(id);
    }
}

