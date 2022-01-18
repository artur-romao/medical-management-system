/* package com.mms.medmanagesystem.model;

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
import javax.persistence.Table;


// @Data
@Entity
@Table(name = "internamento")
public class InternamentoTeste {
    @Id
	@Column(name = "id_internamento")
	@GeneratedValue
	private int id;

	@Column(name = "pulso")
    private PairModel pulso;

    private  Float[] pressaoarterial;
    private float temperatura;
	private float oxigenio;
    private String razaointernamento;
    private String quartocama;
    private String estado;
    private Date dataadmissao;
    private Date datasaida;


	private double[] timedata;
	private double[] heartratedata;
	private double[]double[] pulsso;


    
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

	@ManyToOne(optional = false)
	@JoinColumn(name="id_profissional")
	private Profissional profissional;


	public InternamentoTeste() {}

	// pressao arterial (13,2) 
	// pulso ((2,3),(1,2))
    public InternamentoTeste(int id, Paciente paciente, Profissional profissional, float oxigenio, PairModel pulso, Float[] pressaoarterial, float temperatura, String razaointernamento, String quartocama, String estado, Date dataadmissao, Date datasaida) { 
        this.id = id;
		this.profissional = profissional;
		this.paciente = paciente;
        this.pulso = pulso;
		this.oxigenio = oxigenio;
        this.pressaoarterial = pressaoarterial;
        this.temperatura = temperatura;
        this.razaointernamento = razaointernamento;
        this.quartocama = quartocama;
        this.estado = estado;
        this.dataadmissao = dataadmissao;
        this.datasaida = datasaida;
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

	public void setidInternamento(int idInternamento) {
		this.id = idInternamento;
	}


	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public PairModel getPulso() {
		return this.pulso;
	}

	@Column(name = "oxigenio")
	public float getOxigenio() {
		return this.oxigenio;
	}

	public void setOxigenio(float oxigenio) {
		this.oxigenio = oxigenio;
	}

	public void setPulso(PairModel pulso) {
		this.pulso = pulso;
	}

    @Column(name = "pressaoarterial")
	public Float[] getpressaoarterial() {
		return this.pressaoarterial;
	}

	public void setpressaoarterial(Float[] pressaoarterial) {
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
	public String getrazaointernamento() {
		return this.razaointernamento;
	}

	public void setrazaointernamento(String razaointernamento) {
		this.razaointernamento = razaointernamento;
	}

    @Column(name = "quartocama")
	public String getquartocama() {
		return this.quartocama;
	}

	public void setquartocama(String quartocama) {
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
    public Date getdataadmissao() {
		return this.dataadmissao;
	}

	public void setdataadmissao(Date dataadmissao) {
		this.dataadmissao = dataadmissao;
	}

    
    @Column(name = "datasaida")
	public Date getdatasaida() {
		return this.datasaida;
	}

	public void setdatasaida(Date datasaida) {
		this.datasaida = datasaida;
	}
    
}

 */