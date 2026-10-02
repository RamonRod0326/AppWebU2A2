package com.ramon.U2T2.controller;

import com.ramon.U2T2.dto.EnvioRequestDTO;
import com.ramon.U2T2.dto.EnvioResponseDTO;
import com.ramon.U2T2.service.EnvioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cotizadores/envios")
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @PostMapping
    public ResponseEntity<EnvioResponseDTO> cotizarEnvio(@Valid @RequestBody EnvioRequestDTO request) {
        EnvioResponseDTO response = envioService.calcularCotizacion(request);
        return ResponseEntity.ok(response);
    }
}