package br.com.fiap.monitoramento_ambiental.services;

import br.com.fiap.monitoramento_ambiental.repositories.QualidadeArRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualidadeArService {

    @Autowired
    private QualidadeArRepository repository;

    public List<br.com.fiap.monitoramento_ambiental.models.QualidadeAr> findAll() {
        return repository.findAll();
    }

    public br.com.fiap.monitoramento_ambiental.models.QualidadeAr findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public br.com.fiap.monitoramento_ambiental.models.QualidadeAr save(br.com.fiap.monitoramento_ambiental.models.QualidadeAr qualidadeAr) {
        return repository.save(qualidadeAr);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
