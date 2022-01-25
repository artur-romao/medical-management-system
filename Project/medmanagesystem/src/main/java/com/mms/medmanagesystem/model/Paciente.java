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

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    private Pessoa paciente;


    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "paciente")
    private Set<Consulta> consulta;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "paciente")
    private Set<Internamento> internamento;


    // @OneToMany(cascade = CascadeType.ALL ,mappedBy = "paciente", orphanRemoval = true)
    // private Set<Pac_vac> vacinas;

    // @OneToMany(cascade = CascadeType.ALL ,mappedBy = "paciente", orphanRemoval = true)
    // private Set<Pac_doenca> doencas;

    /*
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "pac_vacina", 
        joinColumns = { @JoinColumn(name = "paciente") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_vacina") }
    )
    Set<Vacina> vacinas = new HashSet<>();


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "pac_doenca", 
        joinColumns = { @JoinColumn(name = "paciente") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_doenca") }
    )
    Set<Doenca> doencas = new HashSet<>();
    */

    public Paciente() {}
    
    public Paciente(Pessoa paciente, Set<Consulta> consulta,  Set<Internamento> internamento) {
        this.paciente = paciente;
        this.consulta = consulta;
        this.internamento = internamento;
    }

    public Paciente(Pessoa paciente) {
        this.paciente=paciente;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return this.paciente;
    }

    public void setPessoa(Pessoa paciente) {
        this.paciente = paciente;
    }
    
    public Set<Internamento> getInternamento() {
        return this.internamento;
    }

    public void setInternamento(Set<Internamento> internamento) {
        this.internamento = internamento;
    } 

    public Set<Consulta> getConsulta() {
        return this.consulta;
    }

    public void setConsulta(Set<Consulta> consulta) {
        this.consulta = consulta;
    }
   

    /*
    public Set<Vacina> getVacinas() {
        return this.vacinas;
    }

    public void setVacinas(Set<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public Set<Doenca> getDoencas() {
        return this.doencas;
    }

    public void setDoencas(Set<Doenca> doencas) {
        this.doencas = doencas;
    }
    */

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", paciente='" + getPessoa() + "'" +
            ", consulta='" + getConsulta() + "'" +
            ", internamento='" + getInternamento() + "'" +
            "}";
    }
    
}