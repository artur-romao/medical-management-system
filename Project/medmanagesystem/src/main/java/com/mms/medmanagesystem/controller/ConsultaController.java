package com.mms.medmanagesystem.controller;

import java.util.*;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.medmanagesystem.exception.*;
import com.mms.medmanagesystem.model.Consulta;
import com.mms.medmanagesystem.service.ConsultaService;

@RestController
public class ConsultaController {

    @Autowired
    private ConsultaService service;
    
     @GetMapping("/consultas")
    public List<Consulta> getAllConsultas() {
        return service.getConsultas();
    }

   
    @GetMapping("/consultas/{id}")
    public Consulta getConsultaByID(@PathVariable(value="id") int consulta_id) throws ResourceNotFoundException {
        return service.getConsultaByIDConsulta(consulta_id);

    }
  

    @PostMapping("/consultas")
    public Consulta createConsulta(@Valid @RequestBody Consulta consulta){
        return service.saveConsulta(consulta);
    }

  
    @PutMapping("/consultas/{id}")
    public Consulta updateConsulta(@PathVariable("id") int id, @Valid @RequestBody Consulta consulta) throws ResourceNotFoundException {
        //tentar trabalhar com exceptions
       return service.updateConsulta(id, consulta);
    }

    @DeleteMapping("/consultas/{id}")
    public Map<String, Boolean> deleteConsultaByid(@PathVariable int id) throws ResourceNotFoundException {
        return service.deleteConsulta(id);
    }



}
