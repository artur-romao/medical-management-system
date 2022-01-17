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
import com.mms.medmanagesystem.model.Profissional;
import com.mms.medmanagesystem.service.ProfissionalService;

@RestController
public class ProfissionalController {

    @Autowired
    private ProfissionalService service;
    
     @GetMapping("/profissional")
    public List<Profissional> getAllProfissionais() {
        return service.getProfissionais();
    }

   
/*     @GetMapping("/profissional/{id}")
    public Profissional getProfissionalId(@PathVariable(value="id") int profissional_id) throws ResourceNotFoundException {
        Profissional profissional = service.getProfissionalByID(profissional_id);
        return Profissional;
    } */

    @PostMapping("/profissional")
    public Profissional createProfissional(@Valid @RequestBody Profissional pro){
        return service.saveProfissional(pro);
    }

  
    @PutMapping("/profissional/{id}")
    public Profissional updateProfissional(@PathVariable("id") int id, @RequestBody Profissional pro) throws ResourceNotFoundException {
       return service.updateProfissional(id, pro);
    }

    
    @DeleteMapping("/profissional/{id}")
    public Map<String, Boolean> deleteProfissional(@PathVariable int id) throws ResourceNotFoundException {
        return service.deleteProfissional(id);
    }


}
