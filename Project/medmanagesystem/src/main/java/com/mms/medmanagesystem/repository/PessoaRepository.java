package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.model.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {

    Pessoa findByName(String name);

}
