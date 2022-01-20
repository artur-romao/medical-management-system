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

    private  Float[] pressaoArterial;
    private float temperatura;
	private float oxigenio;
    private String razaoInternamento;
    private String quarto_cama;
    private String estado;
    private Date dataAdmissao;
    private Date dataSaida;


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
    public InternamentoTeste(int id, Paciente paciente, Profissional profissional, float oxigenio, PairModel pulso, Float[] pressaoArterial, float temperatura, String razaoInternamento, String quarto_cama, String estado, Date dataAdmissao, Date dataSaida) { 
        this.id = id;
		this.profissional = profissional;
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

	public Profissional getPessoa(){
		return this.profissional;
	}

	public void setPessoa(Profissional profissional){
		this.profissional = profissional;
	}

	public int getIdInternamento() {
		return this.id;

	}

	public void setidInternamento(int idInternamento) {
		this.id = idInternamento;
	}


	public Paciente getPessoa() {
		return this.paciente;
	}

	public void setPessoa(Paciente paciente) {
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

    @Column(name = "pressaoArterial")
	public Float[] getPressaoArterial() {
		return this.pressaoArterial;
	}

	public void setPressaoArterial(Float[] pressaoArterial) {
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
	public String getRazaoInternamento() {
		return this.razaoInternamento;
	}

	public void setRazaoInternamento(String razaoInternamento) {
		this.razaoInternamento = razaoInternamento;
	}

    @Column(name = "quarto_cama")
	public String getQuarto_cama() {
		return this.quarto_cama;
	}

	public void setQuarto_cama(String quarto_cama) {
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
    public Date getDataAdmissao() {
		return this.dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

    
    @Column(name = "dataSaida")
	public Date getDataSaida() {
		return this.dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
    
}

 */