package com.mms.medmanagesystem.enumFolder;

public enum ProfissionalEnum {

    MEDICO("Medico"),
    ENFERMEIRO("Enfermeiro");
    
    private final String profissional;  

    private ProfissionalEnum (String profissional) {
        this.profissional = profissional;
    }

    public boolean equalsProfissional(String otherProfissional) {
        return profissional.equals(otherProfissional);
    }

    public String toString() {
       return this.profissional;
    }
    
}
