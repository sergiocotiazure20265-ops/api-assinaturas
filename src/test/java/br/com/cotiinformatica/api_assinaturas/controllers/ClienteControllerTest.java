package br.com.cotiinformatica.api_assinaturas.controllers;

import br.com.cotiinformatica.api_assinaturas.base.AbstractIntegrationTest;
import br.com.cotiinformatica.api_assinaturas.factories.ClienteTestFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Testes de integração do controller ClienteController")
public class ClienteControllerTest extends AbstractIntegrationTest {

    @Test
    @DisplayName("Deve criar um cliente com sucesso.")
    void criarClienteTest() throws Exception {

        //Gerando um cliente para cadastro na API
        var request = ClienteTestFactory.criarClienteRequest();

        //Executando a API
        mockMvc.perform(post("/api/v1/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(request))
        )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.nome").value(request.nome()))
                .andExpect(jsonPath("$.email").value(request.email()))
                .andExpect(jsonPath("$.cpf").value(request.cpf()));
    }

    @Test
    @DisplayName("Deve atualizar um cliente com sucesso.")
    void atualizarClienteTest() throws Exception {
        // Primeiro, criar um cliente
        var request = ClienteTestFactory.criarClienteRequest();
        
        var response = mockMvc.perform(post("/api/v1/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(request))
        )
                .andExpect(status().isCreated())
                .andReturn();
        
        var idCliente = objectMapper.readTree(response.getResponse().getContentAsString()).get("id").asInt();
        
        // Criar um novo cliente para atualização
        var requestUpdate = ClienteTestFactory.criarClienteRequest();
        
        // Atualizar o cliente
        mockMvc.perform(put("/api/v1/clientes/{id}", idCliente)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(requestUpdate))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idCliente))
                .andExpect(jsonPath("$.nome").value(requestUpdate.nome()))
                .andExpect(jsonPath("$.email").value(requestUpdate.email()))
                .andExpect(jsonPath("$.cpf").value(requestUpdate.cpf()));
    }

    @Test
    @DisplayName("Deve excluir um cliente com sucesso.")
    void excluirClienteTest() throws Exception {
        // Primeiro, criar um cliente
        var request = ClienteTestFactory.criarClienteRequest();
        
        var response = mockMvc.perform(post("/api/v1/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(request))
        )
                .andExpect(status().isCreated())
                .andReturn();
        
        var idCliente = objectMapper.readTree(response.getResponse().getContentAsString()).get("id").asInt();
        
        // Excluir o cliente
        mockMvc.perform(delete("/api/v1/clientes/{id}", idCliente))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idCliente))
                .andExpect(jsonPath("$.nome").value(request.nome()))
                .andExpect(jsonPath("$.email").value(request.email()))
                .andExpect(jsonPath("$.cpf").value(request.cpf()));
    }

    @Test
    @DisplayName("Deve consultar clientes com sucesso.")
    void consultarClientesTest() throws Exception {
        // Criar alguns clientes
        for (int i = 0; i < 3; i++) {
            var request = ClienteTestFactory.criarClienteRequest();
            mockMvc.perform(post("/api/v1/clientes")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(toJson(request))
            )
                    .andExpect(status().isCreated());
        }
        
        // Consultar todos os clientes com paginação
        mockMvc.perform(get("/api/v1/clientes?limit=10&offset=0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[0].id").isNumber())
                .andExpect(jsonPath("$.content[0].nome").isString())
                .andExpect(jsonPath("$.content[0].email").isString())
                .andExpect(jsonPath("$.content[0].cpf").isString());
    }

    @Test
    @DisplayName("Deve obter um cliente por id com sucesso.")
    void obterClientePorIdTest() throws Exception {
        // Primeiro, criar um cliente
        var request = ClienteTestFactory.criarClienteRequest();
        
        var response = mockMvc.perform(post("/api/v1/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(request))
        )
                .andExpect(status().isCreated())
                .andReturn();
        
        var idCliente = objectMapper.readTree(response.getResponse().getContentAsString()).get("id").asInt();
        
        // Obter o cliente por ID
        mockMvc.perform(get("/api/v1/clientes/{id}", idCliente))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idCliente))
                .andExpect(jsonPath("$.nome").value(request.nome()))
                .andExpect(jsonPath("$.email").value(request.email()))
                .andExpect(jsonPath("$.cpf").value(request.cpf()));
    }
}
