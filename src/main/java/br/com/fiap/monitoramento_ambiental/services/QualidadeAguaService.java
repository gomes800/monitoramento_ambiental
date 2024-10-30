package br.com.fiap.monitoramento_ambiental.services;

import br.com.fiap.monitoramento_ambiental.models.QualidadeAgua;
import br.com.fiap.monitoramento_ambiental.repositories.QualidadeAguaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualidadeAguaService {

    @Autowired
    private QualidadeAguaRepository repository;

    public List<QualidadeAgua> findAll() {
        return repository.findAll();
    }

    public QualidadeAgua findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public QualidadeAgua save(QualidadeAgua qualidadeAgua) {
        return repository.save(qualidadeAgua);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
