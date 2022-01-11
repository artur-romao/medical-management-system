package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Area;
import com.mms.medmanagesystem.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AreaService {
    @Autowired
    private AreaRepository repository;

    public Area saveArea(Area area) {
        return repository.save(area);
    }

    public List<Area> saveAreas(List<Area> areas) {
        return repository.saveAll(areas);
    }

    public List<Area> getAreas() {
        return repository.findAll();
    }

    public Area getAreaByIDArea(int id) throws ResourceNotFoundException {
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Area not found for this id:" + id));
        // return ResponseEntity.ok().body(area);
    }

    public Area getAreaByName(String name) {
        return repository.findByName(name);
    }

    public Map<String, Boolean> deleteArea(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Area not found for this id:" + id));
        
        repository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;    
    }

    public Area updateArea(int id, Area Area) throws ResourceNotFoundException {
        Area existingArea = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Area not found for this id:" + id));
        
        existingArea.setName(Area.getName());
        existingArea.setId(Area.getId());
        return repository.save(existingArea);
    }
}
