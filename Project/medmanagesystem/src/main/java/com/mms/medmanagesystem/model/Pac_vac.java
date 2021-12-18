package com.mms.medmanagesystem.model;
/* package com.mms.medmanagesystem.models;

import lombok.Data;

import java.util.HashMap;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "pac_vac")
public class Pac_vac {

    @ManyToOne(optional = false)
    //@JoinColumn(name = "id_paciente")
    //@Id
    private Paciente paciente;

    @ManyToOne(optional = false)
    //@JoinColumn(name = "id_vacina")
    //@Id
    private Vacina vacina;

    @Id
    HashMap<Paciente, Vacina> paciente_vacina = new HashMap<>();

    public Pac_vac (){ }

    public Pac_vac(Paciente paciente, Vacina vacina) {
        this.paciente = paciente;
        this.vacina = vacina;
        paciente_vacina.put(this.paciente, this.vacina);
    }

    public Paciente getpaciente() {
        return this.paciente;
    }

    public void setpaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    
    public Vacina getvacina() {
        return this.vacina;
    }

    public void setvacina(Vacina vacina) {
        this.vacina = vacina;
    }

    @Column(name = "paciente_vacina")
    public HashMap<Paciente,Vacina> getPaciente_vacina() {
        return this.paciente_vacina;
    }

    public void setPaciente_vacina(HashMap<Paciente,Vacina> paciente_vacina) {
        this.paciente_vacina = paciente_vacina;
    }


}
 */