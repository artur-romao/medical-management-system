package com.mms.medmanagesystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Pessoa {
    @Id
    private int cc;
    private String nome;
    private String email;
    private int telemovel;
    private String morada;
    private String datanascimento;

    public Pessoa(int cc, String nome, String email, int telemovel, String morada, String datanascimento) {
        this.nome = nome;
        this.email = email;
        this.cc = cc;
        this.telemovel = telemovel;
        this.morada = morada;
        this.datanascimento = datanascimento;
    }

    //public Pessoa() {}

    @OneToOne (mappedBy = "person")
    private Medico medico;

    @OneToOne (mappedBy = "person")
    private Paciente paciente;

    
    


    @Column(name = "cc_pessoa")
    public int getCC() {
        return this.cc;
    }

    @Column(name = "Nome")
    public String getName() {
        return this.nome;
    }

    @Column(name = "email")
    public String getEmail() {
        return this.email;
    }

    @Column(name = "Telemovel")
    public int getTelemovel() {
        return this.telemovel;
    }

    @Column(name = "DataNascimento")
    public String getDataNascimento() {
        return this.datanascimento;
    }
    @Column(name = "Morada")
    public String getMorada() {
        return this.morada;
    }


    public void setCC(int cc) {
        this.cc = cc;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
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
    

}
