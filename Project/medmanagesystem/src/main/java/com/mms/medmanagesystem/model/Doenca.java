/*package com.mms.medmanagesystem.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Data
@Entity
@Table(name = "doenca")
public class Doenca {

    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private String descricao;

	// @OneToMany(cascade = CascadeType.ALL ,mappedBy = "doenca", orphanRemoval = true)
    // private Set<Pac_doenca> doencas;

	@ManyToMany(mappedBy = "doencas")
    private Set<Paciente> pacientes = new HashSet<>();

	public Doenca() {}

    public Doenca(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;     
    }


    @Column(name = "id_doenca")
	public int getid() {
		return this.id;
	}

	public void setid(int id) {
		this.id = id;
	}

    @Column(name = "name")
	public String getName() {
		return this.nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

    @Column(name = "descricao")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Set<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
    
}
*/