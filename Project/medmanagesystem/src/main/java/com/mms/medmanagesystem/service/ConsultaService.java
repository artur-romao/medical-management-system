package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Consulta;
import com.mms.medmanagesystem.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository repository;

    public Consulta saveConsulta(Consulta Consulta) { return repository.save(Consulta); }

    public List<Consulta> saveConsultas(List<Consulta> Consultas) { return repository.saveAll(Consultas); }

    public List<Consulta> getConsultas() { return repository.findAll(); }

    public Consulta getConsultaByID(int id) throws ResourceNotFoundException {
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Consulta not found for this id:" + id));
    }

	public Set<Consulta> getAllConsultasById(int... id_consulta) throws ResourceNotFoundException {
        // Creating an empty Set

        Set<Consulta> s = new HashSet<>();
		for (int id : id_consulta){
            Consulta cons = repository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Consulta not found for this id:" + id));
            s.add(cons);
        }

		return s;
	}

    public Map<String, Boolean> deleteConsulta(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Consulta not found for this id:" + id));
        
        repository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;    
    }

    public Consulta updateConsulta(Consulta consulta) throws ResourceNotFoundException {
        Consulta existingConsulta = repository.findById(consulta.getId())
        .orElseThrow(() -> new ResourceNotFoundException("Consulta not found for this id:" + consulta.getId()));
        
        existingConsulta.setAnotacoes(consulta.getAnotacoes());

        return repository.save(existingConsulta);
    }

}

