package com.mms.medmanagesystem.model;

// import lombok.Data;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


// @Data
@Entity
@Table(name = "internamento")
public class Internamento {
    
	@Id
	@Column(name = "id_internamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private Double[] pulso;
    private  Float[] pressaoArterial;
    private float temperatura;
	private float oxigenio;
    private String razaoInternamento;
    private String quarto_cama;
    private String estado;
    private Date dataAdmissao;
    private Date dataSaida;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

	@ManyToOne(optional = false)
	@JoinColumn(name="id_medico")
	private Medico medico;


	public Internamento(Paciente paciente2, Medico medico2, float f, double[] ds, Float[] floats, float g, String string, String string2, String string3, Date date, Date date2) {}

	// pressao arterial (13,2) 
	// pulso ((2,3),(1,2))
    public Internamento(Paciente paciente, Medico medico, float oxigenio, Double[] pulso, Float[] pressaoArterial, float temperatura, String razaoInternamento, String quarto_cama, String estado, Date dataAdmissao, Date dataSaida) { 
		this.medico = medico;
		this.paciente = paciente;
        this.pulso = pulso;
		this.oxigenio = oxigenio;
        this.pressaoArterial = pressaoArterial;
        this.temperatura = temperatura;
        this.razaoInternamento = razaoInternamento;
        this.quarto_cama = quarto_cama;
        this.estado = estado;
        this.dataAdmissao = dataAdmissao;
        this.dataSaida = dataSaida;
    }


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Medico getMedico(){
		return this.medico;
	}

	public void setMedico(Medico medico){
		this.medico = medico;
	}

	public int getIdInternamento() {
		return this.id;

	}

	public void setIdinternamento(int idInternamento) {
		this.id = idInternamento;
	}


	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Column(name = "pulso")
	public Double[] getPulso() {
		return this.pulso;
	}

	@Column(name = "oxigenio")
	public float getOxigenio() {
		return this.oxigenio;
	}

	public void setOxigenio(float oxigenio) {
		this.oxigenio = oxigenio;
	}

	public void setPulso(Double[] pulso) {
		this.pulso = pulso;
	} 

    @Column(name = "pressaoArterial")
	public Float[] getPressaoarterial() {
		return this.pressaoArterial;
	}

	public void setPressaoarterial(Float[] pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}

    @Column(name = "temperatura")
	public float getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
    
    
    @Column(name = "razaoInternamento")
	public String getRazaointernamento() {
		return this.razaoInternamento;
	}

	public void setRazaointernamento(String razaoInternamento) {
		this.razaoInternamento = razaoInternamento;
	}

    @Column(name = "quarto_cama")
	public String getQuartocama() {
		return this.quarto_cama;
	}

	public void setQuartocama(String quarto_cama) {
		this.quarto_cama = quarto_cama;
	}

    @Column(name = "estado")
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


    @Column(name = "dataAdmissao")
    public Date getDataadmissao() {
		return this.dataAdmissao;
	}

	public void setDataadmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

    
    @Column(name = "dataSaida")
	public Date getDatasaida() {
		return this.dataSaida;
	}

	public void setDatasaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
    
}
