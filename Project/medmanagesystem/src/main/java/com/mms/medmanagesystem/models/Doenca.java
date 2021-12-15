package com.mms.medmanagesystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doenca")
public class Doenca {

    @Id
    @GeneratedValue
    private int idDoenca;
    private String nome;
    private String descricao;

	
    public Doenca(int idDoenca, String nome, String descricao) {
        this.idDoenca = idDoenca;
        this.nome = nome;
        this.descricao = descricao;     
    }


    @Column(name = "id")
	public int getIdDoenca() {
		return this.idDoenca;
	}

	public void setIdDoenca(int idDoenca) {
		this.idDoenca = idDoenca;
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


    
}