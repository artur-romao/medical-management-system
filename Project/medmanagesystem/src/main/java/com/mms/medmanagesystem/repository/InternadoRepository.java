package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.models.Internado;
import com.mms.medmanagesystem.models.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InternadoRepository extends JpaRepository<Internado,Integer> {

    Internado findByPaciente(Paciente paciente);
}
