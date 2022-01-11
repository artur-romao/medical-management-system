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
	private InternamentoRepository internamentoRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private AreaService areaService;

	@Override
	public void run(String... args) throws Exception {

		if (areaService.getAreas().size() == 0) {
			areaRepository.save(new Area(1, "Cardiologia"));
			areaRepository.save(new Area(2, "Cirugia I"));
			areaRepository.save(new Area(3, "Cirugia II"));
			areaRepository.save(new Area(4, "Dermatologia"));
			areaRepository.save(new Area(5, "Gastrenterologia"));
			areaRepository.save(new Area(6, "Ginecologia-Obstetrícia"));
			areaRepository.save(new Area(7, "Hematologia"));
			areaRepository.save(new Area(8, "Imagiologia"));
			areaRepository.save(new Area(9, "Imunoalergologia"));
			areaRepository.save(new Area(10, "Medicina Geral"));
			areaRepository.save(new Area(11, "Neurologia"));
			areaRepository.save(new Area(12, "Oncologia"));
			areaRepository.save(new Area(13, "Pediatria"));
			areaRepository.save(new Area(14, "Pneumologia"));
			areaRepository.save(new Area(15, "Psicologia"));
			areaRepository.save(new Area(16, "Psiquiatria"));
			
		}

		if (med.get)
		Pessoa maia = new Pessoa(75766646, "Maia Mitchell", "maiamitchell@hotmail.com", 966265836, "Rua Manuel de Mendes nº1, Aveiro", "21/10/1984");
		pessoaRepository.save(maia);
		
		Medico draMaia = new Medico(1,"7576664675766646", maia, areaRepository.getById(14));
		medicoRepository.save(draMaia);		
		

	}

}

