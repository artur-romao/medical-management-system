package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

}
