package com.mms.medmanagesystem.services;
/*
import com.mms.medmanagesystem.models.Pessoa;
import com.mms.medmanagesystem.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public Pessoa savePessoa(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public List<Pessoa> savePessoas(List<Pessoa> pessoas) {
        return repository.saveAll(pessoas);
    }

    public List<Pessoa> getPessoas() {
        return repository.findAll();
    }

    public Pessoa getPessoaByCc(int cc) {
        return repository.findById(cc).orElse(null);
    }

    public Pessoa getPessoaByName(String name) {
        return repository.findByName(name);
    }

    public String deletePessoa(int id) {
        repository.deleteById(id);
        return "Pessoa removed !! " + id;
    }

    public Pessoa updatePessoa(Pessoa Pessoa) {
        Pessoa existingPessoa = repository.findById(Pessoa.getCC()).orElse(null);
        existingPessoa.setName(Pessoa.getName());
        existingPessoa.setQuantity(Pessoa.getQuantity());
        existingPessoa.setPrice(Pessoa.getPrice());
        return repository.save(existingPessoa);
    }
}
*/