package com.ramon.U2T2.controller;

import com.ramon.U2T2.dto.HospedajeRequestDTO;
import com.ramon.U2T2.dto.HospedajeResponseDTO;
import com.ramon.U2T2.service.HospedajeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cotizadores/hospedajes")
public class HospedajeController {

    private final HospedajeService hospedajeService;

    public HospedajeController(HospedajeService hospedajeService) {
        this.hospedajeService = hospedajeService;
    }

    @PostMapping
    public ResponseEntity<HospedajeResponseDTO> cotizarHospedaje(@Valid @RequestBody HospedajeRequestDTO request) {
        HospedajeResponseDTO response = hospedajeService.calcularCotizacion(request);
        return ResponseEntity.ok(response);
    }
}