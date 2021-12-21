package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.model.Internamentos;
import com.mms.medmanagesystem.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InternamentosRepository extends JpaRepository<Internamentos,Integer> {

    Internamentos findByPaciente(Paciente paciente);
}
