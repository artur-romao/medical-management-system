package com.mms.medmanagesystem.model;

//import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

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


    @OneToOne (mappedBy = "medico")
    @JsonIgnore
    private Medico medico;

    @OneToOne (mappedBy = "paciente")
    @JsonIgnore
    private Paciente paciente;


    public int getCC() {
        return this.pessoacc;
    }

    public void setCC(int pessoacc) {
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

    public String getDataNascimento() {
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

    public Medico getMedico(){
        return this.medico;
    }

    public Paciente getPaciente(){
        return this.paciente;
    }
}
