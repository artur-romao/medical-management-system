package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.model.Area;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AreaRepository extends JpaRepository<Area,Integer>{
    Area findByName(String name);    
}
