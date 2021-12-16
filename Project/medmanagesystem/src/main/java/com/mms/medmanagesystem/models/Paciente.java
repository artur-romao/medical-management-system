package com.mms.medmanagesystem.models;

import lombok.Data;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue
    private int id;

    public Paciente() {}

    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "paciente", orphanRemoval = true)
    private Set<Consulta> consultas;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "paciente", orphanRemoval = true)
    private Set<Internamentos> internamentos;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "paciente", orphanRemoval = true)
    private Set<Pac_vac> vacinas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_cc", referencedColumnName = "pessoa_cc") //referenccedColumName é o que vem de pessoa
    private Pessoa paciente_cc;


    public Paciente(int id, Pessoa pessoa_cc, Medico medico, Set<Internamentos> internamentos) {
        this.id = id;
        this.paciente_cc = pessoa_cc;
        this.medico = medico;
        this.internamentos = internamentos;
    }



    @Column(name = "id_paciente")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getCc() {
        return this.paciente_cc;
    }

    public void setCc(Pessoa pessoa_cc) {
        this.paciente_cc = pessoa_cc;
    }

    public Medico getAssMedico() {
        return this.medico;
    }

    public void setAssMedico(Medico medico) {
        this.medico = medico;
    }

    public Set<Internamentos> getInternado() {
        return this.internamentos;
    }

    public void setInternado(Set<Internamentos> internamentos) {
        this.internamentos = internamentos;
    }
    
}