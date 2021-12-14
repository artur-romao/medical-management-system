package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.models.Pac_vac;
import com.mms.medmanagesystem.models.Paciente;
import com.mms.medmanagesystem.models.Vacina;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Pac_vacRepository extends JpaRepository<Pac_vac,Integer> {
    public Pac_vac findPatient(Paciente p, Vacina v);

}
