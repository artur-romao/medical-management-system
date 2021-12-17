package com.mms.medmanagesystem.services;

import com.mms.medmanagesystem.models.Pac_vac;
import com.mms.medmanagesystem.repository.Pac_vacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

public class Pac_vacinaService {
    @Autowired
    private Pac_vacRepository repository;

    public Pac_vac savePac_vac(Pac_vac paciente_vacina) {
        return repository.save(paciente_vacina);
    }

    public List<Pac_vac> savePac_vacs(List<Pac_vac> pacientes_vacinas) {
        return repository.saveAll(pacientes_vacinas);
    }

    public List<Pac_vac> getPac_vacs() {
        return repository.findAll();
    }

    public Pac_vac getPac_vacByIDPac_vac(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deletePac_vac(int id) {
        repository.deleteById(id);
        return "Pac_vac removed !! " + id;
    }

    public Pac_vac updatePac_vac(Pac_vac Pac_vac) {
        //Duvida aqui, como vamos fazer isto sem id?
        Pac_vac existingPac_vac = repository.findPatient(Pac_vac.getpaciente(), Pac_vac.getvacina());
        existingPac_vac.setpaciente(Pac_vac.getpaciente());
        existingPac_vac.setvacina(Pac_vac.getvacina());
        return repository.save(existingPac_vac);
        
    }
}
 