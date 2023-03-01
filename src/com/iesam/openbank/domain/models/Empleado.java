package com.iesam.openbank.domain.models;

public class Empleado extends Persona{

    private String numeroSeguridadSocial;

    //Funciones

    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }
}
