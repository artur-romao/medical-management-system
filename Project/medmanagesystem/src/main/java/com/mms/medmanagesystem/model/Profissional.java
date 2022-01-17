package com.mms.medmanagesystem.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

// @Data
@Entity
@Table(name = "profissional")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profissional")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profissional_cc", referencedColumnName = "pessoacc") //referenccedColumName é o que vem de pessoa
    private Pessoa profissional;

    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_area")
    private Area area;

    private String pro;


/*     @OneToMany(cascade = CascadeType.ALL ,mappedBy = "profissional", orphanRemoval = true)
    private Set<Internamentos> internamentos;  */


/*     @OneToMany(cascade = CascadeType.ALL ,mappedBy = "profissional", orphanRemoval = true)
    private Set<Consulta> consultas; */
    
    public Profissional(){}

    public Profissional(String password, Pessoa profissional, Area area, String pro) { 
        this.area = area;
        this.profissional = profissional;
        this.password = password;
        this.pro = pro;
    }

    @Column(name = "id_profissional")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getProfissional() {
        return this.profissional;
    }

    public void setProfissional(Pessoa profissional) {
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
    
}