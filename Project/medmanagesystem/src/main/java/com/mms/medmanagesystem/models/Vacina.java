package com.mms.medmanagesystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Vacina")
public class Vacina {

    @Id
    @GeneratedValue
    private int idVacina;

    private String nome;
    private String patologia;


	//public Vacina () {}

    public Vacina(int idVacina, String nome, String patologia) {
        this.idVacina = idVacina;
        this.nome = nome;
        this.patologia = patologia;
    }

	@ManyToOne(optional = false)
    @JoinColumn(name = "idvac")
    private Pac_vac paciente_vacinas;

    

    @Column(name = "id_vacina")
    public int getIdVacina() {
		return this.idVacina;
	}

	public void setIdVacina(int idVacina) {
		this.idVacina = idVacina;
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