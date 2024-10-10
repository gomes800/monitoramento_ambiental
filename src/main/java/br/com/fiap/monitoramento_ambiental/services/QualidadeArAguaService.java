package br.com.fiap.monitoramento_ambiental.services;

import br.com.fiap.monitoramento_ambiental.models.QualidadeArAgua;
import br.com.fiap.monitoramento_ambiental.repositories.QualidadeArAguaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualidadeArAguaService {

    @Autowired
    private QualidadeArAguaRepository repository;

    public List<QualidadeArAgua> findAll() {
        return repository.findAll();
    }

    public QualidadeArAgua findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public QualidadeArAgua save(QualidadeArAgua qualidadeArAgua) {
        return repository.save(qualidadeArAgua);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
