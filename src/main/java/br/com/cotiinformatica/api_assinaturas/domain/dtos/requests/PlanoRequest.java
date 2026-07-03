package br.com.cotiinformatica.api_assinaturas.domain.dtos.requests;

public record PlanoRequest(
        String nome,
        String descricao,
        Double preco
) {
}
