package com.mms.medmanagesystem.enumFolder;

public enum EstadoEnum {

    ESTAVEL("estavel"),
    GRAVE("grave"),
    COMA("coma");

    private final String estado;  

    private EstadoEnum (String estado) {
        this.estado = estado;
    }

    public boolean equalsEstado(String otherEstado) {
        return estado.equals(otherEstado);
    }

    public String toString() {
       return this.estado;
    }
}