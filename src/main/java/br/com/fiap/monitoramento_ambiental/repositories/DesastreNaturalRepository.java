package br.com.fiap.monitoramento_ambiental.repositories;

import br.com.fiap.monitoramento_ambiental.models.DesastreNatural;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesastreNaturalRepository extends JpaRepository<DesastreNatural, Long> {
}
