package com.ramon.U2T2.service;

import com.ramon.U2T2.dto.EnvioRequestDTO;
import com.ramon.U2T2.dto.EnvioResponseDTO;
import com.ramon.U2T2.exception.NegocioException;
import org.springframework.stereotype.Service;

@Service
public class EnvioService {

    public EnvioResponseDTO calcularCotizacion(EnvioRequestDTO request) {
        if (request.getPesoKg() > 50) {
            throw new NegocioException("No se aceptan paquetes que pesen más de 50 kg.");
        }

        if (request.getLargoCm() > 150 || request.getAnchoCm() > 150 || request.getAltoCm() > 150) {
            throw new NegocioException("No se aceptan paquetes con alguna dimensión superior a 150 cm.");
        }

        double volumen = request.getLargoCm() * request.getAnchoCm() * request.getAltoCm();
        if (volumen > 1_000_000) {
            throw new NegocioException("No se aceptan paquetes con un volumen superior a 1,000,000 cm³.");
        }

        double costoBase = 80.0;
        double cargoPeso = request.getPesoKg() * 12.0;
        double cargoVolumen = (volumen > 50_000) ? 100.0 : 0.0;

        double subtotalAcumulado = costoBase + cargoPeso + cargoVolumen;
        double recargoTipoEnvio = 0.0;

        if ("EXPRESS".equalsIgnoreCase(request.getTipoEnvio())) {
            recargoTipoEnvio = subtotalAcumulado * 0.40;
        } else if ("MISMO_DIA".equalsIgnoreCase(request.getTipoEnvio())) {
            recargoTipoEnvio = subtotalAcumulado * 0.70;
        }

        double costoSeguro = (request.getValorDeclarado() > 10_000) ? (request.getValorDeclarado() * 0.02) : 0.0;

        double costoTotal = subtotalAcumulado + recargoTipoEnvio + costoSeguro;

        EnvioResponseDTO response = new EnvioResponseDTO();
        response.setCodigoPostal(request.getCodigoPostal());
        response.setPesoKg(request.getPesoKg());
        response.setVolumenCm3(volumen);
        response.setTipoEnvio(request.getTipoEnvio());
        response.setCostoBase(costoBase);
        response.setCargoPeso(cargoPeso);
        response.setCargoVolumen(cargoVolumen);
        response.setRecargoTipoEnvio(recargoTipoEnvio);
        response.setCostoSeguro(costoSeguro);
        response.setCostoTotal(costoTotal);

        return response;
    }
}