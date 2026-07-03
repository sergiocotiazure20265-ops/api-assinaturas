package br.com.cotiinformatica.api_assinaturas.domain.dtos.requests;

public record AssinaturaRequest(
        Integer planoId,
        Integer clienteId
) {
}
