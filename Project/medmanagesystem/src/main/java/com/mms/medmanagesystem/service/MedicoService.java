package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Medico;
import com.mms.medmanagesystem.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    public Medico saveMedico(Medico medico) {
        return repository.save(medico);
    }

    public List<Medico> saveMedicos(List<Medico> medicos) {
        return repository.saveAll(medicos);
    }

    public List<Medico> getMedicos() {
        return repository.findAll();
    }

    public Medico getMedicoByID(int id) throws ResourceNotFoundException {
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Medico not found for this id:" + id));
    }


    public Map<String, Boolean> deleteMedico(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Medico not found for this id:" + id));
        
        repository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    public Medico updateMedico(int id, Medico Medico) throws ResourceNotFoundException {
        Medico existingMedico = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Medico not found for this id:" + id));
        
        existingMedico.setMedico(Medico.getMedico());
        //existingMedico.setArea(Medico.getArea());
        existingMedico.setPassword(Medico.getPassword());
        
        return repository.save(existingMedico);
    }
}
