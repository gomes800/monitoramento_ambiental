package br.com.fiap.monitoramento_ambiental.services;

import br.com.fiap.monitoramento_ambiental.models.DesastreNatural;
import br.com.fiap.monitoramento_ambiental.repositories.DesastreNaturalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesastreNaturalService {

    @Autowired
    private DesastreNaturalRepository repository;

    public List<DesastreNatural> findAll() {
        return repository.findAll();
    }

    public DesastreNatural findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public DesastreNatural save(DesastreNatural desastreNatural) {
        return repository.save(desastreNatural);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
