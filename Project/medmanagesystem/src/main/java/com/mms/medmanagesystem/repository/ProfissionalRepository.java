package com.mms.medmanagesystem.repository;

import java.util.List;

import com.mms.medmanagesystem.model.Profissional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProfissionalRepository extends JpaRepository<Profissional,Integer> {

    @Query(value="SELECT * FROM profissional pr INNER JOIN pessoa pe ON pe.pessoacc = pr.profissional_cc WHERE pe.name like %:keyword%" , nativeQuery = true)
    List <Profissional> findKeyword(@Param("keyword") String keyword);
}
