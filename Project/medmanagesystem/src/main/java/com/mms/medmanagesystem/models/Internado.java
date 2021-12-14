package com.mms.medmanagesystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Internado")
public class Internado {
    private int idPaciente;
    private int pulso;
    private int area;
    private double pressaoArterial;
    private double temperatura;
    private double frequenciaRespiratoria;
    private String razaoInternamento;
    private int quarto;
    private int cama;
    private String doenca;
    private String estado;
    private String dataAdmissao;
    private String dataSaida;


    
}
