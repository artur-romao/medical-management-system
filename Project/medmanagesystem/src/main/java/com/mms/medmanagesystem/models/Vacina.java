package com.mms.medmanagesystem.models;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Vacina")
public class Vacina {

    @Id
    @GeneratedValue
    private int idVacina;

    private String nome;
    private String patologia;


	//public Vacina () {}

	@ManyToOne(optional = false)
    @JoinColumn(name = "idvac")
    private Pac_vac paciente_vacinas;

    public Vacina(Pac_vac paciente_vacinas, String nome, String patologia) {
        this.paciente_vacinas = paciente_vacinas;
        this.nome = nome;
        this.patologia = patologia;
    }
    

    public Pac_vac getIdVacina() {
		return this.paciente_vacinas;
	}

	public void setIdVacina(Pac_vac paciente_vacinas) {
		this.paciente_vacinas = paciente_vacinas;
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
}