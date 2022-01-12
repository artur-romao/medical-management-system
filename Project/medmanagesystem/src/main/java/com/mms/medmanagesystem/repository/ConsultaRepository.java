package com.mms.medmanagesystem.repository;
import com.mms.medmanagesystem.model.Consulta;
import com.mms.medmanagesystem.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ConsultaRepository extends JpaRepository<Consulta,Integer> {
    Consulta findByPaciente(Paciente paciente);
}
