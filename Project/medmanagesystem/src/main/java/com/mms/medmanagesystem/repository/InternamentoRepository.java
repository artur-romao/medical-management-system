package com.mms.medmanagesystem.repository;

import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InternamentoRepository extends JpaRepository<Internamento,Integer> {
    Internamento findByPaciente(Paciente paciente);
}
 //tabela internadoo tem uma coluna com o array
 // get array
 // handle (mudar os valores q quero)
 // envio o novo array


// set, get , coluna nova
// função de handle
// cada metrica manda um int , o seu nome e o id do internado