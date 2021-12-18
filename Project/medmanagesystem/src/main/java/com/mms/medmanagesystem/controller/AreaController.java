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
import com.mms.medmanagesystem.model.Area;
import com.mms.medmanagesystem.service.AreaService;

@RestController
@RequestMapping("/api/v3")

public class AreaController {

    @Autowired
    private AreaService service;
    
     @GetMapping("/areas")
    public List<Area> getAllAreas() {
        return service.getAreas();
    }

   
    @GetMapping("/areas/{id}")
    public Area getAreaById(@PathVariable(value="id") int area_id) throws ResourceNotFoundException {
        Area area = service.getAreaByIDArea(area_id);
        return area;

    }
  

    @PostMapping("/areas")
    public Area createArea(@Valid @RequestBody Area area){
        return service.saveArea(area);
    }

  
    @PutMapping("/areas/{id}")
    public Area updateArea(@PathVariable("id") int id, @RequestBody Area area) {
        //tentar trabalhar com exceptions
       return service.updateArea(id, area);
    }
        /*
         @Valid @RequestBody Area AreaDetails)  {
        Area Area = service.getAreaByCc(Area_cc);
        //.orElseThrow(() -> new ResourceNotFoundException("Nenhuma Area encontrada com este CC " + Area_cc)); not working 
        service.updateArea(Area);*/

    @DeleteMapping("/areas/{id}")
    public String deleteArea(@PathVariable int id) {
        return service.deleteArea(id);
    }



}
