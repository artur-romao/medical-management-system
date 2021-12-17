package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.models.Internamentos;
import com.mms.medmanagesystem.models.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InternamentosRepository extends JpaRepository<Internamentos,Integer> {

    Internamentos findByPaciente(Paciente paciente);
}
