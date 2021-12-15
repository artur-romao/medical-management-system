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
    private int internado;

    //public Paciente() {} não consigo por isto, da me erros
    

    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "id_consulta", orphanRemoval = true)
    private Set<Consulta> consultas;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "id_internamento", orphanRemoval = true)
    private Set<Internado> internados;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "id_vac", orphanRemoval = true)
    private Set<Vacina> vacinas;
    
    @OneToOne
    @JoinColumn(name = "pessoa_cc")
    private Pessoa pessoa_cc;


    public Paciente(int id, Pessoa pessoa_cc, Medico medico, int internado) {
        this.id = id;
        this.pessoa_cc = pessoa_cc;
        this.medico = medico;
        this.internado = internado;
    }



    @Column(name = "id_paciente")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getCc() {
        return this.pessoa_cc;
    }

    public void setCc(Pessoa pessoa_cc) {
        this.pessoa_cc = pessoa_cc;
    }

    public Medico getAssMedico() {
        return this.medico;
    }

    public void setAssMedico(Medico medico) {
        this.medico = medico;
    }

    @Column(name = "Internado")
    public int getInternado() {
        return this.internado;
    }

    public void setInternado(int internado) {
        this.internado = internado;
    }
    
}