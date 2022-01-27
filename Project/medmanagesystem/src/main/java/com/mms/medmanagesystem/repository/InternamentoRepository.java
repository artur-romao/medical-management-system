package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface InternamentoRepository extends JpaRepository<Internamento,Integer> {


    Internamento findByPaciente(Paciente paciente);

    @Query(value="SELECT id_internamento FROM internamento inte INNER JOIN paciente pa ON inte.id_paciente = pa.id_paciente WHERE pa.id_paciente = :id" , nativeQuery = true)
    int getInternamentoByIdPaciente(@Param("id") int id);
}


