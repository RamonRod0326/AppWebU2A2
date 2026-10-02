package com.ramon.U2T2.dto;

public class RentaVehiculoResponseDTO {
    private String nombreCliente;
    private String tipoVehiculo;
    private Integer diasRenta;
    private Double costoRentaBase;
    private Double descuentoRenta;
    private Integer kilometrosIncluidos;
    private Double cargoKilometrosAdicionales;
    private Double cargoJovenConductor;
    private Double cargoSeguro;
    private Double costoTotal;

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }
    public Integer getDiasRenta() { return diasRenta; }
    public void setDiasRenta(Integer diasRenta) { this.diasRenta = diasRenta; }
    public Double getCostoRentaBase() { return costoRentaBase; }
    public void setCostoRentaBase(Double costoRentaBase) { this.costoRentaBase = costoRentaBase; }
    public Double getDescuentoRenta() { return descuentoRenta; }
    public void setDescuentoRenta(Double descuentoRenta) { this.descuentoRenta = descuentoRenta; }
    public Integer getKilometrosIncluidos() { return kilometrosIncluidos; }
    public void setKilometrosIncluidos(Integer kilometrosIncluidos) { this.kilometrosIncluidos = kilometrosIncluidos; }
    public Double getCargoKilometrosAdicionales() { return cargoKilometrosAdicionales; }
    public void setCargoKilometrosAdicionales(Double cargoKilometrosAdicionales) { this.cargoKilometrosAdicionales = cargoKilometrosAdicionales; }
    public Double getCargoJovenConductor() { return cargoJovenConductor; }
    public void setCargoJovenConductor(Double cargoJovenConductor) { this.cargoJovenConductor = cargoJovenConductor; }
    public Double getCargoSeguro() { return cargoSeguro; }
    public void setCargoSeguro(Double cargoSeguro) { this.cargoSeguro = cargoSeguro; }
    public Double getCostoTotal() { return costoTotal; }
    public void setCostoTotal(Double costoTotal) { this.costoTotal = costoTotal; }
}