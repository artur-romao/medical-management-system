package com.mms.medmanagesystem.model;

// import lombok.Data;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;


// @Data
@Entity
@Table(name = "internamento")
public class Internamento {
    
	@Id
	@Column(name = "id_internamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "pulso")
    private Double[] pulso;

	@Column(name = "pressaoarterial")
    private  Float[] pressaoarterial;
    
	@Column(name = "temperatura")
	private float temperatura;

	@Column(name = "oxigenio")
	private float oxigenio;
    
	@Column(name = "razaointernamento")
	private String razaointernamento;
    
	@Column(name = "quartocama")
	private String quartocama;
    
	@Column(name = "estado")
	private String estado;
  
	@DateTimeFormat
	@Column(name = "dataadmissao")
    private Date dataadmissao;

	@Column(name = "datasaida")
    private Date datasaida;

	@Column(name= "statefilter")
	private int[] statefilter;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paciente")
	@JsonBackReference
    private Paciente paciente;

	@ManyToOne(optional = false)
	@JoinColumn(name="id_profissional")
	@JsonBackReference

	private Profissional profissional;

	public Internamento(){}
  
  public Internamento(Paciente paciente, Profissional profissional, float oxigenio, Double[] pulso, Float[] pressaoarterial, float temperatura, String razaointernamento, String quartocama, String estado, Date dataadmissao, Date datasaida, int[] statefilter) { 
	this.profissional = profissional;
	this.paciente = paciente;
	this.pulso = pulso;
	this.oxigenio = oxigenio;
	this.pressaoarterial = pressaoarterial;
	this.temperatura = temperatura;
	this.razaointernamento = razaointernamento;
	this.estado = estado;
	this.quartocama = quartocama;
	this.dataadmissao = dataadmissao;
	this.datasaida = datasaida;
	this.statefilter=statefilter;
  }


	public Internamento(Paciente paciente, Profissional profissional, String razaointernamento, String quartocama, String estado, Date dataadmissao, Date datasaida) {
		this.profissional = profissional;
		this.paciente = paciente;
		this.razaointernamento = razaointernamento;
        this.quartocama = quartocama;
        this.estado = estado;
        this.dataadmissao = dataadmissao;
        this.datasaida = datasaida;
	}

    public Internamento(Paciente paciente, Profissional profissional) {
		this.profissional = profissional;
		this.paciente = paciente;
    }
	

    public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profissional getProfissional(){
		return this.profissional;
	}

	public void setProfissional(Profissional profissional){
		this.profissional = profissional;
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

	public Double[] getPulso() {
		return this.pulso;
	}

	public float getOxigenio() {
		return this.oxigenio;
	}

	public void setOxigenio(float oxigenio) {
		this.oxigenio = oxigenio;
	}

	public void setPulso(Double[] pulso) {
		this.pulso = pulso;
	} 

	public Float[] getPressaoarterial() {
		return this.pressaoarterial;
	}

	public void setPressaoarterial(Float[] pressaoarterial) {
		this.pressaoarterial = pressaoarterial;
	}

	public float getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
    
    
	public String getRazaointernamento() {
		return this.razaointernamento;
	}

	public void setRazaointernamento(String razaointernamento) {
		this.razaointernamento = razaointernamento;
	}

	public String getQuartocama() {
		return this.quartocama;
	}

	public void setQuartocama(String quartocama) {
		this.quartocama = quartocama;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

    public Date getDataadmissao() {
		return this.dataadmissao;
	}

	public void setDataadmissao(Date dataadmissao) {
		this.dataadmissao = dataadmissao;
	}

    	public Date getDatasaida() {
		return this.datasaida;
	}

	public void setDatasaida(Date datasaida) {
		this.datasaida = datasaida;
	}

	public int [] statefilter(){
		return this.statefilter;
	}

    public int[] getStatefilter() {
		return statefilter;
	}

	public void setStatefilter(int[] statefilter) {
		this.statefilter = statefilter;
	}

	// @Column(name = "paciente_cc")
	// public int getPacientecc(){
	// 	return this.paciente_cc
	// }


	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", pulso='" + getPulso() + "'" +
			", pressaoarterial='" + getPressaoarterial() + "'" +
			", temperatura='" + getTemperatura() + "'" +
			", oxigenio='" + getOxigenio() + "'" +
			", razaointernamento='" + getRazaointernamento() + "'" +
			", quartocama='" + getQuartocama() + "'" +
			", estado='" + getEstado() + "'" +
			", dataadmissao='" + getDataadmissao() + "'" +
			", datasaida='" + getDatasaida() + "'" +
			", statefilter='" + getStatefilter() + "'" +
			"}";
	}


}
