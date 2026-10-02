package com.ramon.U2T2.controller;

import com.ramon.U2T2.dto.RentaVehiculoRequestDTO;
import com.ramon.U2T2.dto.RentaVehiculoResponseDTO;
import com.ramon.U2T2.service.RentaVehiculoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cotizadores/rentas")
public class RentaVehiculoController {

    private final RentaVehiculoService rentaVehiculoService;

    public RentaVehiculoController(RentaVehiculoService rentaVehiculoService) {
        this.rentaVehiculoService = rentaVehiculoService;
    }

    @PostMapping
    public ResponseEntity<RentaVehiculoResponseDTO> cotizarRenta(@Valid @RequestBody RentaVehiculoRequestDTO request) {
        RentaVehiculoResponseDTO response = rentaVehiculoService.calcularCotizacion(request);
        return ResponseEntity.ok(response);
    }
}