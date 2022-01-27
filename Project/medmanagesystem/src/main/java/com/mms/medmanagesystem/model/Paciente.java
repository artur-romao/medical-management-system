package com.mms.medmanagesystem.model;

//import lombok.Data;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Data
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private int id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_cc", referencedColumnName = "pessoacc")
    @JsonIgnore
    private Pessoa paciente;


    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "paciente")
    @JsonIgnore
    private Set<Consulta> consulta;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "paciente")
    @JsonIgnore
    private Set<Internamento> internamento;

    public Paciente() {}
    
    public Paciente(Pessoa paciente, Set<Consulta> consulta,  Set<Internamento> internamento) {
        this.paciente = paciente;
        this.consulta = consulta;
        this.internamento = internamento;
    }

    public Paciente(Pessoa paciente) { this.paciente=paciente; }

    @Column(name = "id_paciente")
    @JsonIgnore
    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    public Pessoa getPessoa() { return this.paciente; }

    public void setPessoa(Pessoa paciente) { this.paciente = paciente; }
    
    public Set<Internamento> getInternamento() { return this.internamento; }

    public void setInternamento(Set<Internamento> internamento) { this.internamento = internamento; } 

    public Set<Consulta> getConsulta() { return this.consulta; }

    public void setConsulta(Set<Consulta> consulta) { this.consulta = consulta; }
    
}