package com.mms.medmanagesystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Doenca")
public class Doenca {

    @Id
    @GeneratedValue
    private int idDoenca;
    private String nome;
    private String descricao;

    
}