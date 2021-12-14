package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.models.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

}
