package com.mms.medmanagesystem.model;

//import lombok.Data;
//import lombok.EqualsAndHashCode;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// @Data
@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medico_cc", referencedColumnName = "pessoacc") //referenccedColumName é o que vem de pessoa
    private Pessoa medico;

    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_area")
    private Area area;


/*     @OneToMany(cascade = CascadeType.ALL ,mappedBy = "medico", orphanRemoval = true)
    private Set<Internamentos> internamentos;  */


/*     @OneToMany(cascade = CascadeType.ALL ,mappedBy = "medico", orphanRemoval = true)
    private Set<Consulta> consultas; */
    
    public Medico(){}

    public Medico(String password, Pessoa medico, Area area) { 
        this.area = area;
        this.medico = medico;
        this.password = password;
    }

    @Column(name = "id_medico")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getMedico() {
        return this.medico;
    }

    public void setMedico(Pessoa medico) {
        this.medico = medico;
    }

    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Column(name = "pswd")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}