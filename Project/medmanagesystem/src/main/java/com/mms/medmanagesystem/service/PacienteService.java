package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Consulta;
import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.model.Paciente;
import com.mms.medmanagesystem.model.Pessoa;
import com.mms.medmanagesystem.repository.ConsultaRepository;
import com.mms.medmanagesystem.repository.InternamentoRepository;
import com.mms.medmanagesystem.repository.PacienteRepository;
import com.mms.medmanagesystem.repository.PessoaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PacienteService {
  
    @Autowired
    private PacienteRepository repository;
    @Autowired
    private ConsultaRepository crep;
    @Autowired
    private InternamentoRepository irep;
    @Autowired
    private PessoaRepository pessoarep;



    public Paciente savePaciente(Paciente paciente) {

        // Pessoa pessoa = paciente.getPessoa();
        // System.out.println(pessoa);
        // pessoaService.savePessoa(pessoa);

        return repository.save(paciente);
    }

    public List<Paciente> savePacientes(List<Paciente> pacientes) {
        return repository.saveAll(pacientes);
    }

    public List<Paciente> getPacientes() {
        return repository.findAll();
    }

    // public List<Consulta> getConsultas() {
    //     return consultarepo.findAll();
    // }

    // public List<Internamento> getInternamentos() {
    //     return internamentorepo.findAll();
    // }

    public Paciente getPacienteById(int id) throws ResourceNotFoundException {
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Paciente not found for this id:" + id));
    }

    /* public Paciente getPacienteBycc(int cc) throws ResourceNotFoundException {
        return repository.findCc(cc);
    } */
    
    public List<Paciente> findKeyword(String keyword)  {

        return repository.findKeyword(keyword);
    }

    public Map<String, Boolean> deletePaciente(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Paciente not found for this id:" + id));

        repository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;    

    }

    public Paciente updatePaciente(Paciente paciente) throws ResourceNotFoundException {

        Paciente existingPaciente = repository.findById(paciente.getId())
        .orElseThrow(() -> new ResourceNotFoundException("Paciente not found for this id:" + paciente.getId()));
        
        return repository.save(existingPaciente);
    }

    public List<Paciente> findKeyword(String keyword)  {
        return repository.findKeyword(keyword);
    }



}
 

