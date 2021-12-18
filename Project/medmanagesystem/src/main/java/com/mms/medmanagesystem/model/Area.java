package com.mms.medmanagesystem.model;

import lombok.Data;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Area")
public class Area {

    @Id
    @GeneratedValue
    private int idArea;
    private String name; 
     
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "medico_cc", orphanRemoval = true)
    private Set<Medico> medicos;
    

    public Area(int idArea, String name) {
        this.idArea = idArea;
        this.name = name;   
    }

    @Column (name = "id_area")
    public int getIdArea() {
		return this.idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

    @Column (name = "Name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}