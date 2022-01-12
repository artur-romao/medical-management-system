package com.mms.medmanagesystem.model;

//import lombok.Data;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Data
@Entity
@Table(name = "area")
public class Area {

    @Id
    @Column (name = "id_area")
    private int id;

    @Column (name = "name")
    private String name; 
                                                //o maped by é com as cenas do java
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "area")
    private Set<Medico> medicos;
    

    public Area () {}
    
    public Area(int id, String name) {
        this.id = id;
        this.name = name;   
    }

    public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}