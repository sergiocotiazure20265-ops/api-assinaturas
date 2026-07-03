package br.com.cotiinformatica.api_assinaturas.application.controllers;

import br.com.cotiinformatica.api_assinaturas.domain.services.AssinaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assinaturas")
@RequiredArgsConstructor
public class AssinaturaController {

    private final AssinaturaService assinaturaService;
}
