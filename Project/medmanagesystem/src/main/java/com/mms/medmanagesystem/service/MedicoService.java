package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.model.Medico;
import com.mms.medmanagesystem.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

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

    public Medico getMedicoByIDMedico(int id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteMedico(int id) {
        repository.deleteById(id);
        return "Medico removed !! " + id;
    }

    public Medico updateMedico(int id, Medico Medico) {
        Medico existingMedico = repository.findById(id).orElse(null);
        existingMedico.setCc(Medico.getCc());
        existingMedico.setArea(Medico.getArea());
        existingMedico.setPassword(Medico.getPassword());
        return repository.save(existingMedico);
    }
}
