package br.com.cotiinformatica.api_assinaturas.infrastructure.configurations;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI apiAssinaturasOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Assinaturas")
                        .description("API REST para gerenciamento de assinaturas, clientes, planos e pagamentos.")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("COTI Informática")
                                .email("coti@email.com")
                                .url("https://www.cotiinformatica.com.br"))
                        .license(new License()
                                .name("Apache License 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação oficial da COTI Informática")
                        .url("https://www.cotiinformatica.com.br"));
    }
}