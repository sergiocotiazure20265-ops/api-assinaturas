package br.com.cotiinformatica.api_assinaturas.domain.services;

import br.com.cotiinformatica.api_assinaturas.domain.dtos.requests.AssinaturaRequest;
import br.com.cotiinformatica.api_assinaturas.domain.dtos.responses.AssinaturaResponse;
import br.com.cotiinformatica.api_assinaturas.infrastructure.repositories.AssinaturaRepository;
import br.com.cotiinformatica.api_assinaturas.infrastructure.repositories.ClienteRepository;
import br.com.cotiinformatica.api_assinaturas.infrastructure.repositories.PlanoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssinaturaService {

    private final AssinaturaRepository assinaturaRepository;
    private final ClienteRepository clienteRepository;
    private final PlanoRepository planoRepository;

    public AssinaturaResponse criarAssinatura(AssinaturaRequest request) throws Exception {
        return null; //TODO
    }

    public AssinaturaResponse cancelarAssinatura(Integer id) throws Exception {
        return null; //TODO
    }
}
