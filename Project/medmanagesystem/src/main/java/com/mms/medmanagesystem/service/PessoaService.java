package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.exception.*;
import com.mms.medmanagesystem.model.Pessoa;
import com.mms.medmanagesystem.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public Pessoa savePessoa(Pessoa pessoa) { return repository.save(pessoa); }

    public List<Pessoa> savePessoas(List<Pessoa> pessoas) { return repository.saveAll(pessoas); }

    public List<Pessoa> getPessoas() { return repository.findAll(); }

    public Pessoa getPessoaByName(String name) { return repository.findByName(name); }

    
    public Pessoa getPessoaBycc(int cc) throws ResourceNotFoundException {
        return repository.findById(cc)
        .orElseThrow(() -> new ResourceNotFoundException("Pessoa not found for this cc:" + cc));
    }
    

    public Map<String, Boolean> deletePessoa(Pessoa pessoa) throws ResourceNotFoundException {

        int cc = pessoa.getPessoacc();

        repository.findById(cc).orElseThrow(() -> new ResourceNotFoundException("Pessoa not found for this cc:" + cc));
    
        repository.deleteById(cc);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;  
    }

    public Pessoa updatePessoa(Pessoa pessoa) throws ResourceNotFoundException {
        
        Pessoa existingPessoa = repository.findById(pessoa.getPessoacc())
        .orElseThrow(() -> new ResourceNotFoundException("Pessoa not found for this cc:" + pessoa.getPessoacc()));

        existingPessoa.setName(pessoa.getName());
        existingPessoa.setEmail(pessoa.getEmail());
        existingPessoa.setTelemovel(pessoa.getTelemovel());
        existingPessoa.setMorada(pessoa.getMorada());
        return repository.save(existingPessoa);
    }
}

 