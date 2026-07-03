package br.com.cotiinformatica.api_assinaturas.domain.dtos.responses;

public record PlanoResponse(
        Integer id,
        String nome,
        String descricao,
        Double preco
) {
}
