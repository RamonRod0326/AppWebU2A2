package com.ramon.U2T2.dto;

import jakarta.validation.constraints.*;

public class RentaVehiculoRequestDTO {

    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String nombreCliente;

    @NotNull(message = "La edad del conductor es obligatoria")
    @Min(value = 1, message = "La edad debe ser mayor a 0")
    private Integer edadConductor;

    @NotBlank(message = "El tipo de vehículo es obligatorio")
    @Pattern(regexp = "^(COMPACTO|SEDAN|SUV|CAMIONETA)$", message = "El tipo debe ser COMPACTO, SEDAN, SUV o CAMIONETA")
    private String tipoVehiculo;

    @NotNull(message = "El número de días de renta es obligatorio")
    @Min(value = 1, message = "El número de días debe ser al menos 1")
    private Integer diasRenta;

    @NotNull(message = "Los kilómetros estimados son obligatorios")
    @Min(value = 0, message = "Los kilómetros no pueden ser negativos")
    private Integer kilometrosEstimados;

    @NotNull(message = "Debe indicar si contrata seguro completo")
    private Boolean seguroCompleto;

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public Integer getEdadConductor() { return edadConductor; }
    public void setEdadConductor(Integer edadConductor) { this.edadConductor = edadConductor; }
    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }
    public Integer getDiasRenta() { return diasRenta; }
    public void setDiasRenta(Integer diasRenta) { this.diasRenta = diasRenta; }
    public Integer getKilometrosEstimados() { return kilometrosEstimados; }
    public void setKilometrosEstimados(Integer kilometrosEstimados) { this.kilometrosEstimados = kilometrosEstimados; }
    public Boolean getSeguroCompleto() { return seguroCompleto; }
    public void setSeguroCompleto(Boolean seguroCompleto) { this.seguroCompleto = seguroCompleto; }
}