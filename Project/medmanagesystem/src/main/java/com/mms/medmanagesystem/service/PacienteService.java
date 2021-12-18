package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.model.Paciente;
import com.mms.medmanagesystem.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    public Paciente savePaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> savePacientes(List<Paciente> pacientes) {
        return repository.saveAll(pacientes);
    }

    public List<Paciente> getPacientes() {
        return repository.findAll();
    }

    public Paciente getPacienteById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deletePaciente(int id) {
        repository.deleteById(id);
        return "Paciente removed !! " + id;
    }

    public Paciente updatePaciente(int id, Paciente paciente) {
        Paciente existingPaciente = repository.findById(paciente.getId()).orElse(null);
        existingPaciente.setAssMedico(paciente.getAssMedico());
        existingPaciente.setInternamentos(paciente.getInternamentos());
        return repository.save(existingPaciente);
    }
}
 

