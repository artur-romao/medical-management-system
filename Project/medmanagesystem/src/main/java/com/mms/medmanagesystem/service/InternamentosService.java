package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Internamentos;
import com.mms.medmanagesystem.repository.InternamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InternamentosService {
    @Autowired
    private InternamentosRepository repository;

    public Internamentos saveInternamentos(Internamentos internamento) {
        return repository.save(internamento);
    }

    public List<Internamentos> saveInternamentos(List<Internamentos> internamentos) {
        return repository.saveAll(internamentos);
    }

    public List<Internamentos> getInternamentos() {
        return repository.findAll();
    }

    public Internamentos getInternamentosById(int id) throws ResourceNotFoundException {
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Internamentos not found for this id:" + id));
        //return ResponseEntity.ok().body(internamentos);
    }

    public Map<String, Boolean> deleteInternamentos(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Internamentos not found for this id: " + id));
    
        repository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;    
    }

    public Internamentos updateInternamentos(int id, Internamentos Internamentos) throws ResourceNotFoundException {
        Internamentos existingInternamento = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Internamentos not found for this id: " + id));

        existingInternamento.setPaciente(Internamentos.getPaciente());
        existingInternamento.setPulso(Internamentos.getPulso());
        existingInternamento.setTemperatura(Internamentos.getTemperatura());
        existingInternamento.setPressaoArterial(Internamentos.getPressaoArterial());
        existingInternamento.setRazaoInternamento(Internamentos.getRazaoInternamento());
        existingInternamento.setOxigenio(Internamentos.getOxigenio());
        existingInternamento.setQuarto_cama(Internamentos.getQuarto_cama());
        existingInternamento.setEstado(Internamentos.getEstado());
        existingInternamento.setDataAdmissao(Internamentos.getDataAdmissao());
        existingInternamento.setDataSaida(Internamentos.getDataSaida());
        
        return repository.save(existingInternamento);
    }
}
