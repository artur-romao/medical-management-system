package com.mms.medmanagesystem.model;

//import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;


@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private int id;   
	
	@Column(name = "motivo")
    private String motivo;

    @Column(name = "dataconsulta")
    private Date data;

    @Column(name = "anotacoes")
    private String anotacoes;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_profissional", nullable = false)
    private Profissional profissional;

    
	public Consulta() {}

    public Consulta(Paciente paciente, Profissional profissional, String motivo, Date data, String anotacoes) {
        this.paciente = paciente;
        this.profissional = profissional;
        this.motivo = motivo;
        this.data = data;
        this.anotacoes = anotacoes;
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Profissional getProfissional() {
		return this.profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getAnotacoes() {
		return this.anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}


	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", motivo='" + getMotivo() + "'" +
			", data='" + getData() + "'" +
			", anotacoes='" + getAnotacoes() + "'" + 
			"}";
	}
    
}

