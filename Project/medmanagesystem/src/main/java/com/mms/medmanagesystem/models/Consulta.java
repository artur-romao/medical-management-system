package com.mms.medmanagesystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue
    private int id;             
    private int idPaciente;
    private int idMedico;
    private String motivo;
    private String data;
    private String anotacoes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    

    public Consulta(int id, int idPaciente, int idMedico, String motivo, String data, String anotacoes) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
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

    @Column(name = "idpac")
	public int getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

    @Column(name = "idmed")
	public int getIdMedico() {
		return this.idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
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