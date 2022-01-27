package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.enumFolder.ProfissionalEnum;
import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Profissional;
import com.mms.medmanagesystem.repository.PessoaRepository;
import com.mms.medmanagesystem.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProfissionalService {
    
    @Autowired private ProfissionalRepository repository;


    public Profissional saveProfissional(Profissional profissional) {
        return repository.save(profissional);
    }

    public List<Profissional> saveProfissionais(List<Profissional> profissionais) {
        return repository.saveAll(profissionais);
    }

    public List<Profissional> getProfissionais() {
        return repository.findAll();
    }
    
    public Profissional getProfissionalByID(int id) throws ResourceNotFoundException {
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Profissional not found for this id:" + id));
    }

   


    public Map<String, Boolean> deleteProfissional(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Profissional not found for this id:" + id));
        
        repository.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    public List<Profissional> findKeyword(String keyword)  {

        return repository.findKeyword(keyword);
    }

    public Profissional updateProfissional(int id, Profissional pro) throws ResourceNotFoundException {

        Profissional existingProfissional = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Profissional not found for this id:" + id ));
        
        existingProfissional.setArea(pro.getArea());
        existingProfissional.setPassword(pro.getPassword());

        return repository.save(existingProfissional);
    }
}
