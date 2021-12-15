package com.mms.medmanagesystem.models;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Pac_vac")
public class Pac_vac {

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paciente")
    @Id
    private Paciente paciente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_vacina")
    private Vacina vacinas;

    // public Pac_vac (){ }
    public Pac_vac(Paciente paciente, Vacina vacinas) {
        this.paciente = paciente;
        this.vacinas = vacinas;
    }

    public Paciente getpaciente() {
        return this.paciente;
    }

    public void setpaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Vacina getvacinas() {
        return this.vacinas;
    }

    public void setvacinas(Vacina vacinas) {
        this.vacinas = vacinas;
    }

}
