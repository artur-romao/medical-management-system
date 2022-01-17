package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.repository.InternamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class InternamentoService {
    @Autowired
    private InternamentoRepository repository;

    public Internamento saveInternamento(Internamento internamento) {
        return repository.save(internamento);
    }

    public List<Internamento> saveInternamento(List<Internamento> internamento) {
        return repository.saveAll(internamento);
    }

    public List<Internamento> getInternamentos() {
        return repository.findAll();
    }

    public Set<Internamento> getAllInternamentosById(int... id_internamento) throws ResourceNotFoundException {
    // Creating an empty Set

        Set<Internamento> s = new HashSet<>();
        for (int id : id_internamento){
            Internamento intern = repository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Internamento not found for this id:" + id));
            s.add(intern);
        }

        return s;
	}

    public Internamento getInternamentoById(int id) throws ResourceNotFoundException{
        
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Internamento not found for this id:" + id));

    }

    public Map<String, Boolean> deleteInternamento(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Internamento not found for this id: " + id));
    
        repository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;    
    }

    public Internamento updateInternamento(int id, Internamento Internamento) throws ResourceNotFoundException {
        Internamento existingInternamento = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Internamento not found for this id: " + id));

        existingInternamento.setPaciente(Internamento.getPaciente());
        //existingInternamento.setPulso(Internamento.getPulso());
        existingInternamento.setTemperatura(Internamento.getTemperatura());
        existingInternamento.setPressaoarterial(Internamento.getPressaoarterial());
        existingInternamento.setRazaointernamento(Internamento.getRazaointernamento());
        existingInternamento.setOxigenio(Internamento.getOxigenio());
        existingInternamento.setQuartocama(Internamento.getQuartocama());
        existingInternamento.setEstado(Internamento.getEstado());
        existingInternamento.setDataadmissao(Internamento.getDataadmissao());
        existingInternamento.setDatasaida(Internamento.getDatasaida());
        existingInternamento.setStatefilter(Internamento.getStatefilter());
        
        return repository.save(existingInternamento);
    }

    // public void updateInternamentoInfo(Internamento internamento, float oxigenio, Double[] pulso, Float[] pressaoArterial, float temperatura, String razaoInternamento, String quarto_cama, String estado, Date dataAdmissao, Date dataSaida) {
    
    // }
    public void updateStates(int idinternamento, String sensorname, int value ) throws ResourceNotFoundException{
        //definir ordem do array como PULSO POS 0, TEMPERATURA POS 1, OXIGENIO POS 2, PRESSÃO POS 3

        //get internado
        Internamento internado = repository.findById(idinternamento)
        .orElseThrow(() -> new ResourceNotFoundException("Internamento not found for this id: " + idinternamento));

        // get array
        int [] states = internado.getStatefilter();
        
        //manage array
        switch (sensorname){
            case "hb":
            states[0]= value;

            break;
            case "temp":
            states[1]= value;

            break;
            case "oxi":
            states[2]= value;

            break;
            case "press":
            states[3]= value;

            break;
            default:
            break;

        }
        //the value will be 0 for stable, 1 for danger, 2 for critical
        // its maximum value will define the current state
        // get maximum
        int maximum=-10;
        for (int i = 0; i < states.length; i++) {
            if (states[i]> maximum){
                maximum=states[i];
            }
        }
        //define current state
        if (maximum==0){
            internado.setEstado("estável");

        }else if(maximum ==1){
            internado.setEstado("grave");

        }else if (maximum ==2){
            internado.setEstado("coma");
        }else{ //keeps state in case of error
            internado.setEstado(internado.getEstado());
        }


        //send array
        internado.setStatefilter(states);
        this.updateInternamento(idinternamento,internado);

        
    }


}
