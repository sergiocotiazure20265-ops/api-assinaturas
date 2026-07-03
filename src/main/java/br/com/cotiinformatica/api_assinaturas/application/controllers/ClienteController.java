package br.com.cotiinformatica.api_assinaturas.application.controllers;

import br.com.cotiinformatica.api_assinaturas.domain.dtos.requests.ClienteRequest;
import br.com.cotiinformatica.api_assinaturas.domain.dtos.responses.ClienteResponse;
import br.com.cotiinformatica.api_assinaturas.domain.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponse post(@RequestBody ClienteRequest request) throws Exception {
        return clienteService.criarCliente(request);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponse put(@PathVariable Integer id, @RequestBody ClienteRequest request) throws Exception {
        return clienteService.alterarCliente(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponse delete(@PathVariable Integer id) throws Exception {
        return clienteService.excluirCliente(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<ClienteResponse> get(
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "0") int offset
    ) throws Exception {
        var pageable = PageRequest.of(offset, limit);
        return clienteService.consultarClientes(pageable);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponse get(@PathVariable Integer id) throws Exception {
        return clienteService.obterCliente(id);
    }
}
