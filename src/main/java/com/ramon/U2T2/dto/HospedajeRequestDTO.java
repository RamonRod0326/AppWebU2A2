package com.ramon.U2T2.dto;

import jakarta.validation.constraints.*;

public class HospedajeRequestDTO {

    @NotBlank(message = "El nombre del huésped es obligatorio")
    private String nombreHuesped;

    @NotBlank(message = "El tipo de habitación es obligatorio")
    @Pattern(regexp = "^(INDIVIDUAL|DOBLE|SUITE)$", message = "El tipo de habitación debe ser INDIVIDUAL, DOBLE o SUITE")
    private String tipoHabitacion;

    @NotNull(message = "El número de noches es obligatorio")
    @Min(value = 1, message = "El número de noches debe ser al menos 1")
    private Integer numeroNoches;

    @NotNull(message = "El número de huéspedes es obligatorio")
    @Min(value = 1, message = "Debe haber al menos 1 huésped")
    private Integer numeroHuespedes;

    @NotBlank(message = "La temporada es obligatoria")
    @Pattern(regexp = "^(BAJA|REGULAR|ALTA)$", message = "La temporada debe ser BAJA, REGULAR o ALTA")
    private String temporada;

    @NotNull(message = "Debe indicar si incluye desayuno")
    private Boolean incluyeDesayuno;

    @NotNull(message = "Debe indicar si incluye estacionamiento")
    private Boolean incluyeEstacionamiento;

    public String getNombreHuesped() { return nombreHuesped; }
    public void setNombreHuesped(String nombreHuesped) { this.nombreHuesped = nombreHuesped; }
    public String getTipoHabitacion() { return tipoHabitacion; }
    public void setTipoHabitacion(String tipoHabitacion) { this.tipoHabitacion = tipoHabitacion; }
    public Integer getNumeroNoches() { return numeroNoches; }
    public void setNumeroNoches(Integer numeroNoches) { this.numeroNoches = numeroNoches; }
    public Integer getNumeroHuespedes() { return numeroHuespedes; }
    public void setNumeroHuespedes(Integer numeroHuespedes) { this.numeroHuespedes = numeroHuespedes; }
    public String getTemporada() { return temporada; }
    public void setTemporada(String temporada) { this.temporada = temporada; }
    public Boolean getIncluyeDesayuno() { return incluyeDesayuno; }
    public void setIncluyeDesayuno(Boolean incluyeDesayuno) { this.incluyeDesayuno = incluyeDesayuno; }
    public Boolean getIncluyeEstacionamiento() { return incluyeEstacionamiento; }
    public void setIncluyeEstacionamiento(Boolean incluyeEstacionamiento) { this.incluyeEstacionamiento = incluyeEstacionamiento; }
}