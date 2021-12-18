package com.mms.medmanagesystem.service;

import com.mms.medmanagesystem.model.Pessoa;
import com.mms.medmanagesystem.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return repository.findByNome(name);
    }

    public String deletePessoa(int cc) {
        repository.deleteById(cc);
        return "Pessoa removed !! " + cc;
    }

    public Pessoa updatePessoa(Pessoa pessoa) {
        Pessoa existingPessoa = repository.findById(pessoa.getCC()).orElse(null);
        existingPessoa.setNome(pessoa.getNome());
        existingPessoa.setEmail(pessoa.getEmail());
        existingPessoa.setTelemovel(pessoa.getTelemovel());
        existingPessoa.setMorada(pessoa.getMorada());
        return repository.save(existingPessoa);
    }
}
 