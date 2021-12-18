package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.model.Vacina;
import com.mms.medmanagesystem.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class VacinaService {
    @Autowired
    private VacinaRepository repository;

    public Vacina saveVacina(Vacina vacina) {
        return repository.save(vacina);
    }

    public List<Vacina> saveVacinas(List<Vacina> vacinas_disponiveis) {
        return repository.saveAll(vacinas_disponiveis);
    }

    public List<Vacina> getVacinas() {
        return repository.findAll();
    }

    public Vacina getVacinaByIDvacina(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteVacina(int id) {
        repository.deleteById(id);
        return "Vacina removed !! " + id;
    }
    
    public Vacina updateVacina(int id, Vacina vacina) {
        Vacina existingvacinas = repository.findById(id).orElse(null);
        existingvacinas.setNome(vacina.getNome());
        existingvacinas.setPatologia(vacina.getPatologia());
        return repository.save(existingvacinas);
        
    }
    
}
