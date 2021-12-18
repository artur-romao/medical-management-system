package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.model.Consulta;
import com.mms.medmanagesystem.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Consulta updateConsulta(int id_consulta, Consulta consulta) {
        Consulta existingConsulta = repository.findById(id_consulta).orElse(null);
        existingConsulta.setIdMedico(consulta.getIdMedico());
        existingConsulta.setId(consulta.getId());
        existingConsulta.setIdPaciente(consulta.getIdPaciente());
        existingConsulta.setMotivo(consulta.getMotivo());
        existingConsulta.setData(consulta.getData());
        existingConsulta.setAnotacoes(consulta.getAnotacoes());

        return repository.save(existingConsulta);
    }
}

