/*package com.mms.medmanagesystem.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "vacina")
public class Vacina {

    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private String patologia;

	// @OneToMany(cascade = CascadeType.ALL ,mappedBy = "vacina", orphanRemoval = true)
    // private Set<Pac_vac> vacinas;

	@ManyToMany(mappedBy = "vacinas")
    private Set<Paciente> pacientes = new HashSet<>();


	public Vacina () {}

    public Vacina(int id, String nome, String patologia) {
        this.id = id;
        this.nome = nome;
        this.patologia = patologia;
    }
    
    @Column(name = "id_vacina")
    public int getIdVacina() {
		return this.id;
	}

	public void setIdVacina(int id) {
		this.id = id;
	}

    @Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    @Column(name = "patologia")
	public String getPatologia() {
		return this.patologia;
	}

	public void setPatologia(String patologia) {
		this.patologia = patologia;
	}

	public Set<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}


}

*/