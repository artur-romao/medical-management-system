package com.mms.medmanagesystem.model;

// import lombok.Data;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

// @Data
@Entity
@Table(name = "internamentos")
public class Internamentos {
    @Id
	@Column(name = "id_internamento")
	@GeneratedValue
	private int id;
	
    private double pulso;
    private double pressaoArterial;
    private double temperatura;
	private double oxigenio;
    private String razaoInternamento;
    private String quarto_cama;
    private String estado;
    private String dataAdmissao;
    private String dataSaida;
    
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

	@ManyToOne(optional = false)
	@JoinColumn(name="id_medico")
	private Medico medico;


	public Internamentos() {}

    public Internamentos(int id, Paciente paciente, Medico medico, double oxigenio, double pulso, double pressaoArterial, double temperatura, String razaoInternamento, String quarto_cama, String estado, String dataAdmissao, String dataSaida) { 
        this.id = id;
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

	public void setidInternamento(int idInternamento) {
		this.id = idInternamento;
	}


	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

    @Column(name = "pulso")
	public double getPulso() {
		return this.pulso;
	}

	@Column(name = "oxigenio")
	public double getOxigenio() {
		return this.oxigenio;
	}

	public void setOxigenio(double oxigenio) {
		this.oxigenio = oxigenio;
	}

	public void setPulso(double pulso) {
		this.pulso = pulso;
	}

    @Column(name = "pressaoArterial")
	public double getPressaoArterial() {
		return this.pressaoArterial;
	}

	public void setPressaoArterial(double pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}

    @Column(name = "temperatura")
	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
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
    public String getDataAdmissao() {
		return this.dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

    
    @Column(name = "dataSaida")
	public String getDataSaida() {
		return this.dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
    
}
