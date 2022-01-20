/* package com.mms.medmanagesystem.service;
import com.mms.medmanagesystem.exception.*;
import com.mms.medmanagesystem.model.Doenca;
import com.mms.medmanagesystem.repository.DoencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class DoencaService {
    @Autowired
    private DoencaRepository repository;

    public Doenca saveDoenca(Doenca doenca) {
        return repository.save(doenca);
    }

    public List<Doenca> saveDoencas(List<Doenca> doencas) {
        return repository.saveAll(doencas);
    }

    public List<Doenca> getDoencas() {
        return repository.findAll();
    }

    public Doenca getDoencaBycc(int cc) throws ResourceNotFoundException {
            return repository.findById(cc)
            .orElseThrow(() -> new ResourceNotFoundException("Doenca not found for this cc:" + cc));
            //return ResponseEntity.ok().body(doenca);
    } 


    public Doenca getDoencaByName(String name) {
        return repository.findByNome(name);
    }

    public Map<String, Boolean> deleteDoenca(int cc) throws ResourceNotFoundException {
        
        repository.findById(cc).orElseThrow(() -> new ResourceNotFoundException("Doenca not found for this cc: " + cc));

        repository.deleteById(cc);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;    
    }

    public Doenca updateDoenca(int id, Doenca Doenca) throws ResourceNotFoundException {
        Doenca existingDoenca = repository.findById(Doenca.getid())
        .orElseThrow(() -> new ResourceNotFoundException("Doenca not found for this id : " + id));
        
        existingDoenca.setName(Doenca.getName());
        existingDoenca.setDescricao(Doenca.getDescricao());
        existingDoenca.setid(Doenca.getid());
        return repository.save(existingDoenca);
    }
}
 */