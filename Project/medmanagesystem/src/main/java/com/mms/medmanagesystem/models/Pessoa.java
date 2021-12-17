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
    private int pessoa_cc;
    private String nome;
    private String email;
    private int telemovel;
    private String morada;
    private String datanascimento;

    public Pessoa(int pessoa_cc, String nome, String email, int telemovel, String morada, String datanascimento) {
        this.nome = nome;
        this.email = email;
        this.pessoa_cc = pessoa_cc;
        this.telemovel = telemovel;
        this.morada = morada;
        this.datanascimento = datanascimento;
    }


    @OneToOne (mappedBy = "medico_cc")
    private Medico medico;

    @OneToOne (mappedBy = "paciente_cc")
    private Paciente paciente;


    @Column(name = "pessoa_cc")
    public int getCC() {
        return this.pessoa_cc;
    }

    @Column(name = "name")
    public String getNome() {
        return this.nome;
    }

    @Column(name = "email")
    public String getEmail() {
        return this.email;
    }

    @Column(name = "telemovel")
    public int getTelemovel() {
        return this.telemovel;
    }

    @Column(name = "dataNascimento")
    public String getDataNascimento() {
        return this.datanascimento;
    }
    @Column(name = "morada")
    public String getMorada() {
        return this.morada;
    }


    public void setCC(int pessoa_cc) {
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
