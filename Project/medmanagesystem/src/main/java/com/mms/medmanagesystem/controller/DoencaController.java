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
import com.mms.medmanagesystem.model.Doenca;
import com.mms.medmanagesystem.service.DoencaService;

@RestController
@RequestMapping("/api/v8")
public class DoencaController {

    @Autowired
    private DoencaService service;
    
     @GetMapping("/doencas")
    public List<Doenca> getAllDoencas() {
        return service.getDoencas();
    }

   
    @GetMapping("/doencas/{id}")
    public Doenca getDoencasBycc(@PathVariable(value="id") int id_doenca) throws ResourceNotFoundException {
        return service.getDoencaByCc(id_doenca); 
    }
        
    
    @PostMapping("/doencas")
    public Doenca createDoenca(@Valid @RequestBody Doenca doenca){
        return service.saveDoenca(doenca);
    }

  
    @PutMapping("/doencas/{id}")
    public Doenca updateDoenca(@PathVariable("id") int id, @Valid @RequestBody Doenca doenca) throws ResourceNotFoundException {
       return service.updateDoenca(id, doenca);
    }


    @DeleteMapping("/doencas/{id}")
    public Map<String, Boolean> deletePeople(@PathVariable int id) throws ResourceNotFoundException {
        return service.deleteDoenca(id);
    }

}
