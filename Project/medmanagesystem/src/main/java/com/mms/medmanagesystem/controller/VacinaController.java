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
import com.mms.medmanagesystem.model.Vacina;
import com.mms.medmanagesystem.service.VacinaService;

@RestController
@RequestMapping("/api/vac")
public class VacinaController {

    @Autowired
    private VacinaService service;
    
     @GetMapping("/vacinas")
    public List<Vacina> getAllVacinas() {
        return service.getVacinas();
    }

   
    @GetMapping("/vacinas/{id}")
    public Vacina getVacinaByid(@PathVariable(value="id") int id_vacina) throws ResourceNotFoundException {
        return service.getVacinaByIDvacina(id_vacina);
    }
        
    
    @PostMapping("/vacinas")
    public Vacina createVacina(@Valid @RequestBody Vacina vacina){
        return service.saveVacina(vacina);
    }

  
    @PutMapping("/vacinas/{id}")
    public Vacina updateVacina(@PathVariable("id") int id,  @RequestBody Vacina vacina) throws ResourceNotFoundException {
       return service.updateVacina(id, vacina);
    }

    @DeleteMapping("/vacinas/{id}")
    public Map<String, Boolean> deletePeople(@PathVariable int id) throws ResourceNotFoundException {
        return service.deleteVacina(id);
    }



}
