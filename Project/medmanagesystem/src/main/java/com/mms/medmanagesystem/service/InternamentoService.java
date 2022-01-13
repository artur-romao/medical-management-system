package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.repository.InternamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mms.medmanagesystem.messageBroker.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public List<Internamento> getInternamentos() {
        return repository.findAll();
    }

    public Set<Internamento> getAllInternamentosById(int... id_internamento) throws ResourceNotFoundException {
    // Creating an empty Set

        Set<Internamento> s = new HashSet<>();
        for (int id : id_internamento){
            Internamento intern = repository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Internamento not found for this id:" + id));
            s.add(intern);
        }

        return s;
	}

    public Internamento getInternamentoById(int id_internamento) throws ResourceNotFoundException{
        
        return repository.findById(id_internamento).orElse(null);

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
        //existingInternamento.setPulso(Internamento.getPulso());
        existingInternamento.setTemperatura(Internamento.getTemperatura());
        existingInternamento.setPressaoarterial(Internamento.getPressaoarterial());
        existingInternamento.setRazaointernamento(Internamento.getRazaointernamento());
        existingInternamento.setOxigenio(Internamento.getOxigenio());
        existingInternamento.setQuartocama(Internamento.getQuartocama());
        existingInternamento.setEstado(Internamento.getEstado());
        existingInternamento.setDataadmissao(Internamento.getDataadmissao());
        existingInternamento.setDatasaida(Internamento.getDatasaida());
        
        return repository.save(existingInternamento);
    }


}
