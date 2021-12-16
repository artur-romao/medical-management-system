/* package com.mms.medmanagesystem.services;

import com.mms.medmanagesystem.models.Internado;
import com.mms.medmanagesystem.models.Paciente;
import com.mms.medmanagesystem.repository.InternadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

public class InternadoService {
    @Autowired
    private InternadoRepository repository;

    public Internado saveInternado(Internado internamento) {
        return repository.save(internamento);
    }

    public List<Internado> saveInternados(List<Internado> internamentos) {
        return repository.saveAll(internamentos);
    }

    public List<Internado> getInternados() {
        return repository.findAll();
    }

    public Internado getInternamentoById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Internado getInternamentosByPaciente(Paciente paciente) {
        return repository.findByPaciente(paciente);
    }

    public String deleteInternado(int cc) {
        repository.deleteById(cc);
        return "Internado removed !! " + cc;
    }

    public Internado updateInternado(Internado Internado) {
        Internado existingInternamento = repository.findById(Internado.getIdInternamento()).orElse(null);
        existingInternamento.setIdPaciente(Internado.getIdPaciente());
        existingInternamento.setPulso(Internado.getPulso());
        existingInternamento.setTemperatura(Internado.getTemperatura());
        existingInternamento.setPressaoArterial(Internado.getPressaoArterial());
        existingInternamento.setFreqRespiratoria(Internado.getFreqRespiratoria());
        existingInternamento.setRazaoInternamento(Internado.getRazaoInternamento());
        existingInternamento.setOxigenio(Internado.getOxigenio());
        existingInternamento.setCama(Internado.getCama());
        existingInternamento.setQuarto(Internado.getQuarto());
        existingInternamento.setEstado(Internado.getEstado());
        existingInternamento.setDataAdmissao(Internado.getDataAdmissao());
        existingInternamento.setDataSaida(Internado.getDataSaida());
        return repository.save(existingInternamento);
    }
}
 */