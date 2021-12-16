package com.mms.medmanagesystem.services;

import com.mms.medmanagesystem.models.Pac_doenca;
import com.mms.medmanagesystem.repository.Pac_doencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

public class Pac_doencaService {
    @Autowired
    private Pac_doencaRepository repository;

    public Pac_doenca savePac_doenca(Pac_doenca paciente_doenca) {
        return repository.save(paciente_doenca);
    }

    public List<Pac_doenca> savePac_doencas(List<Pac_doenca> pacientes_doencas) {
        return repository.saveAll(pacientes_doencas);
    }

    public List<Pac_doenca> getPac_doencas() {
        return repository.findAll();
    }

    public Pac_doenca getPac_doencaByIDPac_doenca(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deletePac_doenca(int id) {
        repository.deleteById(id);
        return "Pac_doenca removed !! " + id;
    }

    public Pac_doenca updatePac_doenca(Pac_doenca Pac_doenca) {
        //Duvida aqui, como vamos fazer isto sem id?
        Pac_doenca existingPac_doenca = repository.findPatient(Pac_doenca.getPaciente(), Pac_doenca.getdoenca());
        existingPac_doenca.setpaciente(Pac_doenca.getPaciente());
        existingPac_doenca.setdoenca(Pac_doenca.getdoenca());
        return repository.save(existingPac_doenca);
        
    }
}
 