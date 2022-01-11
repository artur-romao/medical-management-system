package com.mms.medmanagesystem.model;

//import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Data
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    @JsonIgnore
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_cc", referencedColumnName = "pessoa_cc") //referenccedColumName é o que vem de pessoa
    private Pessoa paciente;


    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "paciente", orphanRemoval = true)
    private Set<Consulta> consultas;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "paciente", orphanRemoval = true)
    private Set<Internamentos> internamentos;


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
    
    public Paciente(int id, Pessoa paciente , Set<Internamentos> internamentos) {
        this.id = id;
        this.paciente = paciente;
        this.internamentos = internamentos;
    }

    @Column(name = "id_paciente")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPacienteCc() {
        return this.paciente;
    }

    public void setPacienteCc(Pessoa paciente) {
        this.paciente = paciente;
    }
    
    public Set<Internamentos> getInternamentos() {
        return this.internamentos;
    }

    public void setInternamentos(Set<Internamentos> internamentos) {
        this.internamentos = internamentos;
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
    
}