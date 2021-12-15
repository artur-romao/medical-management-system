package com.mms.medmanagesystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "cc_medico", referencedColumnName = "cc_pessoa") //referenccedColumName é o que vem de pessoa
    private Pessoa pessoa;
    
    private int cc;
    private int area;
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_area")
    private Area area_bd;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "id_paciente", orphanRemoval = true)
    private Set<Paciente> pacientes;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "id_consulta", orphanRemoval = true)
    private Set<Consulta> consultas;
    
    

    public Medico(int id, int cc, int area, String password) {
        this.id = id;
        this.cc = cc;
        this.area = area;
        this.password = password;
    }

    @Column(name = "id_medico")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "cc")
    public int getCc() {
        return this.cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    @Column(name = "area")
    public int getArea() {
        return this.area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Column(name = "password")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}