package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Consulta;
import com.mms.medmanagesystem.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultaService {
    @Autowired
    private ConsultaRepository repository;

    public Consulta saveConsulta(Consulta Consulta) {
        return repository.save(Consulta);
    }

    public List<Consulta> saveConsultas(List<Consulta> Consultas) {
        return repository.saveAll(Consultas);
    }

    public List<Consulta> getConsultas() {
        return repository.findAll();
    }

    public Consulta getConsultaByIDConsulta(int id) throws ResourceNotFoundException {
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Consulta not found for this id:" + id));
        // return ResponseEntity.ok().body(consulta);
    }

    public Map<String, Boolean> deleteConsulta(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Consulta not found for this id:" + id));
        
        repository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;    
    }

    public Consulta updateConsulta(int id, Consulta consulta) throws ResourceNotFoundException {
        Consulta existingConsulta = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Consulta not found for this id:" + id));
        
        existingConsulta.setIdMedico(consulta.getIdMedico());
        existingConsulta.setId(consulta.getId());
        existingConsulta.setIdPaciente(consulta.getIdPaciente());
        existingConsulta.setMotivo(consulta.getMotivo());
        existingConsulta.setData(consulta.getData());
        existingConsulta.setAnotacoes(consulta.getAnotacoes());

        return repository.save(existingConsulta);
    }
}

