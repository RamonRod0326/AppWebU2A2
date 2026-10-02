package com.ramon.U2T2.dto;

import jakarta.validation.constraints.*;

public class EnvioRequestDTO {

    @NotBlank(message = "El código postal es obligatorio")
    private String codigoPostal;

    @NotNull(message = "El peso es obligatorio")
    @Positive(message = "El peso debe ser mayor a 0")
    private Double pesoKg;

    @NotNull(message = "El largo es obligatorio")
    @Positive(message = "El largo debe ser mayor a 0")
    private Double largoCm;

    @NotNull(message = "El ancho es obligatorio")
    @Positive(message = "El ancho debe ser mayor a 0")
    private Double anchoCm;

    @NotNull(message = "El alto es obligatorio")
    @Positive(message = "El alto debe ser mayor a 0")
    private Double altoCm;

    @NotBlank(message = "El tipo de envío es obligatorio")
    @Pattern(regexp = "^(ESTANDAR|EXPRESS|MISMO_DIA)$", message = "El tipo de envío debe ser ESTANDAR, EXPRESS o MISMO_DIA")
    private String tipoEnvio;

    @NotNull(message = "El valor declarado es obligatorio")
    @Min(value = 0, message = "El valor declarado no puede ser negativo")
    private Double valorDeclarado;

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    public Double getPesoKg() { return pesoKg; }
    public void setPesoKg(Double pesoKg) { this.pesoKg = pesoKg; }
    public Double getLargoCm() { return largoCm; }
    public void setLargoCm(Double largoCm) { this.largoCm = largoCm; }
    public Double getAnchoCm() { return anchoCm; }
    public void setAnchoCm(Double anchoCm) { this.anchoCm = anchoCm; }
    public Double getAltoCm() { return altoCm; }
    public void setAltoCm(Double altoCm) { this.altoCm = altoCm; }
    public String getTipoEnvio() { return tipoEnvio; }
    public void setTipoEnvio(String tipoEnvio) { this.tipoEnvio = tipoEnvio; }
    public Double getValorDeclarado() { return valorDeclarado; }
    public void setValorDeclarado(Double valorDeclarado) { this.valorDeclarado = valorDeclarado; }
}