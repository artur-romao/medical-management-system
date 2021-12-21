package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.model.Doenca;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DoencaRepository extends JpaRepository<Doenca,Integer> {

	Doenca findByNome(String name);

}
