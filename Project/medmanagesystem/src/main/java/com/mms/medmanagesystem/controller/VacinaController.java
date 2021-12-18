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
import com.mms.medmanagesystem.model.Vacina;
import com.mms.medmanagesystem.service.VacinaService;

@RestController
@RequestMapping("/api/v7")
public class VacinaController {

    @Autowired
    private VacinaService service;
    
     @GetMapping("/vacinas")
    public List<Vacina> getAllVacinas() {
        return service.getVacinas();
    }

   
    @GetMapping("/vacinas/{id}")
    public Vacina getVacinaByid(@PathVariable(value="id") int vacina_id) {
        Vacina vacina = service.getVacinaByIDvacina(vacina_id);
            /*
            throws ResourceNotFoundException {
                Vacina Vacina = service.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhuma Vacina encontrada com este nº de CC : " + Vacina_cc));
                return ResponseEntity.ok().body(employee);
            } this is not working :(
        */
        return vacina; 
    }
        
    
    @PostMapping("/vacinas")
    public Vacina createVacina(@Valid @RequestBody Vacina vacina){
        return service.saveVacina(vacina);
    }

  
    @PutMapping("/vacinas/{id}")
    public Vacina updateVacina(@PathVariable("id") int id,  @RequestBody Vacina vacina) {
        //tentar trabalhar com exceptions
       return service.updateVacina(id, vacina);
    }
        /*
         @Valid @RequestBody Vacina VacinaDetails)  {
        Vacina Vacina = service.getVacinaByCc(Vacina_cc);
        //.orElseThrow(() -> new ResourceNotFoundException("Nenhuma Vacina encontrada com este CC " + Vacina_cc)); not working 
        service.updateVacina(Vacina);*/

    @DeleteMapping("/vacinas/{id}")
    public String deletePeople(@PathVariable int id) {
        return service.deleteVacina(id);
    }



}
