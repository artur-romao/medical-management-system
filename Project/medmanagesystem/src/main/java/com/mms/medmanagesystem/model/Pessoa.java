package com.mms.medmanagesystem.model;

//import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import javax.persistence.OneToOne;

// @Data 
@Entity 
@Table(name = "pessoa") 
public class Pessoa {

    @Id
    @Column(name = "pessoacc")
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
    private String datanascimento;
    
    public Pessoa () {}

     public Pessoa(int pessoacc, String name, String email, int telemovel, String morada, String datanascimento) {
        this.pessoacc = pessoacc;
        this.name = name;
        this.email = email;
        this.telemovel = telemovel;
        this.morada = morada;
        this.datanascimento = datanascimento;
    }


    @OneToOne (mappedBy = "profissional")
    @JsonIgnore
    private Profissional profissional;

    @OneToOne (mappedBy = "paciente")
    @JsonIgnore
    private Paciente paciente;


    public int getPessoacc() {
        return this.pessoacc;
    }

    public void setCc(int pessoacc) {
        this.pessoacc = pessoacc;
    }

    public String getNome() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public int getTelemovel() {
        return this.telemovel;
    }

    public String getDatanascimento() {
        return this.datanascimento;
    }
    public String getMorada() {
        return this.morada;
    }

    
    public void setNome(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    } 

    public Profissional getProfissional(){
        return this.profissional;
    }

    public Paciente getPaciente(){
        return this.paciente;
    }
}
