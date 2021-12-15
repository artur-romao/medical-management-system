package com.mms.medmanagesystem.models;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@Table(name = "person")
public class Pessoa {
    @Id
    @Column(name = "pessoa_cc")
    private Pessoa pessoa_cc;
    private String nome;
    private String email;
    private int telemovel;
    private String morada;
    private String datanascimento;

    public Pessoa(Pessoa pessoa_cc, String nome, String email, int telemovel, String morada, String datanascimento) {
        this.nome = nome;
        this.email = email;
        this.pessoa_cc = pessoa_cc;
        this.telemovel = telemovel;
        this.morada = morada;
        this.datanascimento = datanascimento;
    }

    //public Pessoa() {}

    @OneToOne (mappedBy = "person")
    private Medico medico;

    @OneToOne (mappedBy = "person")
    private Paciente paciente;


    public Pessoa getCC() {
        return this.pessoa_cc;
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


    public void setCC(Pessoa pessoa_cc) {
        this.pessoa_cc = pessoa_cc;
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
