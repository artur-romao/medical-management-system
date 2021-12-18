package com.mms.medmanagesystem.controller;
import java.util.*;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.medmanagesystem.exception.*;
import com.mms.medmanagesystem.model.Paciente;
import com.mms.medmanagesystem.service.PacienteService;

@RestController
@RequestMapping("/api/v5")
public class PacienteController {

    @Autowired
    private PacienteService service;
    
     @GetMapping("/pacientes")
    public List<Paciente> getAllPeople() {
        return service.getPacientes();
    }

   
    @GetMapping("/pacientes/{id}")
    public Paciente getPacienteByCC(@PathVariable(value="id") int paciente_id) throws ResourceNotFoundException {
        Paciente paciente = service.getPacienteById(paciente_id);
        return paciente;

    }
  /*
        throws ResourceNotFoundException {
            Paciente Paciente = service.findById(employeeId)
              .orElseThrow(() -> new ResourceNotFoundException("Nenhuma Paciente encontrada com este nº de CC : " + Paciente_cc));
            return ResponseEntity.ok().body(employee);
        } this is not working :(
     */


    @PostMapping("/pacientes")
    public Paciente createPaciente(@Valid @RequestBody Paciente Paciente){
        return service.savePaciente(Paciente);
    }

  
    @PutMapping("/pacientes/{id}")
    public Paciente updatePaciente(@PathVariable("id") int id, @RequestBody Paciente Paciente) {
        //tentar trabalhar com exceptions
       return service.updatePaciente(id, Paciente);
    }
        /*
         @Valid @RequestBody Paciente PacienteDetails)  {
        Paciente Paciente = service.getPacienteByCc(Paciente_cc);
        //.orElseThrow(() -> new ResourceNotFoundException("Nenhuma Paciente encontrada com este CC " + Paciente_cc)); not working 
        service.updatePaciente(Paciente);*/

    @DeleteMapping("/pacientes/{id}")
    public String deletePatients(@PathVariable int cc) {
        return service.deletePaciente(cc);
    }



}
