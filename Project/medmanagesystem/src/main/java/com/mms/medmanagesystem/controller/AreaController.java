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
import com.mms.medmanagesystem.model.Area;
import com.mms.medmanagesystem.service.AreaService;

@RestController
@RequestMapping("/api/v1")

public class AreaController {

    @Autowired
    private AreaService service;
    
     @GetMapping("/areas")
    public List<Area> getAllAreas() {
        return service.getAreas();
    }

   
    @GetMapping("/areas/{id}")
    public Area getAreaById(@PathVariable(value="id") int area_id) throws ResourceNotFoundException {
        return service.getAreaByIDArea(area_id);
    }
  

    @PostMapping("/areas")
    public Area createArea(@Valid @RequestBody Area area){
        return service.saveArea(area);
    }

  
    @PutMapping("/areas/{id}")
    public Area updateArea(@PathVariable("id") int id, @Valid @RequestBody Area area) throws ResourceNotFoundException {
       return service.updateArea(id, area);
    }

    @DeleteMapping("/areas/{id}")
    public Map<String, Boolean> deleteArea(@PathVariable int id) throws ResourceNotFoundException {
        return service.deleteArea(id);
    }



}
