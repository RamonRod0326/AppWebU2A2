package com.ramon.U2T2.service;

import com.ramon.U2T2.dto.RentaVehiculoRequestDTO;
import com.ramon.U2T2.dto.RentaVehiculoResponseDTO;
import com.ramon.U2T2.exception.NegocioException;
import org.springframework.stereotype.Service;

@Service
public class RentaVehiculoService {

    public RentaVehiculoResponseDTO calcularCotizacion(RentaVehiculoRequestDTO request) {
        if (request.getEdadConductor() < 18) {
            throw new NegocioException("El conductor debe tener al menos 18 años.");
        }
        if (request.getDiasRenta() > 30) {
            throw new NegocioException("La renta no puede superar los 30 días.");
        }
        if (request.getKilometrosEstimados() > 5000) {
            throw new NegocioException("Los kilómetros estimados no pueden superar los 5,000 km.");
        }
        if ("CAMIONETA".equalsIgnoreCase(request.getTipoVehiculo()) && request.getEdadConductor() < 25) {
            throw new NegocioException("Para rentar una CAMIONETA el conductor debe tener al menos 25 años.");
        }

        double costoDiario;
        switch (request.getTipoVehiculo().toUpperCase()) {
            case "COMPACTO": costoDiario = 550.0; break;
            case "SEDAN": costoDiario = 700.0; break;
            case "SUV": costoDiario = 950.0; break;
            case "CAMIONETA": costoDiario = 1200.0; break;
            default: throw new NegocioException("Tipo de vehículo no válido.");
        }

        double costoRentaBase = costoDiario * request.getDiasRenta();
        double descuentoRenta = (request.getDiasRenta() >= 7) ? (costoRentaBase * 0.10) : 0.0;
        double costoRentaConDescuento = costoRentaBase - descuentoRenta;

        int kmIncluidos = request.getDiasRenta() * 100;
        int kmAdicionales = Math.max(0, request.getKilometrosEstimados() - kmIncluidos);
        double cargoKm = kmAdicionales * 4.0;

        double cargoJovenConductor = 0.0;
        if (request.getEdadConductor() >= 18 && request.getEdadConductor() <= 24) {
            cargoJovenConductor = (costoRentaConDescuento + cargoKm) * 0.15;
        }

        double cargoSeguro = Boolean.TRUE.equals(request.getSeguroCompleto()) ? (180.0 * request.getDiasRenta()) : 0.0;
        double costoTotal = costoRentaConDescuento + cargoKm + cargoJovenConductor + cargoSeguro;

        RentaVehiculoResponseDTO response = new RentaVehiculoResponseDTO();
        response.setNombreCliente(request.getNombreCliente());
        response.setTipoVehiculo(request.getTipoVehiculo());
        response.setDiasRenta(request.getDiasRenta());
        response.setCostoRentaBase(costoRentaBase);
        response.setDescuentoRenta(descuentoRenta);
        response.setKilometrosIncluidos(kmIncluidos);
        response.setCargoKilometrosAdicionales(cargoKm);
        response.setCargoJovenConductor(cargoJovenConductor);
        response.setCargoSeguro(cargoSeguro);
        response.setCostoTotal(costoTotal);

        return response;
    }
}