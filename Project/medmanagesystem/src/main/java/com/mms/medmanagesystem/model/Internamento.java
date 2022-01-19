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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mms.medmanagesystem.enumFolder.EstadoEnum;


// @Data
@Entity
@Table(name = "internamento")
public class Internamento {
    
	@Id
	@Column(name = "id_internamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private Double[] pulso;
    private  Float[] pressaoarterial;
    private float temperatura;
	private float oxigenio;
    private String razaointernamento;
    private String quartocama;
    private String estado;
    private Date dataadmissao;
    private Date datasaida;
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

    @Column(name = "pressaoarterial")
	public Float[] getPressaoarterial() {
		return this.pressaoarterial;
	}

	public void setPressaoarterial(Float[] pressaoarterial) {
		this.pressaoarterial = pressaoarterial;
	}

    @Column(name = "temperatura")
	public float getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
    
    
    @Column(name = "razaointernamento")
	public String getRazaointernamento() {
		return this.razaointernamento;
	}

	public void setRazaointernamento(String razaointernamento) {
		this.razaointernamento = razaointernamento;
	}

    @Column(name = "quartocama")
	public String getQuartocama() {
		return this.quartocama;
	}

	public void setQuartocama(String quartocama) {
		this.quartocama = quartocama;
	}

    @Column(name = "estado")
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


    @Column(name = "dataadmissao")
    public Date getDataadmissao() {
		return this.dataadmissao;
	}

	public void setDataadmissao(Date dataadmissao) {
		this.dataadmissao = dataadmissao;
	}

    
    @Column(name = "datasaida")
	public Date getDatasaida() {
		return this.datasaida;
	}

	public void setDatasaida(Date datasaida) {
		this.datasaida = datasaida;
	}
	@Column(name= "statefilter")
	public int [] statefilter(){
		return this.statefilter;
	}
    public int[] getStatefilter() {
		return statefilter;
	}
	public void setStatefilter(int[] statefilter) {
		this.statefilter = statefilter;
	}
}
