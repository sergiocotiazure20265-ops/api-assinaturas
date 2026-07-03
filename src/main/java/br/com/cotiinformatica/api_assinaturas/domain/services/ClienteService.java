package br.com.cotiinformatica.api_assinaturas.domain.services;

import br.com.cotiinformatica.api_assinaturas.domain.dtos.requests.ClienteRequest;
import br.com.cotiinformatica.api_assinaturas.domain.dtos.responses.ClienteResponse;
import br.com.cotiinformatica.api_assinaturas.domain.entities.Cliente;
import br.com.cotiinformatica.api_assinaturas.domain.exceptions.RegistroNaoEncontrado;
import br.com.cotiinformatica.api_assinaturas.infrastructure.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteResponse criarCliente(ClienteRequest request) throws Exception {

        var cliente = new Cliente();

        cliente.setNome(request.nome());
        cliente.setEmail(request.email());
        cliente.setCpf(request.cpf());

        clienteRepository.save(cliente);

        return toResponse(cliente);
    }

    public ClienteResponse alterarCliente(Integer id, ClienteRequest request) throws Exception {

        var registro = clienteRepository.findById(id);

        if(registro.isEmpty())
            throw new RegistroNaoEncontrado("Cliente não encontrado para o id informado: " + id);

        var cliente = registro.get();

        cliente.setNome(request.nome());
        cliente.setEmail(request.email());
        cliente.setCpf(request.cpf());

        clienteRepository.save(cliente);

        return toResponse(cliente);
    }

    public ClienteResponse excluirCliente(Integer id) throws Exception {

        var registro = clienteRepository.findById(id);

        if(registro.isEmpty())
            throw new RegistroNaoEncontrado("Cliente não encontrado para o id informado: " + id);

        var cliente = registro.get();

        clienteRepository.delete(cliente);

        return toResponse(cliente);
    }

    public Page<ClienteResponse> consultarClientes(Pageable pageable) throws Exception {

        var clientes = clienteRepository.findAll(pageable);

        return clientes.map(cliente -> toResponse(cliente));
    }

    public ClienteResponse obterCliente(Integer id) throws Exception {

        var registro = clienteRepository.findById(id);

        if(registro.isEmpty())
            throw new RegistroNaoEncontrado("Cliente não encontrado para o id informado: " + id);

        var cliente = registro.get();

        return toResponse(cliente);
    }

    private ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId().intValue(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getCpf()
        );
    }
}
