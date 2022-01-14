package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Consulta;
import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.model.Paciente;
import com.mms.medmanagesystem.repository.ConsultaRepository;
import com.mms.medmanagesystem.repository.InternamentoRepository;
import com.mms.medmanagesystem.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;
    private ConsultaRepository crep;
    private InternamentoRepository irep;


    public Paciente savePaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> savePacientes(List<Paciente> pacientes) {
        return repository.saveAll(pacientes);
    }

    public List<Paciente> getPacientes() {
        return repository.findAll();
    }

    public Paciente getPacienteById(int id) throws ResourceNotFoundException {
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Paciente not found for this id:" + id));
    }

    public Map<String, Boolean> deletePaciente(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Paciente not found for this id:" + id));

        repository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;    

    }

    public Paciente updatePaciente(int id, Paciente paciente) throws ResourceNotFoundException {
        Paciente existingPaciente = repository.findById(paciente.getId())
        .orElseThrow(() -> new ResourceNotFoundException("Paciente not found for this id:" + id));
        
        // existingPaciente.setAssMedico(paciente.getAssMedico());
        //existingPaciente.setInternamentos(paciente.getInternamentos());
        return repository.save(existingPaciente);
    }

    // public void updatePacienteCI(Paciente paciente, Set<Consulta> consultas, Set<Internamento> internamentos) throws ResourceNotFoundException {
    //     Paciente existingPaciente = repository.findById(paciente.getId())
    //     .orElseThrow(() -> new ResourceNotFoundException("Paciente not found for this id:"));

    //     repository.save(existingPaciente);

    // }

}
 

