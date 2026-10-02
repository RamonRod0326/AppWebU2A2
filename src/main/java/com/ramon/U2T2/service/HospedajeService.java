package com.ramon.U2T2.service;

import com.ramon.U2T2.dto.HospedajeRequestDTO;
import com.ramon.U2T2.dto.HospedajeResponseDTO;
import com.ramon.U2T2.exception.NegocioException;
import org.springframework.stereotype.Service;

@Service
public class HospedajeService {

    public HospedajeResponseDTO calcularCotizacion(HospedajeRequestDTO request) {
        if (request.getNumeroNoches() > 30) {
            throw new NegocioException("El número de noches no puede superar 30.");
        }

        String tipoHab = request.getTipoHabitacion().toUpperCase();
        int maxPersonas;
        double costoNoche;

        switch (tipoHab) {
            case "INDIVIDUAL":
                maxPersonas = 1;
                costoNoche = 700.0;
                break;
            case "DOBLE":
                maxPersonas = 2;
                costoNoche = 1100.0;
                break;
            case "SUITE":
                maxPersonas = 4;
                costoNoche = 1800.0;
                break;
            default:
                throw new NegocioException("Tipo de habitación no válido.");
        }

        if (request.getNumeroHuespedes() > maxPersonas) {
            throw new NegocioException("El número de huéspedes (" + request.getNumeroHuespedes() +
                    ") supera la capacidad máxima de la habitación " + tipoHab + " (" + maxPersonas + " persona/s).");
        }

        double costoHospedajeBase = costoNoche * request.getNumeroNoches();

        double ajusteTemporada = 0.0;
        if ("BAJA".equalsIgnoreCase(request.getTemporada())) {
            ajusteTemporada = - (costoHospedajeBase * 0.10);
        } else if ("ALTA".equalsIgnoreCase(request.getTemporada())) {
            ajusteTemporada = costoHospedajeBase * 0.25;
        }

        double hospedajeConTemporada = costoHospedajeBase + ajusteTemporada;
        double descuentoLargaEstancia = (request.getNumeroNoches() >= 7) ? (hospedajeConTemporada * 0.08) : 0.0;
        double hospedajeAjustado = hospedajeConTemporada - descuentoLargaEstancia;

        double costoDesayuno = Boolean.TRUE.equals(request.getIncluyeDesayuno()) ?
                (request.getNumeroHuespedes() * request.getNumeroNoches() * 150.0) : 0.0;

        double costoEstacionamiento = Boolean.TRUE.equals(request.getIncluyeEstacionamiento()) ?
                (request.getNumeroNoches() * 100.0) : 0.0;

        double subtotal = hospedajeAjustado + costoDesayuno + costoEstacionamiento;
        double impuestoHospedaje = subtotal * 0.04;
        double total = subtotal + impuestoHospedaje;

        HospedajeResponseDTO response = new HospedajeResponseDTO();
        response.setNombreHuesped(request.getNombreHuesped());
        response.setTipoHabitacion(request.getTipoHabitacion());
        response.setNumeroNoches(request.getNumeroNoches());
        response.setNumeroHuespedes(request.getNumeroHuespedes());
        response.setCostoHospedajeBase(costoHospedajeBase);
        response.setAjusteTemporada(ajusteTemporada);
        response.setDescuentoLargaEstancia(descuentoLargaEstancia);
        response.setCostoDesayuno(costoDesayuno);
        response.setCostoEstacionamiento(costoEstacionamiento);
        response.setSubtotal(subtotal);
        response.setImpuestoHospedaje(impuestoHospedaje);
        response.setTotal(total);

        return response;
    }
}