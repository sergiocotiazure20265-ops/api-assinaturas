package br.com.cotiinformatica.api_assinaturas.infrastructure.repositories;

import br.com.cotiinformatica.api_assinaturas.domain.entities.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Integer> {

}
