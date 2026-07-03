package br.com.cotiinformatica.api_assinaturas.domain.dtos.requests;

public record ClienteRequest(
        String nome,
        String email,
        String cpf
) {
}
