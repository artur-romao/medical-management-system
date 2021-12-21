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
import com.mms.medmanagesystem.model.Internamentos;
import com.mms.medmanagesystem.service.InternamentosService;

@RestController
@RequestMapping("/api/v3")
public class InternamentosController {

    @Autowired
    private InternamentosService service;
    
     @GetMapping("/internamentos")
    public List<Internamentos> getAllInternados() {
        return service.getInternamentos();
    }

   
    @GetMapping("/internamentos/{id}")
    public Internamentos getInternamentosId(@PathVariable(value="id") int internamento_id) throws ResourceNotFoundException {
        Internamentos Internamentos = service.getInternamentosById(internamento_id);
        return Internamentos;

    }

    @PostMapping("/internamentos")
    public Internamentos createInternamentos(@Valid @RequestBody Internamentos internamento){
        return service.saveInternamentos(internamento);
    }

  
    @PutMapping("/internamentos/{id}")
    public Internamentos updateInternamentos(@PathVariable("id") int id, @Valid @RequestBody Internamentos internamentos) throws ResourceNotFoundException {
       return service.updateInternamentos(id, internamentos);
    }


    @DeleteMapping("/internamentos/{id}")
    public Map<String, Boolean> deletePatients(@PathVariable int id) throws ResourceNotFoundException {
        return service.deleteInternamentos(id);
    }



}
