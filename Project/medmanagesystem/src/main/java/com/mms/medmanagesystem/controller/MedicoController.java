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
import com.mms.medmanagesystem.model.Medico;
import com.mms.medmanagesystem.service.MedicoService;

@RestController
@RequestMapping("/api/med")
public class MedicoController {

    @Autowired
    private MedicoService service;
    
     @GetMapping("/medico")
    public List<Medico> getAllMedicos() {
        return service.getMedicos();
    }

   
    @GetMapping("/medico/{id}")
    public Medico getMedicoId(@PathVariable(value="id") int medico_id) throws ResourceNotFoundException {
        Medico Medico = service.getMedicoByIDMedico(medico_id);
        return Medico;

    }

    @PostMapping("/medico")
    public Medico createMedico(@Valid @RequestBody Medico med){
        return service.saveMedico(med);
    }

  
    @PutMapping("/medico/{id}")
    public Medico updateMedico(@PathVariable("id") int id, @RequestBody Medico medico) throws ResourceNotFoundException {
       return service.updateMedico(id, medico);
    }

    @DeleteMapping("/medico/{id}")
    public Map<String, Boolean> deletePatients(@PathVariable int id) throws ResourceNotFoundException {
        return service.deleteMedico(id);
    }



}
