/* package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Vacina;
import com.mms.medmanagesystem.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
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

    public Vacina getVacinaByIDvacina(int id) throws ResourceNotFoundException {
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Vacina not found for this id:" + id));
    }

    public Map<String, Boolean> deleteVacina(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vacina not found for this id:" + id));
        
        repository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;    
    }
    
    public Vacina updateVacina(int id, Vacina vacina) throws ResourceNotFoundException {
        Vacina existingvacinas = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Vacina not found for this id:" + id));
        
        existingvacinas.setName(vacina.getName());
        existingvacinas.setPatologia(vacina.getPatologia());
        return repository.save(existingvacinas);
        
    }
    
}
 */