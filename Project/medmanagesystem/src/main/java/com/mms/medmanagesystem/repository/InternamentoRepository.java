package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InternamentoRepository extends JpaRepository<Internamento,Integer> {
    Internamento findByPaciente(Paciente paciente);
}
 