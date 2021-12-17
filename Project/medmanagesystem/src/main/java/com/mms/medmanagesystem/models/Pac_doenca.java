/* package com.mms.medmanagesystem.models;

import lombok.Data;

import java.util.HashMap;

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

    @ManyToOne(optional = false)
    //@JoinColumn(name = "id_paciente")
    //@Id
    private Paciente paciente;

    @ManyToOne(optional = false)
    //@JoinColumn(name = "id_paciente")
    private Doenca doenca;

    @Id
    HashMap<Paciente, Doenca> paciente_doenca = new HashMap<>();
    

    public Pac_doenca() {}

    public Pac_doenca (Paciente paciente, Doenca doenca){
        this.paciente = paciente;
        this.doenca = doenca;
        paciente_doenca.put(this.paciente, this.doenca);
    }


    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doenca getDoenca() {
        return this.doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    @Column(name = "paciente_doenca")
    public HashMap<Paciente,Doenca> getPaciente_doenca() {
        return this.paciente_doenca;
    }

    public void setPaciente_doenca(HashMap<Paciente,Doenca> paciente_doenca) {
        this.paciente_doenca = paciente_doenca;
    }
    
}
 */