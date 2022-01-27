package com.mms.medmanagesystem.model;

import java.util.Set;

//import lombok.Data;
//import lombok.EqualsAndHashCode;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

// @Data
@Entity
@Table(name = "profissional")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profissional")
    private int id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profissional_cc", referencedColumnName = "pessoacc") //referenccedColumName é o que vem de pessoa
    @JsonIgnore
    private Pessoa profissional;

    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_area")
    @JsonIgnore
    private Area area;

    private String pro;


    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "profissional", orphanRemoval = true)
    private Set<Internamento> internamento; 

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "profissional", orphanRemoval = true)
    private Set<Consulta> consultas;
    
    public Profissional(){}

    public Profissional(Pessoa profissional) {
        this.profissional=profissional;
    }

    public Profissional(String password, Pessoa profissional, Area area, String pro) { 
        this.area = area;
        this.profissional = profissional;
        this.password = password;
        this.pro = pro;
    }
    
    public static enum state {

        MEDICO("Medico"),
        ENFERMEIRO("Enfermeiro");
        
        private final String profissional;  
    
        private state (String profissional) {
            this.profissional = profissional;
        }
    
        public boolean equalsProfissional(String otherProfissional) {
            return profissional.equals(otherProfissional);
        }
    
        public String toString() {
           return this.profissional;
        }
        
    }

    @Column(name = "id_profissional")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return this.profissional;
    }

    public void setPessoa(Pessoa profissional) {
        this.profissional = profissional;
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

    public String getPro() {
        return this.pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public Set<Internamento> getInternamento() {
        return this.internamento;
    }

    public void setInternamento(Set<Internamento> internamento) {
        this.internamento = internamento;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", profissional='" + getPessoa() + "'" +
            ", password='" + getPassword() + "'" +
            ", area='" + getArea() + "'" +
            ", pro='" + getPro() + "'" +
            "}";
    }
    

}