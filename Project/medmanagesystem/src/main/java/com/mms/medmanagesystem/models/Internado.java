package com.mms.medmanagesystem.models;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "internamentos")
public class Internado {
    @Id
	@GeneratedValue
	private int id;
    private double pulso;
    private double pressaoArterial;
    private double temperatura;
    private String razaoInternamento;
    private int quarto;
    private int cama;
    private String doenca;
    private String estado;
    private String dataAdmissao;
    private String dataSaida;
	private double oxigenio;

	


	

    
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;



    public Internado(int id,Paciente paciente, double oxigenio, double pulso, double pressaoArterial, double temperatura, double freqRespiratoria, String razaoInternamento, int quarto, int cama, String doenca, String estado, String dataAdmissao, String dataSaida) {
        this.id = id;
		this.paciente = paciente;
        this.pulso = pulso;
		this.oxigenio = oxigenio;
        this.pressaoArterial = pressaoArterial;
        this.temperatura = temperatura;
        this.razaoInternamento = razaoInternamento;
        this.quarto = quarto;
        this.cama = cama;
        this.doenca = doenca;
        this.estado = estado;
        this.dataAdmissao = dataAdmissao;
        this.dataSaida = dataSaida;
    }

	public int getIdInternamento() {
		return this.id;

	}

	public void setidInternamento(int idInternamento) {
		this.id = idInternamento;
	}
	public Paciente getIdPaciente() {
		return this.paciente;
	}

	public void setIdPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

    @Column(name = "Pulso")
	public double getPulso() {
		return this.pulso;
	}

	@Column(name = "Oxigenio")
	public double getOxigenio() {
		return this.oxigenio;
	}
	public void setOxigenio(double oxigenio) {
		this.oxigenio = oxigenio;
	}

	public void setPulso(double pulso) {
		this.pulso = pulso;
	}

    @Column(name = "PressaoArterial")
	public double getPressaoArterial() {
		return this.pressaoArterial;
	}

	public void setPressaoArterial(double pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}

    @Column(name = "Temperatura")
	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
    
    
    @Column(name = "RazaoInternamento")
	public String getRazaoInternamento() {
		return this.razaoInternamento;
	}

	public void setRazaoInternamento(String razaoInternamento) {
		this.razaoInternamento = razaoInternamento;
	}

    @Column(name = "Quarto")
	public int getQuarto() {
		return this.quarto;
	}

	public void setQuarto(int quarto) {
		this.quarto = quarto;
	}

    @Column(name = "Cama")
	public int getCama() {
		return this.cama;
	}

	public void setCama(int cama) {
		this.cama = cama;
	}

    @Column(name = "Doenca")
	public String getDoenca() {
		return this.doenca;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}

    @Column(name = "Estado")
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
