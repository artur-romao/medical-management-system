package com.mms.medmanagesystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Consulta")
public class Consulta {

    @Id
    @GeneratedValue
    private int id;             
    private int idPaciente;
    private int idMedico;
    private String motivo;
    private String data;
    private String anotacoes;
    
}