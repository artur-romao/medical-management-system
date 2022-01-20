package com.mms.medmanagesystem.repository;

import java.util.List;

import com.mms.medmanagesystem.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

    @Query(value="SELECT * FROM paciente pa INNER JOIN pessoa pe ON pe.pessoacc = pa.paciente_cc WHERE pe.name like %:keyword%" , nativeQuery = true)
    List <Paciente> findKeyword(@Param("keyword") String keyword);

    @Query(value="SELECT * FROM paciente pe WHERE pe.paciente_cc == :cc" , nativeQuery = true)
    Paciente findCc(@Param("cc") int cc);

}
