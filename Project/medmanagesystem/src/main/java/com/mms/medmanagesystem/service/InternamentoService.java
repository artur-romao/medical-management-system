package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.repository.InternamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InternamentoService {
    @Autowired
    private InternamentoRepository repository;

    public Internamento saveInternamento(Internamento internamento) {
        return repository.save(internamento);
    }

    public List<Internamento> saveInternamento(List<Internamento> internamento) {
        return repository.saveAll(internamento);
    }

    public List<Internamento> getInternamento() {
        return repository.findAll();
    }

    public Internamento getInternamentoById(int id) throws ResourceNotFoundException {
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Internamento not found for this id:" + id));
        //return ResponseEntity.ok().body(internamento);
    }

    public Map<String, Boolean> deleteInternamento(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Internamento not found for this id: " + id));
    
        repository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;    
    }

    public Internamento updateInternamento(int id, Internamento Internamento) throws ResourceNotFoundException {
        Internamento existingInternamento = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Internamento not found for this id: " + id));

        existingInternamento.setPaciente(Internamento.getPaciente());
        existingInternamento.setPulso(Internamento.getPulso());
        existingInternamento.setTemperatura(Internamento.getTemperatura());
        existingInternamento.setPressaoArterial(Internamento.getPressaoArterial());
        existingInternamento.setRazaoInternamento(Internamento.getRazaoInternamento());
        existingInternamento.setOxigenio(Internamento.getOxigenio());
        existingInternamento.setQuarto_cama(Internamento.getQuarto_cama());
        existingInternamento.setEstado(Internamento.getEstado());
        existingInternamento.setDataAdmissao(Internamento.getDataAdmissao());
        existingInternamento.setDataSaida(Internamento.getDataSaida());
        
        return repository.save(existingInternamento);
    }
}
