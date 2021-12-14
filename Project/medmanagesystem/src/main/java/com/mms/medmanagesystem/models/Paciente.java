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
@Table(name = "Paciente")
public class Paciente {

    @Id
    @GeneratedValue
    private int id;
    private int cc;
    private int assMedico;
    private int internado;

    
}