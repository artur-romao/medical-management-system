package com.mms.medmanagesystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "pac_doenca")
public class Pac_doenca {

    //public Pac_doenca() {}

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paciente")
    @Id
    private Paciente paciente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paciente")
    private Doenca paciente_doenca;
    
    public Pac_doenca (Paciente paciente, Doenca paciente_doenca){
        this.paciente = paciente;
        this.paciente_doenca = paciente_doenca;

    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setpaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doenca getdoenca() {
        return this.paciente_doenca;
    }

    public void setdoenca(Doenca paciente_doenca) {
        this.paciente_doenca = paciente_doenca;
    }
    
}
