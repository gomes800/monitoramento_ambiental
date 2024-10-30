package br.com.fiap.monitoramento_ambiental.services;

import br.com.fiap.monitoramento_ambiental.repositories.QualidadeAguaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualidadeAguaService {

    @Autowired
    private QualidadeAguaRepository repository;

    public List<br.com.fiap.monitoramento_ambiental.models.QualidadeAgua> findAll() {
        return repository.findAll();
    }

    public br.com.fiap.monitoramento_ambiental.models.QualidadeAgua findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public br.com.fiap.monitoramento_ambiental.models.QualidadeAgua save(br.com.fiap.monitoramento_ambiental.models.QualidadeAgua qualidadeAgua) {
        return repository.save(qualidadeAgua);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
