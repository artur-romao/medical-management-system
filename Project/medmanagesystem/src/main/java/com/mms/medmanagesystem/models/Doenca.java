package com.mms.medmanagesystem.models;

import lombok.Data;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Entity
@Table(name = "doenca")
public class Doenca {

    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private String descricao;

	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "doenca", orphanRemoval = true)
    private Set<Pac_doenca> doencas;

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

    @Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    @Column(name = "descricao")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Pac_doenca> getDoencas() {
		return this.doencas;
	}

	public void setDoencas(Set<Pac_doenca> doencas) {
		this.doencas = doencas;
	}

    
}