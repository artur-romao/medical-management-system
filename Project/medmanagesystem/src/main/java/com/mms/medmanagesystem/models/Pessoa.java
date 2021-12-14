package com.mms.medmanagesystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pessoa")
public class Pessoa {
    
    private int cc;
    private String nome;
    private int telemovel;
    private String morada;
    private String datanascimento;

}