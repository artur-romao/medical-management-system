package com.mms.medmanagesystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue
    private int id;
    private int cc;
    private int assMedico;
    private int internado;


    public Paciente(int id, int cc, int assMedico, int internado) {
        this.id = id;
        this.cc = cc;
        this.assMedico = assMedico;
        this.internado = internado;
    }

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
    @JoinColumn(name = "cc_pessoa")
    private Pessoa pessoa;


    

    @Column(name = "id_paciente")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "cc_paciente")
    public int getCc() {
        return this.cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    @Column(name = "assMedico")
    public int getAssMedico() {
        return this.assMedico;
    }

    public void setAssMedico(int assMedico) {
        this.assMedico = assMedico;
    }

    @Column(name = "Internado")
    public int getInternado() {
        return this.internado;
    }

    public void setInternado(int internado) {
        this.internado = internado;
    }
    
}