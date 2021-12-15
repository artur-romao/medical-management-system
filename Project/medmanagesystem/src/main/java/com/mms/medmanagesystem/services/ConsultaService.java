package com.mms.medmanagesystem.services;

import com.mms.medmanagesystem.models.Consulta;
import com.mms.medmanagesystem.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    public Consulta getConsultaByIDConsulta(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteConsulta(int id) {
        repository.deleteById(id);
        return "Consulta removed !! " + id;
    }

    public Consulta updateConsulta(Consulta Consulta) {
        Consulta existingConsulta = repository.findById(Consulta.getId()).orElse(null);
        existingConsulta.setIdMedico(Consulta.getName());
        existingConsulta.setIdConsulta(Consulta.getIdConsulta());
        return repository.save(existingConsulta);
    }
}

