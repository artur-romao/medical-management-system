package com.mms.medmanagesystem.services;

import com.mms.medmanagesystem.models.Vacina;
import com.mms.medmanagesystem.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class VacinaService {
    @Autowired
    private VacinaRepository repository;

    public Vacina savevacina(Vacina vacina) {
        return repository.save(vacina);
    }

    public List<Vacina> savevacinas(List<Vacina> vacinas_disponiveis) {
        return repository.saveAll(vacinas_disponiveis);
    }

    public List<Vacina> getvacinas() {
        return repository.findAll();
    }

    public Vacina getvacinaByIDvacina(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deletevacina(int id) {
        repository.deleteById(id);
        return "Vacina removed !! " + id;
    }
    
    public Vacina updatevacina(Vacina vacina) {
        //Duvida aqui, como vamos fazer isto sem id?
        Vacina existingvacinas = repository.findById(vacina.getIdVacina()).orElse(null);
        existingvacinas.setNome(vacina.getNome());
        existingvacinas.setPatologia(vacina.getPatologia());
        return repository.save(existingvacinas);
        
    }
    
}
