package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.model.Area;
import com.mms.medmanagesystem.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

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

    public Area getAreaByIDArea(int id) {
        return repository.findById(id).orElse(null);
    }

    public Area getAreaByName(String name) {
        return repository.findByName(name);
    }

    public String deleteArea(int id) {
        repository.deleteById(id);
        return "Area removed !! " + id;
    }

    public Area updateArea(int id, Area Area) {
        Area existingArea = repository.findById(id).orElse(null);
        existingArea.setName(Area.getName());
        existingArea.setIdArea(Area.getIdArea());
        return repository.save(existingArea);
    }
}
