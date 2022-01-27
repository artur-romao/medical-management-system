package com.mms.medmanagesystem.model;

import java.sql.Date;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity 
@Table(name = "pessoa") 
public class Pessoa {

    @Id
    @Column(name = "pessoacc")
    @JsonIgnore

    private int pessoacc;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "telemovel")
    private int telemovel;

    @Column(name = "morada")
    private String morada;

    @Column(name = "datanascimento")
    private Date datanascimento;
    
    public Pessoa () {}

     public Pessoa(int pessoacc, String name, String email, int telemovel, String morada, Date datanascimento) {
        this.pessoacc = pessoacc;
        this.name = name;
        this.email = email;
        this.telemovel = telemovel;
        this.morada = morada;
        this.datanascimento = datanascimento;
    }

    @OneToOne(mappedBy = "profissional", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore

    private Profissional profissional;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore

    private Paciente paciente;


    public int getPessoacc() { return this.pessoacc; }

    public void setPessoacc(int pessoacc) { this.pessoacc = pessoacc; }

    public String getName() { return this.name; }

    
    public void setName(String name) { this.name = name; }

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }
    
    public int getTelemovel() { return this.telemovel; }

    public void setTelemovel(int telemovel) { this.telemovel = telemovel; }

    public Date getDatanascimento() { return this.datanascimento; }

    public void setDatanascimento(Date datanascimento) { this.datanascimento = datanascimento; } 
    
    public String getMorada() { return this.morada; }

    public void setMorada(String morada) { this.morada = morada; }

    public Profissional getProfissional() { return this.profissional; }

    public Paciente getPaciente() { return this.paciente; }

}
