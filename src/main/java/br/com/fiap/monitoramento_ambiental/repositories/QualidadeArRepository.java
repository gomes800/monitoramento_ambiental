package br.com.fiap.monitoramento_ambiental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualidadeArRepository extends JpaRepository<br.com.fiap.monitoramento_ambiental.models.QualidadeAr, Long> {
}
