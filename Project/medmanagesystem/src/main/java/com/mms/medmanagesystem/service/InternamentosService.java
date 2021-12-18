package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.model.Internamentos;
import com.mms.medmanagesystem.model.Paciente;
import com.mms.medmanagesystem.repository.InternamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

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

    public Internamentos getInternamentosById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Internamentos getInternamentosByPaciente(Paciente paciente) {
        return repository.findByPaciente(paciente);
    }

    public String deleteInternamentos(int cc) {
        repository.deleteById(cc);
        return "Internamentos removed !! " + cc;
    }

    public Internamentos updateInternamentos(Internamentos Internamentos) {
        Internamentos existingInternamento = repository.findById(Internamentos.getIdInternamento()).orElse(null);
        existingInternamento.setIdPaciente(Internamentos.getIdPaciente());
        existingInternamento.setPulso(Internamentos.getPulso());
        existingInternamento.setTemperatura(Internamentos.getTemperatura());
        existingInternamento.setPressaoArterial(Internamentos.getPressaoArterial());
        existingInternamento.setRazaoInternamento(Internamentos.getRazaoInternamento());
        existingInternamento.setOxigenio(Internamentos.getOxigenio());
        existingInternamento.setCama(Internamentos.getCama());
        existingInternamento.setQuarto(Internamentos.getQuarto());
        existingInternamento.setEstado(Internamentos.getEstado());
        existingInternamento.setDataAdmissao(Internamentos.getDataAdmissao());
        existingInternamento.setDataSaida(Internamentos.getDataSaida());
        return repository.save(existingInternamento);
    }
}
 