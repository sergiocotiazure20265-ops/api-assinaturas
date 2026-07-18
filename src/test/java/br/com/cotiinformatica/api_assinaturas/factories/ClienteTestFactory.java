package br.com.cotiinformatica.api_assinaturas.factories;

import br.com.cotiinformatica.api_assinaturas.domain.dtos.requests.ClienteRequest;
import com.github.javafaker.Faker;

import java.util.Locale;

public final class ClienteTestFactory {

    //Java Faker
    private static final Faker faker
            = new Faker(new Locale("pt", "BR"));

    public static ClienteRequest criarClienteRequest() {
        return new ClienteRequest(
                faker.name().fullName(), //Nome do cliente
                faker.internet().emailAddress(), //Email do cliente
                faker.number().digits(11)); //CPF do cliente
    }
}
