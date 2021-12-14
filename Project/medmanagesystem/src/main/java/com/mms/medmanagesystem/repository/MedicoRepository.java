package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.models.Medico;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicoRepository extends JpaRepository<Medico,Integer> {
}
