package br.com.fiap.monitoramento_ambiental.repositories;

import br.com.fiap.monitoramento_ambiental.models.Irrigacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrrigacaoRepository extends JpaRepository<Irrigacao, Long> {
}
