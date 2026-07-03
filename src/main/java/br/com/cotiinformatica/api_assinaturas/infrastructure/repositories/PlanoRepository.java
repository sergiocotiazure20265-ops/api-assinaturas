package br.com.cotiinformatica.api_assinaturas.infrastructure.repositories;

import br.com.cotiinformatica.api_assinaturas.domain.entities.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Integer> {

}
