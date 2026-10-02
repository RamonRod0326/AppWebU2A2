package com.ramon.U2T2.dto;

public class EnvioResponseDTO {
    private String codigoPostal;
    private Double pesoKg;
    private Double volumenCm3;
    private String tipoEnvio;
    private Double costoBase;
    private Double cargoPeso;
    private Double cargoVolumen;
    private Double recargoTipoEnvio;
    private Double costoSeguro;
    private Double costoTotal;

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    public Double getPesoKg() { return pesoKg; }
    public void setPesoKg(Double pesoKg) { this.pesoKg = pesoKg; }
    public Double getVolumenCm3() { return volumenCm3; }
    public void setVolumenCm3(Double volumenCm3) { this.volumenCm3 = volumenCm3; }
    public String getTipoEnvio() { return tipoEnvio; }
    public void setTipoEnvio(String tipoEnvio) { this.tipoEnvio = tipoEnvio; }
    public Double getCostoBase() { return costoBase; }
    public void setCostoBase(Double costoBase) { this.costoBase = costoBase; }
    public Double getCargoPeso() { return cargoPeso; }
    public void setCargoPeso(Double cargoPeso) { this.cargoPeso = cargoPeso; }
    public Double getCargoVolumen() { return cargoVolumen; }
    public void setCargoVolumen(Double cargoVolumen) { this.cargoVolumen = cargoVolumen; }
    public Double getRecargoTipoEnvio() { return recargoTipoEnvio; }
    public void setRecargoTipoEnvio(Double recargoTipoEnvio) { this.recargoTipoEnvio = recargoTipoEnvio; }
    public Double getCostoSeguro() { return costoSeguro; }
    public void setCostoSeguro(Double costoSeguro) { this.costoSeguro = costoSeguro; }
    public Double getCostoTotal() { return costoTotal; }
    public void setCostoTotal(Double costoTotal) { this.costoTotal = costoTotal; }
}