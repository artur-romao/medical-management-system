package com.mms.medmanagesystem.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue
    private int id;             
    private String motivo;
    private String data;
    private String anotacoes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    

    public Consulta(int id, Paciente paciente, Medico medico, String motivo, String data, String anotacoes) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.motivo = motivo;
        this.data = data;
        this.anotacoes = anotacoes;
    }

    @Column(name = "id_consulta")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paciente getIdPaciente() {
		return this.paciente;
	}

	public void setIdPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getIdMedico() {
		return this.medico;
	}

	public void setIdMedico(Medico medico) {
		this.medico = medico;
	}

    @Column(name = "motivo")
	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

    @Column(name = "dataconsulta")
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

    @Column(name = "anotacoes")
	public String getAnotacoes() {
		return this.anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

    
}