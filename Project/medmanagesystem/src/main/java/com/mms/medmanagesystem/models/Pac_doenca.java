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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pac_doenca")
public class Pac_doenca {
    @Id
    private int idPaciente;         
    private int idDoenca;

    //public Pac_doenca() {}

    public Pac_doenca (int idPaciente, int idDoenca){
        this.idPaciente = idPaciente;
        this.idDoenca = idDoenca;

    }


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    
    
    @Column(name = "idp")
    public int getIdPaciente() {
        return this.idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    @Column(name = "idd")
    public int getIdDoenca() {
        return this.idDoenca;
    }

    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }
    
}
