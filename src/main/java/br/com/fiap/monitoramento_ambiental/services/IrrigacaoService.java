package br.com.fiap.monitoramento_ambiental.services;

import br.com.fiap.monitoramento_ambiental.models.Irrigacao;
import br.com.fiap.monitoramento_ambiental.repositories.IrrigacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IrrigacaoService {

    @Autowired
    private IrrigacaoRepository repository;

    public List<Irrigacao> findAll() {
        return repository.findAll();
    }

    public Irrigacao findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Irrigacao save(Irrigacao irrigacao) {
        return repository.save(irrigacao);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}


