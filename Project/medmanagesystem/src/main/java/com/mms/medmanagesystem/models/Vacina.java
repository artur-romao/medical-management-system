package com.mms.medmanagesystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Vacina")
public class Vacina {

    @Id
    @GeneratedValue
    private int idVacina;
    private String name;
    private String patologia;

    
}