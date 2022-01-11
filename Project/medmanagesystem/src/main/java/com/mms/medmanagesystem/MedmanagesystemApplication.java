package com.mms.medmanagesystem;
import javax.transaction.Transactional;

import com.mms.medmanagesystem.service.*;
import com.mms.medmanagesystem.model.*;
import com.mms.medmanagesystem.repository.*;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableRabbit
@SpringBootApplication 
public class MedmanagesystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MedmanagesystemApplication.class, args);
	}

	
	@Autowired
	private AreaRepository areaRepository;
	@Autowired
	private ConsultaRepository consultaRepository;
	@Autowired
	private InternamentosRepository internamentosRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	


		@Override
		public void run(String... args) throws Exception {
			Pessoa maia = new Pessoa(75766646, "Maia Mitchell", "maiamitchell@hotmail.com", 966265836, "Rua Manuel de Mendes nº1, Aveiro", "21/10/1984");
			Area pneumologia = new Area(1, "Pneumologia");
			Medico draMaia = new Medico(1,"7576664675766646", maia, pneumologia);
			pessoaRepository.save(maia);
			areaRepository.save(pneumologia);
			medicoRepository.save(draMaia);

		}

}
