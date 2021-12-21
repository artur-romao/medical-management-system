package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.model.Medico;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicoRepository extends JpaRepository<Medico,Integer> {
}
