package br.com.cotiinformatica.api_assinaturas.domain.dtos.responses;

public record AssinaturaResponse(
        Integer id,
        String dataAssinatura,
        Double valor,
        Boolean status,
        PlanoResponse plano,
        ClienteResponse cliente
) {
}
