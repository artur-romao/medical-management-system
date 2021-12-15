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
@Table(name = "Pac_vac")
public class Pac_vac {
    @Id
    private int idp;
    private int idVac;
    //public Pac_vac (){ }
    public Pac_vac(int idp, int idVac) {
        this.idp = idp;
        this.idVac = idVac;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_vacina")
    private Vacina vacinas;

    
    @Column(name = "idp")
    public int getIdp() {
        return this.idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    @Column(name = "idvac")
    public int getIdVac() {
        return this.idVac;
    }

    public void setIdVac(int idVac) {
        this.idVac = idVac;
    }

    

    

    
}
